package arihunta.advent2017

import spock.lang.Specification

class Day03Test extends Specification {

	def "03-01"() {
		when: def result = Day03._01()
		then: result == 419
	}

	def "03-02"() {
		when: def result = Day03._02()
		then: result == 295229
	}

}
