package org.wondergems.aoc.days;

import io.hosuaby.inject.resources.junit.jupiter.GivenTextResource;
import io.hosuaby.inject.resources.junit.jupiter.TestWithResources;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestWithResources
class Day03Test {

    Day03 day03;

    @GivenTextResource("Day03_test.txt")
    String partOneTest;
    @GivenTextResource("Day03.txt")
    String partOne;

//    @GivenTextResource("Day01_part2_test.txt")
//    String partTwoTest;
//    @GivenTextResource("Day01_part2.txt")
//    String partTwo;

    @BeforeAll
    void setUp() {
        this.day03 = new Day03();
    }


    @Test
    void part1() {
        System.out.println(day03.part1(partOne.lines().toList()));
        assertEquals(161,this.day03.part1(partOneTest.lines().toList()));
    }

    @Test
    void part2() {
        System.out.println(day03.part2(partOne.lines().toList()));
        assertEquals(48,this.day03.part2(partOneTest.lines().toList()));
    }

    @Test
    void part1Refined() {
        System.out.println(day03.part1Refined(partOne.lines().toList()));
        assertEquals(161,this.day03.part1Refined(partOneTest.lines().toList()));
    }
}