package ru.yandex.coderun.solutions.coupleofletters;

import ru.yandex.coderun.exceptions.SolutionException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = reader.readLine();

        writer.write(solution(input));

        reader.close();
        writer.close();
    }

    public static String solution(String input) {
        if(input == null) {
            throw new NullPointerException();
        }
        int maxLength = input.length();
        if (maxLength >= 255) {
            throw new SolutionException("Строка слишком длинная (" + maxLength + "). Лимит 255 символов.");
        }

        if (maxLength < 2) {
            throw new SolutionException("Строка слишком короткая (" + maxLength + ").");
        }

        String[] words = input.trim().split("/w+ ");

        Map<String, Integer> counterCoupleOfLettersStore = getStatisticsCoupleOfLetters(words);

        if (counterCoupleOfLettersStore.isEmpty()) {
            throw new SolutionException("Массив статистики пуст");
        }

        int counterMax = getMaxFrequencyOfOccurrence(counterCoupleOfLettersStore);
        if (counterMax == 0) {
            throw new NullPointerException("Максимальная частота повторов — null");
        }

        List<String> coupleOfLettersStore = getMostPopularLetters(counterCoupleOfLettersStore, counterMax);
        if (coupleOfLettersStore.isEmpty()) {
            throw new SolutionException("Часто повторяющиеся пара символов не найдена");
        }

        int coupleStoreSize = coupleOfLettersStore.size();

        if (coupleStoreSize != 1) {
            return coupleOfLettersStore.get(coupleStoreSize - 1);
        }

        return coupleOfLettersStore.get(0);
    }

    private static Map<String, Integer> getStatisticsCoupleOfLetters(String[] words) {
        Map<String, Integer> statisticsCoupleOfLetters = new HashMap<>();
        for (String word : words) {
            calculateAndSaveStatictics(statisticsCoupleOfLetters, word);
        }

        return statisticsCoupleOfLetters.size() != 0 ? statisticsCoupleOfLetters : Map.of();
    }

    private static void calculateAndSaveStatictics(Map<String, Integer> statisticsCoupleOfLetters, String word) {
        int length = word.length();
        if (length >= 2) {
            for (int i = 0; i < length; i++) {
                if (i + 2 > length) break;

                String coupleOfLetters = word.trim().substring(i, i + 2).trim();
                if (coupleOfLetters.length() == 2) {

                    if (statisticsCoupleOfLetters.containsKey(coupleOfLetters)) {
                        int counter = statisticsCoupleOfLetters.get(coupleOfLetters);
                        statisticsCoupleOfLetters.replace(coupleOfLetters, ++counter);
                    } else {
                        statisticsCoupleOfLetters.put(coupleOfLetters, 1);
                    }
                }
            }
        }
    }

    private static List<String> getMostPopularLetters(Map<String, Integer> counterCoupleOfLettersStore, Integer counterMax) {
        List<String> coupleOfLettersStore = new ArrayList<>();
        counterCoupleOfLettersStore.keySet().forEach(key -> {
            Integer counter = counterCoupleOfLettersStore.get(key);
            if (counter.equals(counterMax)) {
                coupleOfLettersStore.add(key);
            }
        });

        return coupleOfLettersStore;
    }

    private static int getMaxFrequencyOfOccurrence(Map<String, Integer> counterCoupleOfLettersStore) {

        return counterCoupleOfLettersStore.keySet().stream()
                .map(counterCoupleOfLettersStore::get)
                .mapToInt(key -> key)
                .filter(key -> key >= 0)
                .max()
                .orElse(0);
    }
}
