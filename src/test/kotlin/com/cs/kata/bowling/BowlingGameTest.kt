package com.cs.kata.bowling

import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals


class BowlingGameTest {

    private lateinit var bowlingGame: BowlingGame


    @Before
    fun setUp() {
        bowlingGame = BowlingGame()
    }

    @Test
    fun given_no_roll_score_should_be_0() {

        //when
        val score = bowlingGame.score()
        //then
        assertEquals(0, score)
    }

    @Test(expected = RuntimeException::class)
    fun pins_should_be_positive() {
        bowlingGame.roll(-1)
    }

    @Test(expected = RuntimeException::class)
    fun pins_should_inferior_or_equals_to_10() {
        bowlingGame.roll(11)
    }

    @Test
    fun given_only_holes_score_should_be_0() {
        //given
        for (rolls in 1..20)
            bowlingGame.roll(0)
        //when
        val score = bowlingGame.score()
        //then
        assertEquals(0, score)
    }

    @Test
    fun given_only_ones_score_should_be_20() {
        //given
        for (rolls in 1..20)
            bowlingGame.roll(1)
        //when
        val score = bowlingGame.score()
        //then
        assertEquals(20, score)
    }

    @Test
    fun given_spare_score_should_count_spare_bonus() {
        //given
        bowlingGame.roll(2)
        bowlingGame.roll(8)
        bowlingGame.roll(4)
        //when
        val score = bowlingGame.score()
        //then
        assertEquals(18, score)
    }

    @Test
    fun given_strike_score_should_count_strike_bonus() {
        //given
        bowlingGame.roll(10)
        bowlingGame.roll(8)
        bowlingGame.roll(4)
        //when
        val score = bowlingGame.score()
        //then
        assertEquals(34, score)
    }

//    @Test
}