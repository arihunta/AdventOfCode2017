package arihunta.advent2017

import spock.lang.Specification

class Day10Test extends Specification {

	def "10-01"() {
		when: def result = Day10._01()
		then: result == 46600
	}

	def "10-02"() {
		when: def result = Day10._02()
		then: result == "23234babdc6afa036749cfa9b597de1b"
	}

}
