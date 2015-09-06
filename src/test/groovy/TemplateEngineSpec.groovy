import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by Moreno on 05/09/2015.
 *
 * URL : https://sites.google.com/site/tddproblems/all-problems-1/Template-engine
 *
 * Write a "template engine" meaning a way to transform template strings, "Hello {$name}" into "instanced" strings. To do that a variable->value mapping must be provided. For example, if name="Cenk" and the template string is "Hello {$name}" the result would be "Hello Cenk".

 - Should evaluate template single variable expression:

 mapOfVariables.put("name","Cenk");
 templateEngine.evaluate("Hello {$name}", mapOfVariables)
 =>   should evaluate to "Hello Cenk"

 - Should evaluate template with multiple expressions:

 mapOfVariables.put("firstName","Cenk");
 mapOfVariables.put("lastName","Civici");
 templateEngine.evaluate("Hello {$firstName} ${lastName}", mapOfVariables);
 =>   should evaluate to "Hello Cenk Civici"

 - Should give error if template variable does not exist in the map:

 map empty
 templateEngine.evaluate("Hello {$firstName} ", mapOfVariables);
 =>   should throw missingvalueexception

 - Should evaluate complex cases:

 mapOfVariables.put("name","Cenk");
 templateEngine.evaluate("Hello ${$name}}", mapOfVariables);
 =>   should evaluate to "Hello ${Cenk}"

 Example origin is Koskela's book
 http://www.amazon.com/Test-Driven-Acceptance-Java-Developers/dp/1932394850
 */
class TemplateEngineSpec extends Specification {

    def templateEngine = new TemplateEngine()
    HashMap<String, String> mapOfVariables = new HashMap<String, String>();

    def "Si el mapa de variables está vacio se lanza excepcion"() {

        given: "mapa de variables vacio"

        mapOfVariables.clear()
        String cadenaInicial = 'Cadena inicial {$variable}'

        when: "Se evalua la cadena"
        templateEngine.evaluate(cadenaInicial, mapOfVariables)

        then: "Se lanza excepcion"
        thrown MissingValuEexception

    }

    def "Si el mapa de variables no contiene la variable a sustutir se lanza excepcion"() {

        given: "mapa de variables con un nombre de variable que no existe en la cadena inicial"
        mapOfVariables = ["variableNotFound": "NotFound"]

        String cadenaInicial = 'Cadena inicial {$variable}'

        when: "Se evalua la cadena"
        templateEngine.evaluate(cadenaInicial, mapOfVariables)

        then: "Se lanza excepcion"
        mapOfVariables.size() == 1
        thrown MissingValuEexception

    }

    def "Si la cadena inicial no contiene variables a sustituir se devuelve la misma cadena"() {

        given: "la cadena inicial no contiene ninguna variable"
        mapOfVariables = ['variable': 'var']
        String cadenaInicial = 'Cadena inicial sin variables'

        when: "Se evalua la cadena"
        templateEngine.evaluate(cadenaInicial, mapOfVariables)

        then: "Se lanza una excepcion por variable no encontrada"
        mapOfVariables.size() == 1
        thrown MissingValuEexception

    }

    @Unroll
    def "Sustitucion de una variable"() {

        expect: "La variable es sustituida en la cadena"

        cadenaFinal == templateEngine.evaluate(cadenaInicial, variables)

        where:
        cadenaFinal                               | cadenaInicial                                             | variables
        'Mi nombre es Fran'                       | 'Mi nombre es {$nombre}'                                  | ['nombre': 'Fran']
        'Mi nombre completo es Francisco Moreno'  | 'Mi nombre completo es {$nombre} {$apellido}'             | ['nombre': 'Francisco', 'apellido': 'Moreno']
        'Dos sustituciones misma variable: 1 y 1' | 'Dos sustituciones misma variable: {$numero} y {$numero}' | ['numero': '1']
        'Sustitucion recursiva'                   | 'Sustitucion {${$recursiva}}'                             | ['recursiva': 'recursiva']
        'Mi nombre es {$Fran}'                    | 'Mi nombre es {${$nombre}}'                               | ['nombre': 'Fran']
        'Mi nombre es Francisco Moreno Sanz'      | 'Mi nombre es {${${$nombre}}}'                            | ['nombre': 'nombreApellido', 'nombreApellido': 'nombreYDosApellidos', 'nombreYDosApellidos': 'Francisco Moreno Sanz']
    }
}
