package ru.yandex.coderun.solutions.twoteams;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static ru.yandex.coderun.solutions.twoteams.Main.isA;

class MainTest {

    @ParameterizedTest
    @CsvSource({
            "10, 8, 2"
    })
    void AllTrueTests(int a, int b, int n) {
        boolean solution = isA(a, b, n);
        System.out.println("solution = " + solution);
        assertTrue(solution);
    }

    @ParameterizedTest
    @CsvSource({
            "3, 10, 3",
            "10000, 9999, 10000",
            "9999, 10000, 10000",
            "10000, 10000, 10000",
            "10001, 10001, 10001"
    })
    void AllFalseTests(int a, int b, int n) {
        boolean solution = isA(a, b, n);
        assertFalse(solution);
    }
}