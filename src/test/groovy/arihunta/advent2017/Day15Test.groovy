package arihunta.advent2017

import spock.lang.Specification

class Day15Test extends Specification {

	def "15-01"() {
		when: def result = Day15._01()
		then: result == 567
	}

	def "15-02"() {
		when: def result = Day15._02()
		then: result == 323
	}

}
