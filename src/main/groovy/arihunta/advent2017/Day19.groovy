package arihunta.advent2017

import java.nio.charset.StandardCharsets

import com.google.common.io.Resources

class Day19 {

	static def traversibleChars = ~/[A-Z\|\-\+]/
	static def directions = [
		[0, 1],
		[1, 0],
		[0 , -1],
		[-1, 0],
	]

	static def _01() {

		final def input = Resources
				.readLines(Resources.getResource("19"), StandardCharsets.UTF_8)
				.findAll { !it.isEmpty() }
				.collect {
					it.chars()
					.collect { chr -> Character.valueOf((char) chr) }
					.collect { (it =~ traversibleChars).find() ? it : null }
				}

		def coords = [
			input[0].findIndexOf { it == '|' },
			0,
		]
		def heading = 0

		def str = ""

		def nextDirection = {

			def forward = step(coords, heading)
			def leftHeading = (heading + 1) % 4
			def rightHeading = (heading == 0) ? 3 : (heading - 1)
			def left = step(coords, leftHeading)
			def right = step(coords, rightHeading)

			if (input[forward[1]] != null && input[forward[1]][forward[0]] != null) return forward
			else if (input[left[1]] != null && input[left[1]][left[0]] != null) {
				heading = leftHeading
				return left
			}
			else if (input[right[1]] != null && input[right[1]][right[0]] != null) {
				heading = rightHeading
				return right
			}
			else return null

		}

		while (coords != null) {
			if (input[coords[1]][coords[0]] =~ /[A-Z]/) str = str + input[coords[1]][coords[0]]
			coords = nextDirection()
		}

		str
	}

	static def _02() {

		final def input = Resources
				.readLines(Resources.getResource("19"), StandardCharsets.UTF_8)
				.findAll { !it.isEmpty() }
				.collect {
					it.chars()
					.collect { chr -> Character.valueOf((char) chr) }
					.collect { (it =~ traversibleChars).find() ? it : null }
				}

		def coords = [
			input[0].findIndexOf { it == '|' },
			0,
		]
		def heading = 0

		def steps = 0

		def nextDirection = {

			def forward = step(coords, heading)
			def leftHeading = (heading + 1) % 4
			def rightHeading = (heading == 0) ? 3 : (heading - 1)
			def left = step(coords, leftHeading)
			def right = step(coords, rightHeading)

			if (input[forward[1]] != null && input[forward[1]][forward[0]] != null) return forward
			else if (input[left[1]] != null && input[left[1]][left[0]] != null) {
				heading = leftHeading
				return left
			}
			else if (input[right[1]] != null && input[right[1]][right[0]] != null) {
				heading = rightHeading
				return right
			}
			else return null

		}

		while (coords != null) {
			coords = nextDirection()
			steps++
		}

		steps
	}

	static List<Integer> step(def coords, def direction) {
		[
			coords[0] + directions[direction][0],
			coords[1] + directions[direction][1],
		]
	}
}

