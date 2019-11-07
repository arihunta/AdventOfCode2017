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

	def "03-01"() {
		when: def result = Day03._01()
		then: result == 419
	}

	def "03-02"() {
		when: def result = Day03._02()
		then: result == 295229
	}

	def "04-01"() {
		when: def result = Day04._01()
		then: result == 383
	}

	def "04-02"() {
		when: def result = Day04._02()
		then: result == 265
	}

	def "05-01"() {
		when: def result = Day05._01()
		then: result == 326618
	}

	def "05-02"() {
		when: def result = Day05._02()
		then: result == 21841249
	}

	def "06-01"() {
		when: def result = Day06._01()
		then: result == 5042
	}

	def "06-02"() {
		when: def result = Day06._02()
		then: result == 1086
	}

	def "07-01"() {
		when: def result = Day07._01()
		then: result == "vmpywg"
	}

	def "07-02"() {
		when: def result = Day07._02()
		then: result == 1674
	}

}
