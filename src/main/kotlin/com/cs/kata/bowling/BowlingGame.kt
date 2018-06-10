package com.cs.kata.bowling

class BowlingGame(private var rolls: IntArray = IntArray(21), private var currentRoll: Int = 0) {

    fun score(): Int {
        var total = 0

        var currentIndex = 0

        for (frameIndex in 0..9) when {
            isStrike(currentIndex) -> {
                total += 10 + strikeBonus(currentIndex)
                currentIndex++
            }
            isSpare(currentIndex) -> {
                total += 10 + spareBonus(currentIndex)
                currentIndex += 2
            }
            else -> {
                total += currentFrameScore(currentIndex)
                currentIndex +=2
            }
        }

        return total
    }


    private fun currentFrameScore(currentIndex: Int) = rolls[currentIndex] + rolls[currentIndex + 1]

    private fun isSpare(frameIndex: Int) = currentFrameScore(frameIndex) == 10
    private fun spareBonus(currentIndex: Int) = rolls[currentIndex + 2]

    private fun isStrike(currentIndex: Int) = rolls[currentIndex] == 10
    private fun strikeBonus(currentIndex: Int) = rolls[currentIndex+1] + rolls [currentIndex+2]





    fun roll(pins: Int) {
        validateRoll(pins)
        rolls[currentRoll++] = pins
    }

    private fun validateRoll(pins: Int) {
        if (pins !in 0..10) throw RuntimeException("Pins should be positive")
    }

}
