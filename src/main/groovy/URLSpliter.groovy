/**
 * Created by francisco.moreno on 20/08/2015.
 */
class URLSpliter {
    String URL

    final String protolocSeparator = "://"
    final String pathSeparator = "/"

    String getGetProtocolo() {
        def protoclo = ""
        def indexOfStartProtocolSeparator = URL?.indexOf(protolocSeparator)

        if (indexOfStartProtocolSeparator > 0)
            protoclo = URL.substring(0, indexOfStartProtocolSeparator)
        return protoclo
    }

    String getGetDominio() {

        if (URL == null || URL?.empty)
            return ""

        def dominio = URL
        def protocolo = getProtocolo

        dominio = dominio.replace(protocolo, "")
        dominio = dominio.replace(protolocSeparator, "")

        //Quitamos la parte del path si la hubiera
        def indexOfFirstPathSeparator = dominio.indexOf(pathSeparator)
        if (indexOfFirstPathSeparator > 0)
            dominio = dominio.substring(0, indexOfFirstPathSeparator)

        return dominio
    }

    String getGetPath() {
        if (URL == null || URL?.empty)
            return ""

        def dominio = this.getDominio
        def protocolo = this.getProtocolo

        //De la URL inicial eliminamos
        // El protocolo
        // El separador de protocolos
        // El dominio
        // El separador de Path
        def path = URL

        path = path.replace(protocolo, "")
        path = path.replace(protolocSeparator, "")
        path = path.replace(dominio, "")
        path = path.replaceFirst(pathSeparator, "")

        return path
    }
}
