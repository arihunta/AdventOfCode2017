package arihunta.advent2017

class Day17 {

	static final def input = 345

	static def _01() {
		List<Integer> buffer = new ArrayList<>()
		buffer.add(0)
		def currentPosition = 0;

		for (int i in 1..2017) {
			currentPosition = (currentPosition + input) % buffer.size() + 1
			buffer.add(currentPosition, i)
		}

		buffer[(currentPosition + 1) % buffer.size()]
	}

	static def _02() {
		int bufferSize = 1
		int zeroIndex = 0
		def currentPosition = 0;
		int numberAfterZero = -1

		for (int i in 1..50_000_000) {
			currentPosition = (currentPosition + input) % bufferSize + 1
			if (currentPosition == zeroIndex + 1) numberAfterZero = i
			else if (currentPosition <= zeroIndex) zeroIndex++
			bufferSize++
		}

		numberAfterZero
	}

}
