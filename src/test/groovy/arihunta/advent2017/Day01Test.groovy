package arihunta.advent2017

import spock.lang.Specification

class Day01Test extends Specification {

	def "01-01"() {
		when: def result = Day01._01()
		then: result == 1144
	}

	def "01-02"() {
		when: def result = Day01._02()
		then: result == 1194
	}

}
