package org.wondergems.aoc.days;

import io.hosuaby.inject.resources.junit.jupiter.GivenTextResource;
import io.hosuaby.inject.resources.junit.jupiter.TestWithResources;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestWithResources
class Day02Test {

    Day02 day02;

    @GivenTextResource("Day02_test.txt")
    String partOneTest;
    @GivenTextResource("Day02.txt")
    String partOne;

//    @GivenTextResource("Day01_part2_test.txt")
//    String partTwoTest;
//    @GivenTextResource("Day01_part2.txt")
//    String partTwo;

    @BeforeAll
    void setUp() {
        this.day02 = new Day02();
    }


    @Test
    void part1() {
        System.out.println(day02.part1(partOne.lines().toList()));
        assertEquals(2,this.day02.part1(partOneTest.lines().toList()));
    }

    @Test
    void part2() {
        System.out.println(day02.part2(partOne.lines().toList()));
        assertEquals(4,this.day02.part2(partOneTest.lines().toList()));
    }
}