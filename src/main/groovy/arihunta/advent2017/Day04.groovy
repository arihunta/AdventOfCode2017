package arihunta.advent2017

import java.nio.charset.StandardCharsets

import com.google.common.io.Resources

class Day04 {

	static def _01() {

		def validPhrases = 0

		Resources.readLines(Resources.getResource("04"), StandardCharsets.UTF_8)
				.count { String it ->

					def words = it.split(" ")

					words.length == words.toUnique().length

				}

	}

	static def _02() {

		def validPhrases = 0

		Resources.readLines(Resources.getResource("04"), StandardCharsets.UTF_8)
				.count { String it ->

					def words = it.split(" ").collect { String word ->
						word.toCharArray().collect { def fff -> fff.toString() }.toSorted().toString()
					}

					words.size() == words.toUnique().size()

				}

	}

}
