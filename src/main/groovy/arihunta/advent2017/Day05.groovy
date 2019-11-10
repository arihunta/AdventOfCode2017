package arihunta.advent2017

import java.nio.charset.StandardCharsets

import com.google.common.io.Resources

class Day05 {

	static def _01() {

		final int[] jumps = Resources.readLines(Resources.getResource("05"), StandardCharsets.UTF_8)
				.collect { it.toInteger() }

		final int limit = jumps.size()

		int pc = 0
		int cycles = 0

		while (pc >= 0 && pc < limit) {

			int newPc = pc + jumps[pc]
			jumps[pc]++
			pc = newPc
			cycles++

		}

		cycles

	}

	static def _02() {

		final int[] jumps = Resources.readLines(Resources.getResource("05"), StandardCharsets.UTF_8)
				.collect { it.toInteger() }

		final int limit = jumps.size()

		int pc = 0
		int cycles = 0

		while (pc >= 0 && pc < limit) {

			int newPc = pc + jumps[pc]
			jumps[pc] = jumps[pc] >= 3 ? jumps[pc] - 1 : jumps[pc] + 1
			pc = newPc
			cycles++

		}

		cycles

	}

}
