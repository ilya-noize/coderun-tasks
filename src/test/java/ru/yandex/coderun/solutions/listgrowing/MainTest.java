package ru.yandex.coderun.solutions.listgrowing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.yandex.coderun.solutions.listgrowing.Main.Answer.NO;
import static ru.yandex.coderun.solutions.listgrowing.Main.Answer.YES;
import static ru.yandex.coderun.solutions.listgrowing.Main.GrowingList.REGEX;

class MainTest {

    @Test
    void _whenGrowing_YesTest() {
        Main.Answer solution;
        String[] input = "1 7 9".split(REGEX);
        Main.GrowingList growingList = new Main.GrowingList(input);

        if (growingList.isGrowingList()) solution = NO;
        else solution = YES;

        assertEquals(YES, solution);
    }

    @Test
    void _whenNotGrowing_NoTest() {
        Main.Answer solution;
        String[] input = "1 9 7".split(REGEX);
        Main.GrowingList growingList = new Main.GrowingList(input);

        if (!growingList.isGrowingList()) solution = NO;
        else solution = YES;

        assertEquals(NO, solution);
    }

    @Test
    void _whenEqualThen_NoTest() {
        Main.Answer solution;
        String[] input = "2 2 2".split(REGEX);
        Main.GrowingList growingList = new Main.GrowingList(input);

        if (!growingList.isGrowingList()) solution = NO;
        else solution = YES;

        assertEquals(NO, solution);
    }
}