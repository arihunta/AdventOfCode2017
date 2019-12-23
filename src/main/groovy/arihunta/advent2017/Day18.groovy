package arihunta.advent2017

import java.nio.charset.StandardCharsets
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.TimeUnit

import com.google.common.io.Resources

class Day18 {


	static def _01() {

		final def input = Resources.readLines(Resources.getResource("18"), StandardCharsets.UTF_8).collect { it.split(" ") }

		final Map<String, Long> registers = new HashMap<>()

		def valueOf = {String operand -> operand == null ? null : (operand.matches("-?\\d+") ? operand.toLong() : operand) }
		def dereference = { operand -> (operand instanceof Long ? operand : registers[operand] ?: 0L) }

		def lastSound = 0

		int progCounter = 0

		while (progCounter >= 0 && progCounter < input.size()) {

			def instruction = input[progCounter][0]
			def x = valueOf(input[progCounter][1])
			def y = input[progCounter].size() != 3 ? null : valueOf(input[progCounter][2])

			switch (instruction) {
				case 'snd':
					lastSound = dereference(x)
					break
				case 'set':
					registers[x] = dereference(y)
					break
				case 'add':
					registers[x] = dereference(x) + dereference(y)
					break
				case 'mul':
					registers[x] = dereference(x) * dereference(y)
					break
				case 'mod':
					registers[x] = dereference(x) % dereference(y)
					break
				case 'rcv':
					if (dereference(x) != 0)
						return lastSound
					break
				case 'jgz':
					if (dereference(x) > 0)
						progCounter = progCounter - 1 + dereference(y)
					break
			}

			progCounter++
		}

		lastSound
	}

	static def _02() {

		final def input = Resources.readLines(Resources.getResource("18"), StandardCharsets.UTF_8).collect { it.split(" ") }

		final LinkedBlockingQueue<Integer> aToB = new LinkedBlockingQueue()
		final LinkedBlockingQueue<Integer> bToA = new LinkedBlockingQueue()

		final DuetProcessor progA = new DuetProcessor(new ArrayList(input), 0, bToA, aToB)
		final DuetProcessor progB = new DuetProcessor(new ArrayList(input), 1, aToB, bToA)

		def thrA = progA.runOnThread()
		def thrB = progB.runOnThread()

		thrA.join()
		thrB.join()

		progB.numberOfSends
	}
}


public class DuetProcessor {

	private final Map<String, Long> registers = new HashMap<>()

	private int programCounter = 0

	int numberOfSends = 0

	final def program

	private final BlockingQueue<Integer> input;
	private final BlockingQueue<Integer> output;

	public DuetProcessor(def program, def p, def input, def output) {
		registers['p'] = p
		this.program = program
		this.input = input
		this.output = output
	}

	def proc() {

		while (programCounter >= 0 && programCounter < program.size()) {

			final String instruction = program[programCounter][0]
			final def x = valueOf(program[programCounter][1])
			final def y = program[programCounter].size() != 3 ? null : valueOf(program[programCounter][2])

			switch (instruction) {
				case 'snd':
					numberOfSends++
					output.add(dereference(x))
					break
				case 'set':
					registers[x] = dereference(y)
					break
				case 'add':
					registers[x] = dereference(x) + dereference(y)
					break
				case 'mul':
					registers[x] = dereference(x) * dereference(y)
					break
				case 'mod':
					registers[x] = dereference(x) % dereference(y)
					break
				case 'rcv':
					registers[x] = input.poll(10, TimeUnit.MILLISECONDS)
					if (registers[x] == null) return
					break
				case 'jgz':
					if (dereference(x) > 0)
						programCounter = programCounter - 1 + dereference(y)
					break
			}

			programCounter++
		}
	}

	Thread runOnThread() {
		def thr = new Thread( { proc() } )
		thr.start()
		return thr
	}

	private def dereference = { operand -> (operand instanceof Long ? operand : registers[operand] ?: 0L) }
	private static def valueOf = {String operand -> (operand.matches("-?\\d+") ? operand.toLong() : operand) }

}