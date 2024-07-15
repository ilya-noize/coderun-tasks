package ru.yandex.coderun.solutions.opencalculator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));


        String[] input = new String[2];
        input[0] = reader.readLine().trim();
        input[1] = reader.readLine().trim();

        OpenCalculator openCalculator = new OpenCalculator(input[0]);
        int check = openCalculator.checkButtonsForEnterNumber(input[1]);

        writer.write(String.valueOf(check));

        reader.close();
        writer.close();
    }

    public static class SolutionException extends RuntimeException {
        public SolutionException(String message) {
            super(message);
        }
    }

    static class OpenCalculator {
        public static final String TEMPLATE = "0123456789";
        private final String[] numberButtons;

        public OpenCalculator(String numberString) {
            String[] numbers = numberString.split(" ");
            for (String number : numbers) {
                if (number.length() != 1) {
                    throw new SolutionException("OpenCalculator - wrong input!");
                }
                if (!TEMPLATE.contains(number))
                    throw new SolutionException("OpenCalculator - wrong numbers!");
            }
            this.numberButtons = numbers;
        }

        public OpenCalculator(String[] numberButtons) {
            for (String number : numberButtons) {
                if (number.length() != 1) {
                    throw new SolutionException("OpenCalculator - wrong input!");
                }
                if (!TEMPLATE.contains(number))
                    throw new SolutionException("OpenCalculator - wrong numbers!");
            }
            this.numberButtons = numberButtons;
        }

        public int checkButtonsForEnterNumber(String number) {
            if (number.compareTo("10000") < 0) {
                throw new SolutionException("Over limit by number.");
            }

            Set<Character> duplicates = new HashSet<>();

            for (char num : number.toCharArray()) {
                searchDuplicates(duplicates, num);
            }

            return duplicates.size();
        }

        private void searchDuplicates(Set<Character> duplicates, char num) {
            boolean numCheck = true;
            for (String button : numberButtons) {
                if (num == button.charAt(0)) {
                    numCheck = false;
                    break;
                }
            }
            if(numCheck)
                duplicates.add(num);
        }
    }
}
