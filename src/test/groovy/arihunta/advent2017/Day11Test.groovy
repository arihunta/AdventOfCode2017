package arihunta.advent2017

import spock.lang.Specification

class Day11Test extends Specification {

	def "11-01"() {
		when: def result = Day11._01()
		then: result == 759
	}

	def "11-02"() {
		when: def result = Day11._02()
		then: result == 1501
	}

}
