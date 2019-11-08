package arihunta.advent2017

import java.nio.charset.StandardCharsets
import java.util.regex.Matcher
import java.util.regex.Pattern

import com.google.common.io.Resources

class Day09 {

	static final String input = Resources.toString(Resources.getResource("09"), StandardCharsets.UTF_8).trim().replace('\n', '')

	static int _01() {

		final String slim = input.replaceAll("!.", "").replaceAll("<.*?>", "").replaceAll(",", "")

		int ans = 0
		int weight = 0
		for (def bckt : slim.chars) {
			if (bckt == '{') {
				weight++
			}
			else {
				ans += weight
				weight--
			}
		}

		ans

	}

	static int _02() {

		final Matcher matcher = Pattern.compile("<(.*?)>").matcher(input.replaceAll("!.", ""))

		int ans = 0
		while (matcher.find())
			ans += matcher.group().size() - 2

		ans

	}

}
