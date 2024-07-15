package ru.yandex.coderun.solutions.nearestnumber;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void test1() {
        short n = 5;
        short[] storage = {1,2,3,4,5};
        short find = 6;
        short expected = 5;

        Main.NumericStorage numericStorage = new Main.NumericStorage(storage, n);
        assertEquals(expected, numericStorage.nearestNumberInExtremes(find));
    }

    @Test
    void test2() {
        short n = 5;
        short[] storage = {5,4,3,2,1};
        short find = 3;
        short expected = 3;

        Main.NumericStorage numericStorage = new Main.NumericStorage(storage, n);
        assertEquals(expected, numericStorage.nearestNumberInExtremes(find));
    }

    @Test
    void test3() {
        short n = 5;
        short[] storage = {3,4,3,5,100};
        short find = 500;
        short expected = 100;

        Main.NumericStorage numericStorage = new Main.NumericStorage(storage, n);
        assertEquals(expected, numericStorage.nearestNumberInExtremes(find));
    }

    @Test
    void test4() {
        short n = 5;
        short[] storage = {1,4,3,5,100};
        short find = 1;
        short expected = 1;

        Main.NumericStorage numericStorage = new Main.NumericStorage(storage, n);
        assertEquals(expected, numericStorage.nearestNumberInExtremes(find));
    }

    @Test
    void test5() {
        short n = 5;
        short[] storage = {300,400,430,55,100};
        short find = 75;
        short expected = 55;

        Main.NumericStorage numericStorage = new Main.NumericStorage(storage, n);
        assertEquals(expected, numericStorage.nearestNumberInExtremes(find));
    }

    @Test
    void testException1() {
        short n = 6;
        short[] storage = {300,400,430,55,100};

        assertThrows(Main.SolutionException.class,
                () -> new Main.NumericStorage(storage, n),
                "Error in constructor");
    }

    @Test
    void testException2() {
        short n = 5;
        short[] storage = {300,400,430,100};

        assertThrows(Main.SolutionException.class,
                () -> new Main.NumericStorage(storage, n),
                "Error in constructor");
    }

    @Test
    void testException3() {
        short n = 5;
        short[] storage = {300,400,430,1,1001};
        short find = 75;

        Main.NumericStorage numericStorage = new Main.NumericStorage(storage, n);

        assertThrows(Main.SolutionException.class,
                () -> numericStorage.nearestNumberInExtremes(find),
                "Over limit");
    }

    @Test
    void testException4() {
        short n = 5;
        short[] storage = {300,400,430,1,1000};
        short find = -7500;

        Main.NumericStorage numericStorage = new Main.NumericStorage(storage, n);

        assertThrows(Main.SolutionException.class,
                () -> numericStorage.nearestNumberInExtremes(find),
                "Over limit");
    }
}