package arihunta.advent2017

import java.nio.charset.StandardCharsets
import java.util.regex.Matcher
import java.util.regex.Pattern

import com.google.common.io.Resources

class Day08 {

	static final List<String> input = Resources.readLines(Resources.getResource("08"), StandardCharsets.UTF_8)

	static final Pattern instruction = Pattern.compile("(\\w+) (inc|dec) (-?\\d+) if (\\w+) (<|>|==|!=|<=|>=) (-?\\d+)")

	static int _01() {

		final Map<String, Integer> registers = new HashMap<>()

		input.forEach { line ->
			final Matcher matcher = instruction.matcher(line)
			if (matcher.matches()) {
				def reg = matcher.group(1)
				def multiplier = matcher.group(2).equals("inc") ? 1 : -1
				def amount = matcher.group(3).toInteger() * multiplier
				def conditionReg = registers[matcher.group(4)] ?: 0
				def comparator = matcher.group(5)
				def value = matcher.group(6).toInteger()
				boolean condition = false
				switch (comparator) {
					case "<":
					condition = conditionReg < value
					break
					case ">":
					condition = conditionReg > value
					break
					case "==":
					condition = conditionReg == value
					break
					case "!=":
					condition = conditionReg != value
					break
					case "<=":
					condition = conditionReg <= value
					break
					case ">=":
					condition = conditionReg >= value
					break
				}
				if (condition) {
					registers[reg] = (registers[reg] ?: 0) + amount
				}
			}
		}

		registers.values().max()

	}

	static int _02() {

		final Map<String, Integer> registers = new HashMap<>()

		int max = Integer.MIN_VALUE

		input.forEach { line ->
			final Matcher matcher = instruction.matcher(line)
			if (matcher.matches()) {
				def reg = matcher.group(1)
				def multiplier = matcher.group(2).equals("inc") ? 1 : -1
				def amount = matcher.group(3).toInteger() * multiplier
				def conditionReg = registers[matcher.group(4)] ?: 0
				def comparator = matcher.group(5)
				def value = matcher.group(6).toInteger()
				boolean condition = false
				switch (comparator) {
					case "<":
					condition = conditionReg < value
					break
					case ">":
					condition = conditionReg > value
					break
					case "==":
					condition = conditionReg == value
					break
					case "!=":
					condition = conditionReg != value
					break
					case "<=":
					condition = conditionReg <= value
					break
					case ">=":
					condition = conditionReg >= value
					break
				}
				if (condition) {
					registers[reg] = (registers[reg] ?: 0) + amount
					max = Math.max(registers[reg], max)
				}
			}
		}

		max

	}

}
