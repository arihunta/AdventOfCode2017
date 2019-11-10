package arihunta.advent2017

import spock.lang.Specification

class Day09Test extends Specification {

	def "09-01"() {
		when: def result = Day09._01()
		then: result == 7640
	}

	def "09-02"() {
		when: def result = Day09._02()
		then: result == 4368
	}

}
