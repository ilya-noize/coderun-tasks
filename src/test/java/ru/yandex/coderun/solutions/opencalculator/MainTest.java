package ru.yandex.coderun.solutions.opencalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Test
    void _whenAllNumbersCanEnter_thenZero() {
        String numberButtons = "1 2 3";
        String number = "1123";

        Main.OpenCalculator openCalculator = new Main.OpenCalculator(numberButtons.split(" "));
        int needButtons = openCalculator.checkButtonsForEnterNumber(number);

        assertEquals("0", String.valueOf(needButtons));
    }

    @Test
    void _whenOneNumbersCantEnter_thenOne() {
        String numberButtons = "1 2 3";
        String number = "1001";

        Main.OpenCalculator openCalculator = new Main.OpenCalculator(numberButtons.split(" "));
        int needButtons = openCalculator.checkButtonsForEnterNumber(number);

        assertEquals("1", String.valueOf(needButtons));
    }
}