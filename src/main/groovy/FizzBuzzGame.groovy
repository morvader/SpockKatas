/**
 * Created by francisco.moreno on 20/08/2015.
 */

class FizzBuzzGame {
    def valorMaximoSecuencia;
    FizzBuzzGame(){}

    FizzBuzzGame(int valorMaximo){
        valorMaximoSecuencia = valorMaximo
    }

    def getSecuencia() {
        def secuenciaRetorno = []

        for (int i = 1; i <= valorMaximoSecuencia; i++) {

            secuenciaRetorno.add this.getNumerFizzBuzz(i)
        }
        return secuenciaRetorno
    }

    def getNumerFizzBuzz(int n){
        String numeroFizzBuzz = ""
        if(n%3 == 0)
            numeroFizzBuzz += "Fizz"

        if(n%5 == 0)
            numeroFizzBuzz+= "Buzz"

        if(numeroFizzBuzz.length() == 0)
            numeroFizzBuzz =  n

        return numeroFizzBuzz

    }
}
