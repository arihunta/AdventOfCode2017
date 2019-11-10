package arihunta.advent2017

import java.nio.charset.StandardCharsets

import com.google.common.io.Resources

class Day13 {

	static Map<Integer, Integer> input = Resources.readLines(Resources.getResource("13"), StandardCharsets.UTF_8)
			.collect { it.split(": ") }
			.collectEntries { [(it[0].toInteger()): it[1].toInteger()] }

	static def _01() {

		input.collect {
			def period = (it.value * 2 - 2)
			it.key % period == 0 ? it.value * it.key : 0
		}
		.sum()

	}

	static def _02() {

		Map<Integer,Integer> periods = input.collectEntries { [(it.key): (it.value * 2 - 2)] }
		int delay = 0
		while (true) {
			Map<Integer,Boolean> resutls = periods.collectEntries {
				[(it.key): (it.key + delay) % it.value != 0]
			}
			if (!resutls.any {it.value == false}) return delay
			delay++
		}

		1

	}

}
