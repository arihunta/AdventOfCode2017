package arihunta.advent2017

import java.nio.charset.StandardCharsets
import java.util.stream.IntStream

import com.google.common.io.Resources

class Day16 {

	static final def input = Resources.toString(Resources.getResource("16"), StandardCharsets.UTF_8).split(",")

	static def _01() {

		final int numProgs = 16
		def progs = new StringBuilder(IntStream.range(97, 97 + numProgs).collect{ (char)it }.join(""))

		for (String instruction : input) {
			if (instruction.startsWith('s')) {
				def spinFactor = instruction.substring(1).toInteger()
				String prependix = progs.toString().substring(numProgs - spinFactor)
				progs.delete(numProgs - spinFactor, numProgs)
				progs.insert(0, prependix)
			}
			else if ((instruction.startsWith('x'))) {
				def positions = instruction.substring(1).split('/').collect { Integer.parseInt(it) }
				def tmp = progs.toString()[positions[0]]
				progs.replace(positions[0], positions[0] + 1, progs.toString()[positions[1]])
				progs.replace(positions[1], positions[1] + 1, tmp)
			}
			else if ((instruction.startsWith('p'))) {
				def positions = instruction.substring(1).split('/').collect { progs.indexOf(it) }
				def tmp = progs.toString()[positions[0]]
				progs.replace(positions[0], positions[0] + 1, progs.toString()[positions[1]])
				progs.replace(positions[1], positions[1] + 1, tmp)
			}
		}

		progs.toString()

	}

	static def _02() {

		final int numProgs = 16
		char[] progs = IntStream.range(97, 97 + numProgs).collect{ (char)it }.toArray()
		char[] initialProgs = IntStream.range(97, 97 + numProgs).collect{ (char)it }.toArray()

		for (int i = 0; i < 1_000_000_000; i++) {
			for (String instruction : input) {
				if (instruction.startsWith('s')) {
					def spinFactor = instruction.substring(1).toInteger()
					char[] tmp = new char[numProgs]
					System.arraycopy(progs, numProgs - spinFactor, tmp, 0, spinFactor)
					System.arraycopy(progs, 0, tmp, spinFactor, numProgs - spinFactor)
					System.arraycopy(tmp, 0, progs, 0, numProgs)
				}
				else if ((instruction.startsWith('x'))) {
					def positions = instruction.substring(1).split('/').collect { Integer.parseInt(it) }
					def tmp = progs[positions[0]]
					progs[positions[0]] = progs[positions[1]]
					progs[positions[1]] = tmp
				}
				else if ((instruction.startsWith('p'))) {
					def positions = instruction.substring(1).split('/').collect { name -> progs.findIndexOf { val -> val == name  } }
					def tmp = progs[positions[0]]
					progs[positions[0]] = progs[positions[1]]
					progs[positions[1]] = tmp
				}
			}
			if (progs == initialProgs) {
				def period = i + 1
				while (i + period < 1_000_000_000) i = i + period
			}
		}

		progs.join("")

	}

}
