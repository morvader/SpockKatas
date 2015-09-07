/**
 * Created by francisco.moreno on 04/09/2015.
 */
class ConversorNumerosALetras {
    String convertir(int numero) {

        String unidades = ""
        String decenas = ""
        String centenas = ""

        def valores = descomposicionNumero(numero)
        String retorno = ""
        for (int i = valores.size() - 1; i >= 0; i--) {
            switch (i) {
            //Unidades de millar
                case 3:
                    //Caso de mil
                    if (valores[3] == 1)
                        retorno += "mil"
                    else {
                        retorno += unidadesACadena(valores[3]) + " mil"
                    }
                    break

            //Centenas
                case 2:
                    //Si es una centena concreta se devuelve directamente
                    if (numero % 100 == 0)
                        return centenasACadena(numero)
                    centenas = centenasACadena(valores[2] * 100)
                    retorno += retorno.empty ? centenas : " " + centenas
                    break
            //Decenas
                case 1:
                    //si es una decena concreta se devuelve directamente
                    if (numero % 10 == 0) {
                        decenas = decenasACadena(valores[1] * 10)
                        retorno += retorno.empty ? decenas : " " + decenas
                        return retorno
                    }
                    //si es menos de 20 es un caso especial
                    if (valores[1] <= 2) {
                        decenas = primeraVeintenaACadena(valores[1] * 10 + valores[0])
                        retorno += retorno.empty ? decenas : " " + decenas
                        return retorno
                    }
                    decenas = decenasACadena(valores[1] * 10)
                    retorno += retorno.empty ? decenas : " " + decenas
                    break
            //Unidades
                case 0:
                    unidades = unidadesACadena(valores[0])
                    retorno += retorno.empty ? unidades : " y " + unidades
                    break
                default:
                    return "Numero no valido"
            }
        }

        return retorno


    }

    public def descomposicionNumero(int numero) {

        def valores = []
        if (numero == 0)
            return [0]

        while (numero != 0) {
            valores << numero % 10
            numero /= 10
        }
        return valores
    }


    String primeraVeintenaACadena(int numero) {
        switch (numero) {
            case 10: return "diez"
            case 11: return "once"
            case 12: return "doce"
            case 13: return "trece"
            case 14: return "catorce"
            case 15: return "quince"
            case 16: return "dieciseis"
            case 17: return "diecisiete"
            case 18: return "dieciocho"
            case 19: return "diecinueve"
            case 20: return "veinte"
            case 21: return "veintiuno"
            case 22: return "veintidos"
            case 23: return "veintitres"
            case 24: return "veinticuantro"
            case 25: return "veinticinco"
            case 26: return "veintiseis"
            case 27: return "veintisiete"
            case 28: return "veintiocho"
            case 29: return "veintinuevo"

        }
    }

    String centenasACadena(int numero) {
        switch (numero) {
            case 100: return "cien"
            case 200: return "doscientos"
            case 300: return "trescientos"
            case 400: return "cuatrocientos"
            case 500: return "quinientos"
            case 600: return "seiscientos"
            case 700: return "setecientos"
            case 800: return "ochocientos"
            case 900: return "novecientos"
        }
        return ""
    }

    String decenasACadena(int numero) {
        switch (numero) {
            case 10: return "diez"
            case 20: return "veinte"
            case 30: return "treinta"
            case 40: return "cuarenta"
            case 50: return "cincuenta"
            case 60: return "sesenta"
            case 70: return "setenta"
            case 80: return "ochenta"
            case 90: return "noventa"
        }
        return ""
    }

    private String unidadesACadena(int numero) {
        switch (numero) {
            case 0: return "cero"
            case 1: return "uno"
            case 2: return "dos"
            case 3: return "tres"
            case 4: return "cuatro"
            case 5: return "cinco"
            case 6: return "seis"
            case 7: return "siete"
            case 8: return "ocho"
            case 9: return "nueve"
        }
        return ""
    }
}
