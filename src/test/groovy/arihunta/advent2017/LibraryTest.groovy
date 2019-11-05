package arihunta.advent2017

import spock.lang.Specification

class LibraryTest extends Specification {

	def "01-01"() {
		when: def result = Day01._01()
		then: result == 1144
	}

	def "01-02"() {
		when: def result = Day01._02()
		then: result == 1194
	}

	def "02-01"() {
		when: def result = Day02._01()
		then: result == 48357
	}

	def "02-02"() {
		when: def result = Day02._02()
		then: result == 351
	}

}
