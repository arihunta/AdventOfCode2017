package arihunta.advent2017

import spock.lang.Specification

class Day05Test extends Specification {

	def "05-01"() {
		when: def result = Day05._01()
		then: result == 326618
	}

	def "05-02"() {
		when: def result = Day05._02()
		then: result == 21841249
	}

}
