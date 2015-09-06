/**
 * Created by Moreno on 05/09/2015.
 */
class TemplateEngine {
    String evaluate(String cadena, HashMap<String, String> mapOfVariables) {
        if (mapOfVariables.size() == 0)
            throw new MissingValuEexception()

        mapOfVariables.each {
            v ->
                String cadenaSustituir = this.getCadenaSustituirFromVariable(v.key)

                if (!this.buscaVariable(cadena, v.key))
                    throw new MissingValuEexception()

                //Bucle para sustituices recursivas
                // Caso de ejemplo:
                // Sustitucion {${$recursiva}} con 'recursiva':'recursiva' => Susticuion recursiva
                while (cadena.contains(cadenaSustituir))
                    cadena = cadena.replace(cadenaSustituir, v.value)
        }

        return cadena

    }

    private String getCadenaSustituirFromVariable(String variable) {
        return '{$' + variable + '}'
    }

    private boolean buscaVariable(String cadenaOriginal, String variable) {
        String variableSustituir = this.getCadenaSustituirFromVariable(variable)
        return cadenaOriginal.contains(variableSustituir)
    }
}

class MissingValuEexception extends Exception {

    @Override
    String getMessage() {
        return "Variable no encontrada"
    }
}
