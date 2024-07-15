package ru.yandex.coderun.solutions.nestedloops.model;

public record RangeCycle(CycleParameter initialValue,
                         CycleParameter finalValue) {
    public static final byte ASCII_CODE_FIRST_CHAR =
            (byte) (char) CycleParameter.ALPHABET.get(0);
    public static final String RANGE_CYCLE_VALUE_NULL = "RangeType Cycle Value — null.";

    public int getRangeTypeInLoopWithPreviousCyclesParameters(
            RangeType rangeType,
            int loop,
            int[] parameters
    ) {

        CycleParameter cycleParameter = getCycleParameter(rangeType);
        Integer value = cycleParameter.getValue();
        Character param = cycleParameter.getParameterName();

        if (loop != 0) {
            if (param == null) {
                if (value == null) {
                    throw new NullPointerException(RANGE_CYCLE_VALUE_NULL);
                }

                return value;
            }

            byte indexParameter = (byte) (param - ASCII_CODE_FIRST_CHAR);
            int lift = parameters[indexParameter];
            if (lift == 0) {
                throw new NullPointerException("Parameter — null.");
            }

            return lift;
        }
        if (value == null) {
            throw new NullPointerException(RANGE_CYCLE_VALUE_NULL);
        }

        return value;
    }

    private CycleParameter getCycleParameter(RangeType rangeType) {
        if (rangeType == RangeType.INITIAL) {

            return initialValue();
        }

        return finalValue();
    }
}
