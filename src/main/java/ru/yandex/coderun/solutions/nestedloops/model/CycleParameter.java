package ru.yandex.coderun.solutions.nestedloops.model;

import java.util.List;

public final class CycleParameter {
    public static final List<Character> ALPHABET = List.of(
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
    public static final int LIMIT = 100_000;
    private Character parameterName;
    private Integer value;

    public CycleParameter(Character parameterName) {
        if (!ALPHABET.contains(parameterName)) {
            char first = ALPHABET.get(0);
            char last = ALPHABET.get(ALPHABET.size() - 1);
            System.out.println("Must be [" + first + " — " + last + "] character.");
            return;
        }
        this.parameterName = parameterName;
    }

    public CycleParameter(Integer value) {
        this.value = value;
    }

    public Character getParameterName() {

        return parameterName;
    }

    public Integer getValue() {

        return value;
    }


}
