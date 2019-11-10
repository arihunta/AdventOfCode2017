package arihunta.advent2017

class Day03 {

	static final def input = 289326

	static def _01() {

		def directions = [ [1, 0], [0, 1], [-1, 0], [0, -1] ];

		def sum = 1
		int sideLength = 1
		int direction = 0
		def coord =  [0, 0]

		while (true) {
			sum += sideLength
			coord[0] += directions[direction][0] * sideLength
			coord[1] += directions[direction][1] * sideLength

			if (sum >= input) break

			direction = (direction + 1) % 4

			if (directions[direction][0] != 0) sideLength++

		}

		def overshoot = sum - input
		coord[0] -= directions[direction][0] * overshoot
		coord[1] -= directions[direction][1] * overshoot

		Math.abs(coord[0]) + Math.abs(coord[1])

	}

	static def _02() {

		def directions = [ [1, 0], [0, 1], [-1, 0], [0, -1] ];

		int sideLength = 1
		int direction = 0
		def coord =  [0, 0]

		def vals = [ "0,0": 1 ]

		while (true) {

			for (int i in 0..sideLength - 1) {

				coord[0] += directions[direction][0]
				coord[1] += directions[direction][1]

				def ans = 0
				for (int j in -1..1)
					for (int k in -1..1)
						ans += vals["${coord[0] + j},${coord[1] + k}"] ?: 0

				vals["${coord[0]},${coord[1]}"] = ans

				if (vals["${coord[0]},${coord[1]}"] >= input) break

			}

			if (vals["${coord[0]},${coord[1]}"] >= input) break

			direction = (direction + 1) % 4

			if (directions[direction][0] != 0) sideLength++

		}

		vals["${coord[0]},${coord[1]}"]

	}

}
