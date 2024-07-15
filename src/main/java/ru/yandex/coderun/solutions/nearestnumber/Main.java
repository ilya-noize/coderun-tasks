package ru.yandex.coderun.solutions.nearestnumber;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));


        String[] lines = new String[3];
        lines[0] = reader.readLine().trim();
        lines[1] = reader.readLine().trim();
        lines[2] = reader.readLine().trim();

        short size = Short.parseShort(lines[0]);

        short[] storage = new short[size];
        String[] splitString = lines[1].split("\s+");
        for (int i = 0; i < size; i++) {
            short num = Short.parseShort(splitString[i]);
            if (num > NumericStorage.MAX)
                throw new Main.SolutionException("Wrong input number");
            storage[i] = num;
        }

        short findNearest = Short.parseShort(lines[2]);

        NumericStorage numericStorage = new NumericStorage(storage, size);
        writer.write(getAnswer(numericStorage.nearestNumberInExtremes(findNearest)));

        reader.close();
        writer.close();
    }

    private static String getAnswer(short result) {
        return String.valueOf(result);
    }

    static class NumericStorage {
        public static final short MAX = 1000;
        private final short[] storage;

        public NumericStorage(short[] storage, short length) {
            if (length > MAX || storage.length != length)
                throw new Main.SolutionException("Error in constructor");

            this.storage = storage;
        }

        public short nearestNumberInExtremes(short number) {
            short[] extremum = getExtremum();
            isValid(number);
            if (number <= extremum[0]) return extremum[0];
            if (number >= extremum[1]) return extremum[1];

            return nearestNumber(number);
        }

        private short nearestNumber(short number) {
            short near = isValid(number);
            short minDiff = number;
            for (short num : storage) {
                if (num == number) return num;

                int diff = Math.abs(num - number);
                if (minDiff >= diff) {
                    minDiff = (short) diff;
                    near = num;
                }
            }
            return near;
        }

        private short[] getExtremum() {
            short min = storage[0];
            short max = storage[0];
            for (int i = 1; i < storage.length; i++) {
                short num = isValid(storage[i]);
                if (num < min) min = num;
                if (num > max) max = num;
            }
            return new short[]{min, max};
        }

        private static short isValid(short num) {
            if (Math.abs(num) > MAX)
                throw new SolutionException("Over limit");
            return num;
        }
    }

    public static class SolutionException extends RuntimeException {
        public SolutionException(String message) {
            super(message);
        }
    }
}
