package arihunta.advent2017

import spock.lang.Specification

class Day12Test extends Specification {

	def "12-01"() {
		when: def result = Day12._01()
		then: result == 115
	}

	def "12-02"() {
		when: def result = Day12._02()
		then: result == 221
	}

}
