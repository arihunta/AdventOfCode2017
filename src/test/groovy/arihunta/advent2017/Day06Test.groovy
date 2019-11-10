package arihunta.advent2017

import spock.lang.Specification

class Day06Test extends Specification {

	def "06-01"() {
		when: def result = Day06._01()
		then: result == 5042
	}

	def "06-02"() {
		when: def result = Day06._02()
		then: result == 1086
	}

}
