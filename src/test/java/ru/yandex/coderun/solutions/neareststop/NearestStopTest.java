package ru.yandex.coderun.solutions.neareststop;

import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.yandex.coderun.solutions.neareststop.NearestStop.getNearestStops;
import static ru.yandex.coderun.solutions.neareststop.utils.ArrayUtils.showArray;
import static ru.yandex.coderun.solutions.neareststop.utils.ArrayUtils.sortAscendingOrder;

class NearestStopTest {
    private final Random random = new Random();

    @DisplayName("Стандартная интерпретация")
    @Test
    @SneakyThrows
    void getNearestStopsTest() {
        String[] config = {"3", "2"};
        String[] lineBusStop = {"1", "3", "5"};
        String[] lineBus = {"4", "1"};

        int numberStops = Integer.parseInt(config[0]);
        int[] busStops = new int[numberStops];
        for (int i = 0; i < numberStops; i++) {
            busStops[i] = Integer.parseInt(lineBusStop[i]);
        }

        int numberBuses = Integer.parseInt(config[1]);
        int[] buses = new int[numberBuses];
        for (int i = 0; i < numberBuses; i++) {
            buses[i] = Integer.parseInt(lineBus[i]);
        }

        int[] stack = new int[]{2, 1};

        for (int i = 0; i < stack.length; i++) {
            System.out.println("stack = " + stack[i]);
            assertEquals(stack[i], getNearestStops(busStops, buses)[i]);
        }
    }

    @DisplayName("Рандом-интерпретация")
    @Test
    @SneakyThrows
    void getNearestStopsRandomTest() {

        int maxStop = 50;
        int maxBus = maxStop / 2;

        int numberBuses = random.nextInt(maxBus);
        System.out.printf("int[] buses = /* %d */{", numberBuses);
        String format = "%d,";
        int[] buses = new int[numberBuses];
        for (int i = 0; i < numberBuses; i++) {
            buses[i] = random.nextInt( maxStop);
            if (i + 1 == numberBuses) format = "%d";
            System.out.printf(format, buses[i]);
        }
        System.out.println("}");

        int numberStops = random.nextInt( maxStop);
        System.out.printf("int[] busStop = /* %d */{", numberStops);
        format = "%d,";
        int[] busStops = new int[numberStops];
        for (int i = 0; i < numberStops; i++) {
            busStops[i] = random.nextInt( maxStop);
            if (i + 1 == numberStops) format = "%d";
            System.out.printf(format, busStops[i]);
        }
        System.out.println("};");

        sortAscendingOrder(busStops, numberStops);
        showArray(busStops);

        int[] extended = getNearestStops(busStops, buses);

        int extSize = extended.length;
        System.out.printf("int[] extended = /* %d */{", extSize);
        format = "%d,";
        for (int i = 0; i < extSize; i++) {
            if (i + 1 == extSize) format = "%d";
            System.out.printf(format, extended[i]);
            assertEquals(extended[i], getNearestStops(busStops, buses)[i]);
        }
        System.out.println("};");
    }

    @DisplayName("Manual-Random-интерпретация")
    @Test
    @SneakyThrows
    void getNearestStopsManualAfterRandomTest() {
        int[] buses = {9, 20, 16, 1, 9, 21, 41, 43, 26, 41, 21, 49, 41, 48, 4};
        int[] busStops = {10, 40, 37, 42, 15, 47, 47, 42, 16, 16, 28, 40, 46, 44, 10, 40, 28, 10, 35, 20, 11, 43, 47, 48, 37, 27, 37, 18, 24, 11, 16, 36, 33, 34, 8, 11, 10, 42, 28, 44};
        int[] extended = {1, 14, 10, 1, 1, 14, 27, 33, 16, 27, 14, 41, 27, 40, 1};

        int extSize = extended.length;

        for (int i = 0; i < extSize; i++) {
            assertEquals(extended[i], getNearestStops(busStops, buses)[i]);
        }
    }

    @DisplayName("Сортировка (manual)")
    @Test
    @SneakyThrows
    void getSortManualTest() {
        int maxStop = 49;

        int[] busStops = {7, 40, 9, 42, 45, 19, 18, 39, 27, 2, 32, 28, 47, 3, 18, 1, 38, 11, 36, 37, 8, 27, 10, 27, 2, 42, 6, 3, 15, 23, 40, 48, 19, 48, 42, 49, 15, 21, 25, 5, 29, 26, 36, 28, 32, 25, 26, 46, 7};

        sortAscendingOrder(busStops, maxStop);

        int[] expected = {1, 2, 2, 3, 3, 5, 6, 7, 7, 8, 9, 10, 11, 15, 15, 18, 18, 19, 19, 21, 23, 25, 25, 26, 26, 27, 27, 27, 28, 28, 29, 32, 32, 36, 36, 37, 38, 39, 40, 40, 42, 42, 42, 45, 46, 47, 48, 48, 49};

        for (int i = 0; i < maxStop; i++) {
            assertEquals(expected[i], busStops[i]);
        }
    }

    @DisplayName("Сортировка (random)")
    @Test
    @SneakyThrows
    void getSortRandomTest() {
        int maxStop = random.nextInt(50);

        System.out.printf("new int[%d]%n{", maxStop);
        String format = "%d,";
        int[] busStops = new int[maxStop];
        for (int i = 0; i < maxStop; i++) {
            busStops[i] = random.nextInt(maxStop);
            if (i + 1 == maxStop) format = "%d";
            System.out.printf(format, busStops[i]);
        }
        System.out.println("}");

        int[] expected = sortAscendingOrder(busStops, maxStop);

        System.out.printf("new int[%d]%n{", maxStop);
        format = "%d,";
        for (int i = 0; i < maxStop; i++) {
            if (i + 1 == maxStop) format = "%d";
            System.out.printf(format, busStops[i]);
            assertEquals(expected[i], busStops[i]);
        }
        System.out.println("}");
    }
}