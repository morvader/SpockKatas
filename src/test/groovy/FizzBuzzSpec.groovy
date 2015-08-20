import spock.lang.Specification

/**
 * Created by francisco.moreno on 20/08/2015.
 */
class FizzBuzzSpec extends Specification {
    def "La secuencia de solo un elemento es 1"() {

        given: "Juego configurado hasta 1"
        FizzBuzzGame game = new FizzBuzzGame(1)

        when: "Obtengo secuencia de valores"
        def secuencia
        secuencia = game.getSecuencia()

        then: "El resultado tiene que ser 1"
        secuencia == ["1"]
    }

    def "La secuencia de 3 elementos es 1,2,Fizz"() {

        given: "Juego configurado hasta 3"
        FizzBuzzGame game = new FizzBuzzGame(3)

        when: "Obtengo secuencia de valores"
        def secuencia
        secuencia = game.getSecuencia()

        then: "El resultado tiene que ser 1,2,Fizz"
        secuencia == ["1", "2", "Fizz"]
    }

    def "La secuencia de 5 elementos es 1,2,Fizz,4,Buzz"() {
        given: "Juego configurado hasta 5"
        FizzBuzzGame game = new FizzBuzzGame(5)

        when: "Obtengo secuencia de valores"
        def secuencia
        secuencia = game.getSecuencia()

        then: "El resultado tiene que ser 1,2,Fizz,4,Buzz"
        secuencia == ["1", "2", "Fizz", "4", "Buzz"]
    }

    def "La secuencia de 15 elementos es 1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz,11,Fizz,13,14,FizzBuzz"() {
        given: "Juego configurado hasta 15"
        FizzBuzzGame game = new FizzBuzzGame(15)

        when: "Obtengo secuencia de valores"
        def secuencia
        secuencia = game.getSecuencia()

        then: "El resultado tiene que ser 1,2,Fizz,4,Buzz"
        secuencia == ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
    }

    def "Pruebas generales numeros Fizz Buzz"() {
        given:
        FizzBuzzGame game = new FizzBuzzGame()
        expect:
        game.getNumerFizzBuzz(n) == result

        where:
        n  | result
        1  | "1"
        3  | "Fizz"
        5  | "Buzz"
        25 | "Buzz"
        6  | "Fizz"
        15 | "FizzBuzz"
        17 | "17"
        30 | "FizzBuzz"
    }

}
