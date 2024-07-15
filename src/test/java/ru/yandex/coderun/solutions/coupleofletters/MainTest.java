package ru.yandex.coderun.solutions.coupleofletters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.yandex.coderun.solutions.coupleofletters.Main.solution;

class MainTest {

    @Test
    void simpleTest() {
        String input = "ABCABC A";

        assertEquals("BC", solution(input));
    }

    @Test
    void overLimitString() {
        String input = "QWERTY ASDFGH ZX".repeat(16);

        Assertions.assertThrows(RuntimeException.class,
                () -> solution(input),
                "Строка слишком длинная (256). Лимит 255 символов."
        );
    }

    @Test
    void emptyString() {
        String input = "";
        Assertions.assertThrows(RuntimeException.class,
                () -> solution(input),
                "Строка слишком короткая (0)."
        );
    }

    @Test
    void emptyNullString() {
        String input = null;
        Assertions.assertThrows(RuntimeException.class,
                () -> solution(input),
                "Строка слишком короткая (0)."
        );
    }
}