package arihunta.advent2017

import java.nio.charset.StandardCharsets
import java.util.stream.IntStream

import com.google.common.io.Resources

class Day10 {

	static final String input = Resources.toString(Resources.getResource("10"), StandardCharsets.UTF_8)
	static final int LIST_SIZE = 256

	static def _01() {

		final List<Integer> hash = IntStream.range(0, LIST_SIZE).collect()

		def cursor = 0
		def skipSize = 0

		for (int lengths : input.split(",").collect { Integer.parseInt(it) }) {

			int startIdx = cursor
			int endIdx = (cursor + lengths - 1) % LIST_SIZE

			for (int i = 0; i < lengths / 2; i++) {

				def tmp = hash[endIdx]
				hash[endIdx] = hash[startIdx]
				hash[startIdx] = tmp

				startIdx = (startIdx + 1) % LIST_SIZE
				endIdx = endIdx == 0 ? LIST_SIZE - 1 : endIdx - 1


			}

			cursor = (cursor + lengths + skipSize++) % LIST_SIZE

		}

		hash[0] * hash[1]

	}

	static def _02() {

		List<Integer> lengths = input.toCharArray().collect { (int)it }
		lengths.addAll(Arrays.asList(17, 31, 73, 47, 23))

		final List<Integer> hash = IntStream.range(0, LIST_SIZE).collect()

		def cursor = 0
		def skipSize = 0

		for (int i = 0; i < 64; i++) {

			for (int length : lengths) {

				int startIdx = cursor
				int endIdx = (cursor + length - 1) % LIST_SIZE

				for (int idx = 0; idx < length / 2; idx++) {

					def tmp = hash[endIdx]
					hash[endIdx] = hash[startIdx]
					hash[startIdx] = tmp

					startIdx = (startIdx + 1) % LIST_SIZE
					endIdx = endIdx == 0 ? LIST_SIZE - 1 : endIdx - 1

				}

				cursor = (cursor + length + skipSize++) % LIST_SIZE

			}

		}

		List<Integer> denseHash = new ArrayList<>()
		for (int i = 0; i < 16; i++) {
			denseHash.add(hash.subList(i * 16, i * 16 + 16).inject { a, b -> a ^ b })
		}

		return denseHash.collect { Integer.toHexString(it) }.collect { it.length() == 1 ? "0" + it : it }.join("")

	}

}
