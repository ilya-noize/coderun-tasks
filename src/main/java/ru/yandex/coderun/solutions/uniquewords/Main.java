package ru.yandex.coderun.solutions.uniquewords;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));


        List<String> text = new ArrayList<>();
        while (true) {
            String s = reader.readLine();
            if (s == null) break;

            text.add(s + "\n");
        }
        long countUniqueWordsInText = getCountUniqueWordsInText(text);
        writer.write(String.valueOf(countUniqueWordsInText));

        reader.close();
        writer.close();
    }

    public static long getCountUniqueWordsInText(List<String> lines) {
        StringBuilder builder = new StringBuilder();
        lines.forEach(builder::append);

        List<String> words = List.of(builder.toString().split("\\s|\\n+"));
        List<String> unique = words.stream().distinct().toList();

        return unique.size();
    }
}
