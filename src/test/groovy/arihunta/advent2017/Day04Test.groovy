package arihunta.advent2017

import spock.lang.Specification

class Day04Test extends Specification {

	def "04-01"() {
		when: def result = Day04._01()
		then: result == 383
	}

	def "04-02"() {
		when: def result = Day04._02()
		then: result == 265
	}

}
