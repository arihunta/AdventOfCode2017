package arihunta.advent2017

import spock.lang.Specification

class Day16Test extends Specification {

	def "16-01"() {
		when: def result = Day16._01()
		then: result == 'cknmidebghlajpfo'
	}

	def "16-02"() {
		when: def result = Day16._02()
		then: result == 'cbolhmkgfpenidaj'
	}

}
