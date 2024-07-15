package ru.yandex.coderun.solutions.neareststop.thread;

import lombok.SneakyThrows;

import java.io.BufferedWriter;

public class NearestStopsThread implements Runnable {
    public static final String NEW_LINE = "\n";
    private final int[] busStops;
    private final int countBusStop;
    private final int bus;
    private final BufferedWriter writer;


    public NearestStopsThread(int[] busStops, int bus, BufferedWriter writer) {
        this.busStops = busStops;
        this.countBusStop = busStops.length;
        this.bus = bus;
        this.writer = writer;
    }

    @SneakyThrows
    @Override
    public void run() {
        int index = countBusStop;
        int busStop = busStops[index - 1];
        int distance = Math.abs(bus - busStop);

        if (distance != 0) {
            int numberStop = countBusStop - 2;
            while (numberStop >= 0) {

                busStop = busStops[numberStop];

                int currentDistance = Math.abs(bus - busStop);

                if (distance >= currentDistance) {
                    if (numberStop != 0) {
                        distance = currentDistance;
                        index = numberStop;
                    } else {
                        writer.write(numberStop + 1 + NEW_LINE);
                        return;
                    }
                } else {
                    writer.write(index + 1 + NEW_LINE);
                    return;
                }
                numberStop--;
            }
        }
    }
}
