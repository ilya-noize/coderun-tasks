package ru.yandex.coderun.solutions.neareststop.utils;

public class ArrayUtils {

    private ArrayUtils() {
    }

    public static void showArray(int[] busStops) {
        int numberStops = busStops.length;
        System.out.println();
        System.out.printf("int[] busStopSort = /* %d */{%n", numberStops);
        String format = "  %d => %d,%n";
        for (int i = 0; i < numberStops; i++) {
            if (i + 1 == numberStops) format = "  %d => %d";
            System.out.printf(format, i + 1, busStops[i]);
        }
        System.out.println("};");
    }

    public static int[] sortAscendingOrder(int[] a, int size) {
        int[] seq = new int[40];
        int s;

        // вычисление последовательности приращений
        s = increment(seq, size);
        while (s >= 0) {
            // сортировка вставками с инкрементами inc[]
            int inc = seq[s--];

            for (int i = inc; i < size; i++) {
                try {
                    int temp = a[i];
                    int j;
                    for (j = i - inc; (j >= 0) && (a[j] > temp); j -= inc) {
                        a[j + inc] = a[j];
                    }
                    a[j + inc] = temp;
                } catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                    break;
                }
            }
        }
        return a;
    }

    private static int increment(int[] inc, int size) {
        int p1 = 1;
        int p2 = 1;
        int p3 = 1;
        int s = -1;

        do {
            if ((++s % 2) > 0) {
                inc[s] = 8 * p1 - 6 * p2 + 1;
            } else {
                inc[s] = 9 * p1 - 9 * p3 + 1;
                p2 *= 2;
                p3 *= 2;
            }
            p1 *= 2;
        } while (3 * inc[s] < size);

        return s > 0 ? --s : 0;
    }
}
