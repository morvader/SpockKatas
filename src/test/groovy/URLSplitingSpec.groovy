import spock.lang.Specification

/**
 * Created by francisco.moreno on 20/08/2015.
 *
 * DESCRIPTION
 * https://sites.google.com/site/tddproblems/all-problems-1/URL-splitting
 *
 * We all know URLs, http://www.google.se is a popular one.
 * Develop a class that decomposes a given URL into its constituents. In the above example, we would like to get the result
 *  The protocol: "http"
 *  The domain name: "www.google.se"
 *  The path: an empty string in our example.
 */
class URLSplitingSpec extends Specification {

    URLSpliter urlSpliter = new URLSpliter()

    def "La cadena vacia devuelve resultados vacios"() {

        when: "No se especifica URL"
        urlSpliter.URL = ""

        then: "Protocolo, dominio y path están vacios"
        urlSpliter.getProtocolo == ""
        urlSpliter.getDominio == ""
        urlSpliter.getPath == ""
    }

    def "La cadena nula devuelve resultados vacios"() {

        when: "No se especifica URL"
        //Equivalente a urlSpliter = null

        then: "Protocolo, dominio y path están vacios"
        urlSpliter.getProtocolo == ""
        urlSpliter.getDominio == ""
        urlSpliter.getPath == ""
    }

    def "Si no se especifica protolo este está vacio"() {
        when: "URL sin protolo"
        urlSpliter.URL = "www.google.es"

        then: "El protolo está vacio"
        urlSpliter.getProtocolo == ""
    }


    def "Se detectan diferentes tipos tipos de protocolos"() {
        setup:
        urlSpliter.URL = url
        expect: "Detección correcta de diferentes tipos de protocolos"
        protocolo == urlSpliter.getProtocolo

        where:
        url                      | protocolo
        "www.google.es"          | ""
        "http://www.google.es"   | "http"
        "http://google.es"       | "http"
        "ftp://mozilla.com/user" | "ftp"
        "https://www.gmail.com"  | "https"

    }


    def "Se detectan diferentes tipos tipos de dominios"() {
        setup:
        urlSpliter.URL = url
        expect: "Detección correcta de diferentes tipos de dominios"
        dominio == urlSpliter.getDominio

        where:
        url                                               | dominio
        ""                                                | ""
        "www.google.es"                                   | "www.google.es"
        "http://www.google.es"                            | "www.google.es"
        "http://google.es"                                | "google.es"
        "ftp://mozilla.com/user"                          | "mozilla.com"
        "https://www.gmail.com.es"                        | "www.gmail.com.es"
        "https://www.morvader.blogspot.com.es/index.html" | "www.morvader.blogspot.com.es"

    }

    def "Se detectan diferentes tipos tipos de paths"() {
        setup:
        urlSpliter.URL = url
        expect: "Detección correcta de diferentes tipos de dominios"
        path == urlSpliter.getPath

        where:
        url                                               | path
        ""                                                | ""
        "www.google.es"                                   | ""
        "http://www.google.es"                            | ""
        "http://google.es"                                | ""
        "ftp://mozilla.com/user"                          | "user"
        "https://www.gmail.com.es/morvader/test.jsp/home" | "morvader/test.jsp/home"
        "https://www.morvader.blogspot.com.es/index.html" | "index.html"

    }
}
