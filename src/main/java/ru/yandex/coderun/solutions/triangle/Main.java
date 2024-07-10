package ru.yandex.coderun.solutions.triangle;

import ru.yandex.coderun.exceptions.SolutionException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));


        String[] inputString = new String[3];
        inputString[0] = reader.readLine().trim();
        inputString[1] = reader.readLine().trim();
        inputString[2] = reader.readLine().trim();

        writer.write(isPossibleToCreateTriangleFromSides(inputString));

        reader.close();
        writer.close();
    }

    public static String isPossibleToCreateTriangleFromSides(String[] input) {
        int[] sides = getArrayFromReader(input);

        Triangle triangle = new Triangle(sides);

        return triangle.isTriangle() ? "YES" : "NO";
    }

    private static int[] getArrayFromReader(String[] input) {
        int max = Triangle.TRIANGLE_SIDES;
        int[] sides = new int[max];
        for (int i = 0; i < max; i++) {
            int side = Integer.parseInt(input[i]);
            if (side <= 0) {
                throw new SolutionException("Wrong side");
            }
            sides[i] = side;
        }
        return sides;
    }
}

