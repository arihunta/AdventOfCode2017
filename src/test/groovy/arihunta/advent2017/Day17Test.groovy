package arihunta.advent2017

import spock.lang.Specification

class Day17Test extends Specification {

	def "17-01"() {
		when: def result = Day17._01()
		then: result == 866
	}

	def "17-02"() {
		when: def result = Day17._02()
		then: result == 11995607
	}

}
