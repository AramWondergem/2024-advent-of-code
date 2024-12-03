package org.wondergems.aoc.days;

import io.hosuaby.inject.resources.junit.jupiter.GivenTextResource;
import io.hosuaby.inject.resources.junit.jupiter.TestWithResources;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestWithResources
class Day01Test {

    Day01 day01;

    @GivenTextResource("Day01_part1_test.txt")
    String partOneTest;
    @GivenTextResource("Day01_part1.txt")
    String partOne;

//    @GivenTextResource("Day01_part2_test.txt")
//    String partTwoTest;
//    @GivenTextResource("Day01_part2.txt")
//    String partTwo;

    @BeforeAll
    void setUp() {
        this.day01 = new Day01();
    }


    @Test
    void part1() {
        System.out.println(day01.part1(partOne.lines().toList()));
        assertEquals(11,this.day01.part1(partOneTest.lines().toList()));
    }

    @Test
    void part2() {
        System.out.println(day01.part2(partOne.lines().toList()));
        assertEquals(31,this.day01.part2(partOneTest.lines().toList()));
    }
}