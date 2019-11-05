package arihunta.advent2017

import java.nio.charset.StandardCharsets

import com.google.common.io.Resources

class Day01 {

	static int _01() {

		def numbers = Resources.toString(Resources.getResource("01"), StandardCharsets.UTF_8).replace('\n', '')
				.chars
				.collect { Integer.parseInt(it.toString()) }

		Integer sum = 0
		for (int i in 0..numbers.size() - 1) {
			if (numbers[i] == numbers[i != 0 ? i - 1 : numbers.size() - 1]) {
				sum = sum + numbers[i]
			}
		}

		if (numbers[0] != numbers[numbers.size() - 1])
			sum += numbers[0]

		sum

	}

	static int _02() {

		def numbers = Resources.toString(Resources.getResource("01"), StandardCharsets.UTF_8).replace('\n', '')
				.chars
				.collect { Integer.parseInt(it.toString()) }

		int sum = 0
		for (int i in 0..numbers.size() - 1) {
			if (numbers[i] == numbers[(i + numbers.size() / 2).intValue() % numbers.size()]) {
				sum = sum + numbers[i]
			}
		}

		sum

	}

}
