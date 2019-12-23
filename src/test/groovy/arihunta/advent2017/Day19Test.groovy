package arihunta.advent2017

import spock.lang.Specification

class Day19Test extends Specification {

	def "19-01"() {
		when: def result = Day19._01()
		then: result == "EPYDUXANIT"
	}

	def "19-02"() {
		when: def result = Day19._02()
		then: result == 17543
	}

}