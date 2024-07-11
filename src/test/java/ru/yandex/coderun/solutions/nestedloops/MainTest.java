package ru.yandex.coderun.solutions.nestedloops;

import org.junit.jupiter.api.Test;
import ru.yandex.coderun.solutions.nestedloops.model.CycleParameter;
import ru.yandex.coderun.solutions.nestedloops.model.RangeCycle;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.yandex.coderun.solutions.nestedloops.Main.DENOMINATOR;
import static ru.yandex.coderun.solutions.nestedloops.Main.runCyclesWithPreviousParametersCycles;

class MainTest {

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
    @Test
    void ExampleTest() {
        int result = 0;
        for (int a = 1; a <= 10; a++) {
            for (int b = a; b <= 12; b++) {
                for (int c = 5; c <= b; c++) {
                    result = (result + 1) % DENOMINATOR;
                }
            }
        }
        assertEquals(325, result);
    }

    @Test
    void AdvancedTest() {
        Map<Integer, RangeCycle> roadMapNestedLoops = new HashMap<>();

        roadMapNestedLoops.put(
                0, new RangeCycle(
                        new CycleParameter(1),
                        new CycleParameter(10))
        );
        roadMapNestedLoops.put(
                1, new RangeCycle(
                        new CycleParameter('a'),
                        new CycleParameter(12))
        );
        roadMapNestedLoops.put(
                2, new RangeCycle(
                        new CycleParameter(5),
                        new CycleParameter('b'))
        );

        int countNestedLoops = roadMapNestedLoops.size();

        int[] valuePreviousCycles = new int[countNestedLoops];

        int result = runCyclesWithPreviousParametersCycles(
                roadMapNestedLoops,
                valuePreviousCycles,
                0,
                countNestedLoops,
                0
        );

        assertEquals(325, result);
    }
}