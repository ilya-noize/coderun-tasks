package ru.yandex.coderun.solutions.twoteams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static final int MAX = 10000;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));


        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int n = Integer.parseInt(reader.readLine());

        boolean result = isA(a, b, n);

        if (result) {
            writer.write("Yes");
        } else {
            writer.write("No");
        }

        reader.close();
        writer.close();
    }

    public static boolean isA(int a, int b, int n) {
        if (isInvalid(a, b, n)) {
            return false;
        }

        int teamA = a / n;
        int teamB = b / n;

        int i1 = a % n;
        if (i1 > 0) teamA++;
        int i2 = b % n;
        if (i2 > 0) teamB++;

        return teamA > teamB;
    }

    private static boolean isInvalid(int a, int b, int n) {
        return (a < 0 || a > MAX) ||
                (b < 0 || b > MAX) ||
                (n < 1 || n > MAX);
    }
}
