package arihunta.advent2017

import spock.lang.Specification

class Day08Test extends Specification {

	def "08-01"() {
		when: def result = Day08._01()
		then: result == 5849
	}

	def "08-02"() {
		when: def result = Day08._02()
		then: result == 6702
	}

}
