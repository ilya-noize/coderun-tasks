package ru.yandex.coderun.solutions.stepik;

import java.math.BigInteger;
import java.util.Arrays;

public class StepikTrainee {

    public static void main(String[] args) {
        int i = flipBit(0, 1);
        System.out.println("flipBit = " + i);

        double a = 0x0bp3;
        // 0b[16] => 11[10]; p3 => 2^3; => 88.0
        System.out.println("a = " + a);

        String string = "Madam, I'm Adam!";
        boolean isPolindrom = isPolindrom(string.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(), 0);
        System.out.println("isPolindrom = " + isPolindrom);

        BigInteger factorial = factorial(5);
        System.out.println("factorial = " + factorial);

        int[] a1 = {0, 2, 2};
        int[] a2 = {1, 3};
        String array = Arrays.toString(mergeArrays(a1, a2));
        System.out.println("array = " + array);
    }

    /**
     * Merges two given sorted arrays into one
     *
     * @param a1 first sorted array
     * @param a2 second sorted array
     * @return new array containing all elements from a1 and a2, sorted
     */
    public static int[] mergeArrays(int[] a1, int[] a2) {
        int lA1 = a1.length;
        int lA2 = a2.length;
        int[] a = new int[lA1 + lA2];
        for (int i = 0; i < lA1; i++) {
            for (int j = 0; j < lA2; j++) {
                a[i + j] = Math.min(a1[i], a2[j]);
            }
        }
        return a;
    }

    /**
     * Calculates factorial of given <code>value</code>.
     *
     * @param value positive number
     * @return factorial of <code>value</code>
     */
    public static BigInteger factorial(int value) {
        BigInteger result = BigInteger.valueOf(value);
        if (value == 1) return BigInteger.ONE;
        // 3*2*1 раскрутка стека
        // 1*2*3 скрутка стека - результат
        return result.multiply(factorial(--value));
    }

    /**
     * Flips one bit of the given <code>value</code>.
     *
     * @param value    any number
     * @param bitIndex index of the bit to flip, 1 <= bitIndex <= 32
     * @return new value with one bit flipped
     */
    public static int flipBit(int value, int bitIndex) {

        return value ^ (1 << (bitIndex - 1));
    }

    private static boolean isPolindrom(String string, int i) {
        System.out.println("string = " + string);
        int length = string.length();
        if (string.charAt(i) != string.charAt(length - 1 - i)) {
            return false;
        }
        if (length / 2 == i) {
            return true;
        }
        return isPolindrom(string, ++i);
    }
}