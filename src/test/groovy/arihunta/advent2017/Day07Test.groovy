package arihunta.advent2017

import spock.lang.Specification

class Day07Test extends Specification {

	def "07-01"() {
		when: def result = Day07._01()
		then: result == "vmpywg"
	}

	def "07-02"() {
		when: def result = Day07._02()
		then: result == 1674
	}

}
