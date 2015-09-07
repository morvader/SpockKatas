import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by francisco.moreno on 04/09/2015.
 */
class NumerosALetrasSpec extends Specification {

    def conversorNumerosALetras = new ConversorNumerosALetras()

    def "pruebas con unidades"() {

        expect:
        cadenaNumerica == conversorNumerosALetras.convertir(numero)
        where:
        cadenaNumerica | numero
        "cero"         | 0
        "uno"          | 1
        "dos"          | 2
        "tres"         | 3
        "cuatro"       | 4
        "cinco"        | 5
        "seis"         | 6
        "siete"        | 7
        "ocho"         | 8
        "nueve"        | 9

    }

    def "pruebas con decenas"() {

        expect:
        cadenaNumerica == conversorNumerosALetras.convertir(numero)
        where:
        cadenaNumerica | numero
        "diez"         | 10
        "veinte"       | 20
        "treinta"      | 30
        "cuarenta"     | 40
        "cincuenta"    | 50
        "sesenta"      | 60
        "setenta"      | 70
        "ochenta"      | 80
        "noventa"      | 90
    }

    def "pruebas con numeros del 10 al 20 "() {

        expect:
        cadenaNumerica == conversorNumerosALetras.convertir(numero)
        where:
        cadenaNumerica | numero
        "diez"         | 10
        "once"         | 11
        "doce"         | 12
        "trece"        | 13
        "catorce"      | 14
        "quince"       | 15
        "dieciseis"    | 16
        "diecisiete"   | 17
        "dieciocho"    | 18
        "diecinueve"   | 19
    }

    def "pruebas con centenas"() {

        expect:
        cadenaNumerica == conversorNumerosALetras.convertir(numero)
        where:
        cadenaNumerica  | numero
        "cien"          | 100
        "doscientos"    | 200
        "trescientos"   | 300
        "cuatrocientos" | 400
        "quinientos"    | 500
        "seiscientos"   | 600
        "setecientos"   | 700
        "ochocientos"   | 800
        "novecientos"   | 900
    }

    @Unroll
    def "pruebas con varios valores numericos"() {

        expect:
        cadenaNumerica == conversorNumerosALetras.convertir(numero)
        where:
        cadenaNumerica                      | numero
        "veinticinco"                       | 25
        "cuarenta y cinco"                  | 45
        "ochenta y siete"                   | 87
        "noventa y nueve"                   | 99
        "trescientos cincuenta y dos"       | 352
        "setecientos quince"                | 715
        "seiscientos cuarenta"              | 640
        "mil seiscientos cuarenta"          | 1640
        "cinco mil trescientos veinticinco" | 5325

    }


    def "prueba Descomposion numero"() {
        expect:
        valores == conversorNumerosALetras.descomposicionNumero(numero)
        where:
        valores   | numero
        [0]       | 0
        [5]       | 5
        [0, 1]    | 10
        [9, 1]    | 19
        [7, 8]    | 87
        [0, 0, 1] | 100
        [0, 2, 5] | 520

    }
}
