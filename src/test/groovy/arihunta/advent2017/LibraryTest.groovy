package arihunta.advent2017

import spock.lang.Specification

class LibraryTest extends Specification {

    def "01-01"() {
        when: def result = Day01._01()
        then: result == true
    }

}
