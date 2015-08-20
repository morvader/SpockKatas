import spock.lang.Specification

/**
 * Created by francisco.moreno on 20/08/2015.
 */
class testSpec extends Specification {

    def "adding an element leads to size increase"() {
        setup: "a new stack instance is created"
        def stack = new Stack()

        when:
        stack.push 42

        then:
        stack.size() == 1
    }
}