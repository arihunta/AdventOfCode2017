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

	def "08-01"() {
		when: def result = Day08._01()
		then: result == 5849
	}

	def "08-02"() {
		when: def result = Day08._02()
		then: result == 6702
	}

	def "09-01"() {
		when: def result = Day09._01()
		then: result == 7640
	}

	def "09-02"() {
		when: def result = Day09._02()
		then: result == 4368
	}

	def "10-01"() {
		when: def result = Day10._01()
		then: result == 46600
	}

	def "10-02"() {
		when: def result = Day10._02()
		then: result == "23234babdc6afa036749cfa9b597de1b"
	}

	def "11-01"() {
		when: def result = Day11._01()
		then: result == 759
	}

	def "11-02"() {
		when: def result = Day11._02()
		then: result == 1501
	}

	def "12-01"() {
		when: def result = Day12._01()
		then: result == 115
	}

	def "12-02"() {
		when: def result = Day12._02()
		then: result == 221
	}

	def "13-01"() {
		when: def result = Day13._01()
		then: result == 1900
	}

	def "13-02"() {
		when: def result = Day13._02()
		then: result == 3966414
	}

	def "14-01"() {
		when: def result = Day14._01()
		then: result == 8250
	}

	def "14-02"() {
		when: def result = Day14._02()
		then: result == 1113
	}

	def "15-01"() {
		when: def result = Day15._01()
		then: result == 567
	}

	def "15-02"() {
		when: def result = Day15._02()
		then: result == 323
	}

}
