package ru.yandex.coderun.triangle;

public final class Triangle {
    public static final int TRIANGLE_SIDES = 3;

    private final int[] sides;

    public Triangle(int[] sides) {
        if (sides.length > TRIANGLE_SIDES || sides.length < TRIANGLE_SIDES) {
            throw new CustomException("Wrong triangle");
        }
        this.sides = sides;
    }

    public boolean isTriangle() {
        int a = sides[0];
        int b = sides[1];
        int c = sides[2];

        int[][] property = new int[3][3];
        property[0][0] = a;
        property[0][1] = Math.abs(b - c);
        property[0][2] = b + c;

        property[1][0] = b;
        property[1][1] = Math.abs(a - c);
        property[1][2] = a + c;

        property[2][0] = c;
        property[2][1] = Math.abs(a - b);
        property[2][2] = a + b;

        for (int i = 0; i < 3; i++) {
            int side = property[i][0];
            int diff = property[i][1];
            int sum = property[i][2];
            if (side <= diff) return false;
            if (side >= sum) return false;
        }

        return true;
    }
}
