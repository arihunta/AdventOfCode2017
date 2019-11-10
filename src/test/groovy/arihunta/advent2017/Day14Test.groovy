package arihunta.advent2017

import spock.lang.Specification

class Day14Test extends Specification {

	def "14-01"() {
		when: def result = Day14._01()
		then: result == 8250
	}

	def "14-02"() {
		when: def result = Day14._02()
		then: result == 1113
	}

}
