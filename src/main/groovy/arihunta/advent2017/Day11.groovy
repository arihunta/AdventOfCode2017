package arihunta.advent2017

import java.nio.charset.StandardCharsets

import com.google.common.io.Resources

class Day11 {

	static final List<String> input = Resources.toString(Resources.getResource("11"), StandardCharsets.UTF_8).split(",")

	static def _01() {

		def axes = input.collect {
			switch (it) {
				case 'n' : return [1, 0, 0]
				case 's' : return [-1, 0, 0]
				case 'ne': return [0, 1, 0]
				case 'sw': return [0, -1, 0]
				case 'nw': return [0, 0, 1]
				case 'se': return [0, 0, -1]
			}
		}
		.inject { a, b ->
			a[0] += b[0]
			a[1] += b[1]
			a[2] += b[2]
			a
		}

		def axesAbsolute = axes.collect { Math.abs(it) }

		def min = axesAbsolute.min()

		axesAbsolute.sum() - min

	}

	static def _02 () {

		int furthest = 0
		def coords = [0, 0, 0]

		def steps = input.collect {
			switch (it) {
				case 'n' : return [1, 0, 0]
				case 's' : return [-1, 0, 0]
				case 'ne': return [0, 1, 0]
				case 'sw': return [0, -1, 0]
				case 'nw': return [0, 0, 1]
				case 'se': return [0, 0, -1]
			}
		}

		for (int[] step : steps) {

			coords[0] += step[0]
			coords[1] += step[1]
			coords[2] += step[2]

			def axesAbsolute = coords.collect { Math.abs(it) }
			def min = axesAbsolute.min()
			furthest = Math.max(furthest, axesAbsolute.sum() - min)

		}

		furthest

	}

}
