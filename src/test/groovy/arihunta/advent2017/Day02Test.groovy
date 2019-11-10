package arihunta.advent2017

import spock.lang.Specification

class Day02Test extends Specification {

	def "02-01"() {
		when: def result = Day02._01()
		then: result == 48357
	}

	def "02-02"() {
		when: def result = Day02._02()
		then: result == 351
	}

}
