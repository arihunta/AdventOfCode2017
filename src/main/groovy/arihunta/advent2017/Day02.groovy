package arihunta.advent2017

import java.nio.charset.StandardCharsets

import com.google.common.io.Resources

class Day02 {

	static int _01() {

		Resources.readLines(Resources.getResource("02"), StandardCharsets.UTF_8)
				.collect { it.split('\t').collect { Integer.parseInt(it) } }
				.collect { it.max() - it.min() }
				.sum()

	}

	static int _02() {

		Resources.readLines(Resources.getResource("02"), StandardCharsets.UTF_8)
				.collect {

					def numbers = it.split('\t')
							.collect { Integer.parseInt(it) }

					for (int i : 0..numbers.size() - 1)
						for (int j : 0..numbers.size() - 1)
							if (i != j && ((int)(numbers[i] / numbers[j])) * numbers[j] == numbers[i])
								return (numbers[i] / numbers[j])

					return 0

				}
				.sum()

	}

}
