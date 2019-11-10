package arihunta.advent2017

import spock.lang.Specification

class Day13Test extends Specification {

	def "13-01"() {
		when: def result = Day13._01()
		then: result == 1900
	}

	def "13-02"() {
		when: def result = Day13._02()
		then: result == 3966414
	}

}
