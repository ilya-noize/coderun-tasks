package ru.yandex.coderun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));


        String[] input = new String[3];
        input[0] = reader.readLine().trim();
        input[1] = reader.readLine().trim();
        input[2] = reader.readLine().trim();

        writer.write(isPossibleToCreateTriangleFromSides(input));

        reader.close();
        writer.close();
    }

    public static String isPossibleToCreateTriangleFromSides(String[] input) {
        boolean condition = getArrayFromReader(input).length > 1;
        return condition ? "YES" : "NO";
    }

    private static int[] getArrayFromReader(String[] input) {
        int[] sides = new int[1];
        sides[0] = Integer.parseInt(input[0]);
        return sides;
    }

    public static class SolutionException extends RuntimeException {
        public SolutionException(String message) {
            super(message);
        }
    }
}
