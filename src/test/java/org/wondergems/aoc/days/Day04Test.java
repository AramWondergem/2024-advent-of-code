package org.wondergems.aoc.days;

import io.hosuaby.inject.resources.junit.jupiter.GivenTextResource;
import io.hosuaby.inject.resources.junit.jupiter.TestWithResources;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestWithResources
class Day04Test {

//    Day04 day04;

    @GivenTextResource("Day04_test.txt")
    String partOneTest;
    @GivenTextResource("Day04.txt")
    String partOne;

//    @BeforeAll
//    void setUp() {
//        this.day04 = new Day04("XMAS");
//    }


    @Test
    void part1() {
        Day04 day04 = new Day04("XMAS");
        System.out.println(day04.part1(partOne.lines().toList()));
        assertEquals(18,day04.part1(partOneTest.lines().toList()));
    }

    @Test
    void part2() {
        Day04 day04 = new Day04("MAS");
        System.out.println(day04.part2(partOne.lines().toList()));
        assertEquals(9,day04.part2(partOneTest.lines().toList()));
    }

}