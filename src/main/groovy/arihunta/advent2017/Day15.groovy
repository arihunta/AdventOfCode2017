package arihunta.advent2017

import java.nio.charset.StandardCharsets

import com.google.common.io.Resources

class Day15 {

	static final def input = Resources.readLines(Resources.getResource("15"), StandardCharsets.UTF_8).collect { Integer.parseInt(it.substring(24).trim()) }

	static def _01() {

		def a = BigInteger.valueOf(input[0])
		def b = BigInteger.valueOf(input[1])

		def a_prod = BigInteger.valueOf(16807)
		def b_prod = BigInteger.valueOf(48271)

		def max = BigInteger.valueOf(2147483647L)

		def count = 0

		for (int i in 1..40_000_000) {

			a = a.multiply(a_prod).mod(max)
			b = b.multiply(b_prod).mod(max)
			if ((a & 0b1111111111111111) == (b & 0b1111111111111111)) count++
		}

		count
	}

	static def _02() {

		def a = BigInteger.valueOf(input[0])
		def b = BigInteger.valueOf(input[1])

		def a_prod = BigInteger.valueOf(16807)
		def b_prod = BigInteger.valueOf(48271)

		def max = BigInteger.valueOf(2147483647L)

		def count = 0

		for (int i in 1..5_000_000) {

			a = a.multiply(a_prod).mod(max)
			while (a % 4 != 0) a = a.multiply(a_prod).mod(max)

			b = b.multiply(b_prod).mod(max)
			while (b % 8 != 0) b = b.multiply(b_prod).mod(max)

			if ((a & 0b1111111111111111) == (b & 0b1111111111111111)) count++

		}

		count

	}

}
