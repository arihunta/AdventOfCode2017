package arihunta.advent2017

import spock.lang.Specification

class Day18Test extends Specification {

	def "18-01"() {
		when: def result = Day18._01()
		then: result == 1187
	}

	def "18-02"() {
		when: def result = Day18._02()
		then: result == 5969
	}

}
