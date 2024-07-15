package ru.yandex.coderun.solutions.listgrowing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    enum Answer{
        YES,
        NO
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = reader.readLine().trim();

        boolean isGrowingList = new GrowingList(input).isGrowingList();

        writer.write(isGrowingList ? Answer.YES.name() : Answer.NO.name());

        reader.close();
        writer.close();
    }

    static class GrowingList {
        public static final String REGEX = " ";
        private final String[] list;

        public GrowingList(String string) {
            if (string == null)
                throw new NullPointerException("null");

            this.list = string.split(REGEX);
        }

        public GrowingList(String[] list) {
            if (list == null)
                throw new NullPointerException("null");

            this.list = list;
        }

        public boolean isGrowingList() {
            for (int i = 0; i < list.length - 1; i++) {
                String next = list[i+1];
                if (isMoreOrEquals(list[i], next)) {
                    return false;
                }
            }

            return true;
        }

        private boolean isMoreOrEquals(String num1, String num2) {
            if (num1.length() > num2.length())
                return true;
            else return num1.compareTo(num2) >= 0;
        }
    }
}
