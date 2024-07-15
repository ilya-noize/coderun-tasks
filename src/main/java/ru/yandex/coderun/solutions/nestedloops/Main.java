package ru.yandex.coderun.solutions.nestedloops;

import ru.yandex.coderun.exceptions.SolutionException;
import ru.yandex.coderun.solutions.nestedloops.model.CycleParameter;
import ru.yandex.coderun.solutions.nestedloops.model.RangeCycle;
import ru.yandex.coderun.solutions.nestedloops.model.RangeType;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * INPUT    <br/>
 * 3        <br/>
 * 1 10     <br/>
 * a 12     <br/>
 * 5 b      <br/>
 * <p>
 * OUTPUT   <br/>
 * 325
 */
public class Main {
    public static final int LOOP_MAX = 26;
    public static final int LOOP_MIN = 1;
    public static final int DENOMINATOR = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String inputN = reader.readLine();
        int nestedLoops = Integer.parseInt(inputN);
        if (nestedLoops < LOOP_MIN || nestedLoops > LOOP_MAX) {
            throw new SolutionException("Nested Loops over the limit.");
        }

        Map<Integer, RangeCycle> roadMapNestedLoops = new HashMap<>();

        for (int loop = 0; loop < nestedLoops; loop++) {
            String inputLoopBoundaries = reader.readLine();
            String[] loopBoundaries = inputLoopBoundaries.trim().split(" ");

            RangeCycle rangeCycle = getRangeCycle(loopBoundaries);
            roadMapNestedLoops.put(loop, rangeCycle);
        }

        int countNestedLoops = roadMapNestedLoops.size();

        int[] valuePreviousCycles = new int[countNestedLoops];

        int result = runCyclesWithPreviousParametersCycles(
                roadMapNestedLoops,
                valuePreviousCycles,
                0,
                countNestedLoops,
                0
        );

        writer.write(result + "\n");

        reader.close();
        writer.close();
    }

    private static RangeCycle getRangeCycle(String[] loopBoundaries) {
        CycleParameter initialCycleParameter =
                getCycleParameter(loopBoundaries[0]);
        CycleParameter finalCycleParameter =
                getCycleParameter(loopBoundaries[1]);

        return new RangeCycle(initialCycleParameter, finalCycleParameter);
    }

    private static CycleParameter getCycleParameter(String string) {
        char parameterName = string.charAt(0);
        if (CycleParameter.ALPHABET.contains(parameterName)) {

            return new CycleParameter(parameterName);
        } else {
            int value = Integer.parseInt(string);
            if (value > CycleParameter.LIMIT) {
                throw new SolutionException("Lift or Raise Loop over the limit.");
            }
            return new CycleParameter(value);
        }
    }

    public static int runCyclesWithPreviousParametersCycles(
            Map<Integer, RangeCycle> roadMapNestedLoops,
            int[] valuePreviousCycles,
            Integer loop,
            int countNestedLoops,
            int result
    ) {
        RangeCycle rangeCycle = roadMapNestedLoops.get(loop);

        int initialValue = rangeCycle.getRangeTypeInLoopWithPreviousCyclesParameters(
                RangeType.INITIAL,
                loop,
                valuePreviousCycles
        );
        int finalValue = rangeCycle.getRangeTypeInLoopWithPreviousCyclesParameters(
                RangeType.FINAL,
                loop,
                valuePreviousCycles
        );

        for (int i = initialValue; i <= finalValue; i++) {

            if (loop + 1 != countNestedLoops) {

                valuePreviousCycles[loop] = i;
                result = runCyclesWithPreviousParametersCycles(
                        roadMapNestedLoops,
                        valuePreviousCycles,
                        ++loop,
                        countNestedLoops,
                        result
                );
                loop--;
            }
            if (loop + 1 == countNestedLoops) {
                result = (result + 1) % DENOMINATOR;
            }
        }

        return result;
    }
}


