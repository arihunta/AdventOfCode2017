package arihunta.advent2017

import java.nio.charset.StandardCharsets
import java.util.regex.Pattern

import com.google.common.io.Resources

class Day07 {

	static final List<String> input = Resources.readLines(Resources.getResource("07"), StandardCharsets.UTF_8)

	static final Pattern definition = Pattern.compile("(\\w+) \\((\\d+)\\)( -> (\\w+(, \\w+)*))?")

	static final Map<String,Prog> nodes = input.collect { String line ->
		def mchr = definition.matcher(line)
		mchr.find()
		final String id = mchr.group(1)
		final Integer weight = mchr.group(2).toInteger()
		final List<String> children = mchr.group(4) == null ? []: mchr.group(4).split(", ")
		new Prog(id, weight, children)
	}
	.collectEntries { [(it.id): it] }

	static class Prog {

		public String id
		public Integer weight
		public List<String> children

		public Integer subWeight = 0
		public Prog(def id, def weight, def children) {
			this.id = id;
			this.weight = weight;
			this.children = children;
		}

		def calculateSubWeights() {

			subWeight = (children.collect { nodes[it].calculateSubWeights() }.sum() ?: 0) + weight
			subWeight

		}

	}

	static String _01() {

		def childNodes = nodes.values().collect { it.children }.flatten().toUnique()

		def nodeIds = nodes.values().collect { it.id }

		nodeIds.removeAll(childNodes)
		nodeIds[0]

	}

	static int _02() {

		List<String> childNodes = nodes.collect { it.value.children }.flatten().toUnique()
		List<String> nodeIds = nodes.collect { it.key }
		nodeIds.removeAll(childNodes)

		String root = nodeIds[0]

		Prog parent = null
		Prog cursor = nodes[root]

		cursor.calculateSubWeights()

		while (true) {

			def blah = cursor.children.inject(new HashMap<Integer, Integer>()) { acc, val ->
				acc[nodes[val].subWeight] = acc[nodes[val].subWeight] != null ? acc[nodes[val].subWeight] + 1 : 1
				acc
			}
			println "$blah"
			def oddKeys = blah.dropWhile { it.value != 1 }
			.collect { it.key }

			if (!oddKeys.empty) {
				Integer oddWeight = oddKeys[0]
				parent = cursor
				cursor = nodes[cursor.children.dropWhile { nodes[it].subWeight != oddWeight }[0]]
				println "oddwitgh is ${cursor.id}"
			}
			else {
				println "colprit is ${cursor.id}"
				break
			}

		}

		(cursor.weight + (nodes[parent.children.dropWhile { it == cursor.id }[0]].subWeight - cursor.subWeight))

	}

}
