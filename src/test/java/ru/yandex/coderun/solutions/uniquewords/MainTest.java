package ru.yandex.coderun.solutions.uniquewords;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.yandex.coderun.solutions.uniquewords.Main.getCountUniqueWordsInText;

class MainTest {

    @Test
    void test() {
        String text = """
                She sells sea shells on the sea shore;
                The shells that she sells are sea shells I'm sure.
                So if she sells sea shells on the sea shore,
                I'm sure that the shells are sea shore shells.
                """;
        String[] words = text.split("\\s+");
        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));

        System.out.println("uniqueWords = " + uniqueWords);
        long countUniqueWordsInText = uniqueWords.size();
        assertEquals(19, countUniqueWordsInText);
    }

    @Test
    void test2() {
        List<String> text = List.of(
                "She sells sea shells on the sea shore;\n",
                "The shells that she sells are sea shells I'm sure.\n",
                "So if she sells sea shells on the sea shore,\n",
                "I'm sure that the shells are sea shore shells.");

        long countUniqueWordsInText = getCountUniqueWordsInText(text);

        assertEquals(19, countUniqueWordsInText);
    }

}