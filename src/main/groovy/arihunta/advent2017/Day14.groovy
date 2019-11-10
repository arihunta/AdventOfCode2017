package arihunta.advent2017

import java.util.stream.IntStream

class Day14 {

	static final int LIST_SIZE = 256

	final static String input = "stpzcrnm"

	static List<Integer> knotHash(final String str) {

		List<Integer> lengths = str.toCharArray().collect { (int)it }
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

		return denseHash//.collect { Integer.toHexString(it) }.collect { it.length() == 1 ? "0" + it : it }.join("")

	}

	static def _01() {

		int usedBlocks = 0
		for (int i = 0; i < 128; i++) {
			def binString = knotHash(String.format("%s-%d", input, i)).collect { String.format("%8s", Integer.toBinaryString(it)).replace(' ', '0') }.join("")
			usedBlocks += binString.replace("0", "").size()
		}

		return usedBlocks

	}

	static def _02() {

		List<String> grid = IntStream.range(0, 128)
				.collect {
					knotHash(String.format("%s-%d", input, it))
							.collect { String.format("%8s", Integer.toBinaryString(it)).replace(' ', '0') }
							.join("")
				}

		def numGroups = 0
		for (int i = 0; i < 128; i++) {
			for (int j = 0; j < 128; j++) {
				if (grid[i][j] == '1') {
					numGroups++
					fillIsland(i, j, grid)
				}
			}
		}

		return numGroups

	}

	static def fillIsland(int i, int j, List<String> grid) {

		if (i >= 128 || j >= 128 || i < 0 || j < 0) return;

		if (grid[i][j] != '1') return;

		StringBuilder sb = new StringBuilder(grid[i])
		sb.setCharAt(j, 'x'.charAt(0))

		grid[i] = sb.toString()

		fillIsland(i + 1, j, grid)
		fillIsland(i - 1, j, grid)
		fillIsland(i, j + 1, grid)
		fillIsland(i, j - 1, grid)

	}

}
