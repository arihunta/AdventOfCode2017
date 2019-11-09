package arihunta.advent2017

import java.nio.charset.StandardCharsets
import java.util.regex.Matcher
import java.util.regex.Pattern
import java.util.stream.IntStream

import com.google.common.io.Resources

class Day12 {

	def static regex = Pattern.compile("(\\d+) <-> (\\d+(, \\d+)*)")
	def static input = Resources.readLines(Resources.getResource("12"), StandardCharsets.UTF_8)

	def static _01() {

		Map<Integer,List<Integer>> edges = input.collect {
			regex.matcher(it)
		}
		.collectEntries { Matcher it ->
			it.matches()
			[(it.group(1).toInteger()): it.group(2).split(", ").collect { Integer.parseInt(it) }]
		}

		println "$edges"

		final Queue<Integer> toVisit = new LinkedList<>()
		final Set<Integer> visited = new HashSet()

		toVisit.add(0)

		while (!toVisit.empty) {

			def current = toVisit.remove()
			visited.add(current)
			toVisit.addAll(edges.get(current).dropWhile { visited.contains(it) })

		}

		visited.size()

	}

	def static _02() {

		Map<Integer,List<Integer>> edges = input.collect {
			regex.matcher(it)
		}
		.collectEntries { Matcher it ->
			it.matches()
			[(it.group(1).toInteger()): it.group(2).split(", ").collect { Integer.parseInt(it) }]
		}

		println "$edges"

		final Set<Integer> allPrograms = IntStream.range(0, edges.size()).collect()
		final Queue<Integer> toVisit = new LinkedList<>()
		final Set<Integer> visited = new HashSet()
		int numGroups = 0

		while (!allPrograms.empty) {

			toVisit.add(allPrograms.iterator().next())
			numGroups++

			while (!toVisit.empty) {

				def current = toVisit.remove()
				visited.add(current)
				toVisit.addAll(edges.get(current).dropWhile { visited.contains(it) })
			}

			allPrograms.removeAll(visited)

		}

		numGroups

	}

}
