package ru.yandex.coderun.solutions.neareststop.thread;

import ru.yandex.coderun.solutions.neareststop.utils.ArrayUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
# Example <br/>
## IN   <br/>
3 2     <br/>
1 3 5   <br/>
4 1     <br/>

## OUT  <br/>
2       <br/>
1       <br/>

 */
public class NearestStopAsync {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] config = reader.readLine().trim().split(" ");
        String[] lineBusStop = reader.readLine().trim().split(" ");
        String[] lineBus = reader.readLine().trim().split(" ");

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

        ArrayUtils.sortAscendingOrder(busStops, numberStops);

        for (int bus : buses) {
            NearestStopsThread thread = new NearestStopsThread(busStops, bus, writer);
            thread.run();
        }

        reader.close();
        writer.close();
    }
}