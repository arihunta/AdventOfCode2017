package arihunta.advent2017

import java.nio.charset.StandardCharsets

import com.google.common.io.Resources

class Day06 {

	static int _01() {

		def banks = Resources.toString(Resources.getResource("06"), StandardCharsets.UTF_8)
				.split('\t')
				.collect { it.toInteger() }

		def cycles = 0
		def visited = new HashSet<String>()

		while (true) {

			cycles++

			def blocks = banks.max()
			def idx = banks.indexOf(blocks)
			banks[idx] = 0

			while (blocks > 0) {
				idx = (idx + 1) % 16
				banks[idx]++
				blocks--
			}

			def str = banks.toString()

			if (visited.contains(str)) break

			visited.add(str)


		}

		cycles

	}

	static int _02() {

		def banks = Resources.toString(Resources.getResource("06"), StandardCharsets.UTF_8)
				.split('\t')
				.collect { it.toInteger() }
		def visited = new HashSet<String>()

		while (true) {

			def blocks = banks.max()
			def idx = banks.indexOf(blocks)
			banks[idx] = 0

			while (blocks > 0) {
				idx = (idx + 1) % 16
				banks[idx]++
				blocks--
			}

			def str = banks.toString()

			if (visited.contains(str)) break

			visited.add(str)


		}

		visited.clear()
		visited.add(banks.toString())

		def cycles = 0

		while (true) {

			cycles++

			def blocks = banks.max()
			def idx = banks.indexOf(blocks)
			banks[idx] = 0

			while (blocks > 0) {
				idx = (idx + 1) % 16
				banks[idx]++
				blocks--
			}

			def str = banks.toString()

			if (visited.contains(str)) break

			visited.add(str)


		}

		cycles

	}

}
