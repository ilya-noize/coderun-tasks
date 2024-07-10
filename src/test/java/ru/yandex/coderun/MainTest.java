package ru.yandex.coderun;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import ru.yandex.coderun.triangle.Triangle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static ru.yandex.coderun.Main.isPossibleToCreateTriangleFromSides;

@TestMethodOrder(MethodOrderer.MethodName.class)
class MainTest {

    @DisplayName("Простой тест 1")
    @Order(1)
    @Test
    void SimpleOneTest() {
        int[] sides = {3, 4, 5};
        Triangle triangle = new Triangle(sides);
        assertTrue(triangle.isTriangle());
    }


    @DisplayName("Простой тест 2")
    @Order(2)
    @Test
    void SimpleTwoTest() {
        int[] sides = {3, 5, 4};
        Triangle triangle = new Triangle(sides);
        assertTrue(triangle.isTriangle());
    }


    @DisplayName("Простой тест 3")
    @Order(3)
    @Test
    void SimpleThreeTest() {
        int[] sides = {4, 5, 3};
        Triangle triangle = new Triangle(sides);
        assertTrue(triangle.isTriangle());
    }


    @DisplayName("Простой тест 4")
    @Order(4)
    @Test
    void SimpleFourTest() {
        int[] sides = {4, 3, 5};
        Triangle triangle = new Triangle(sides);
        assertTrue(triangle.isTriangle());
    }


    @DisplayName("Простой тест 5")
    @Order(5)
    @Test
    void SimpleFiveTest() {
        int[] sides = {5, 4, 3};
        Triangle triangle = new Triangle(sides);
        assertTrue(triangle.isTriangle());
    }

    @DisplayName("Простой тест 6")
    @Order(6)
    @Test
    void SimpleSixTest() {
        int[] sides = {5, 3, 4};
        Triangle triangle = new Triangle(sides);
        assertTrue(triangle.isTriangle());
    }

    @DisplayName("Простой тест 7 - Minus")
    @Order(7)
    @Test
    void SimpleSevenTest() {
        int[] sides = {5, -3, 4};
        Triangle triangle = new Triangle(sides);
        assertFalse(triangle.isTriangle());
    }

    @DisplayName("Простой тест 8 - an equilateral triangle {3.3.3}")
    @Order(8)
    @Test
    void SimpleEightTest() {
        int[] sides = {3, 3, 3};
        Triangle triangle = new Triangle(sides);
        assertTrue(triangle.isTriangle());
    }

    @DisplayName("Простой тест 9 - {3.6.6}")
    @Order(9)
    @Test
    void SimpleNineTest() {
        int[] sides = {3, 6, 6};
        Triangle triangle = new Triangle(sides);
        assertTrue(triangle.isTriangle());
    }

    @DisplayName("Простой тест 10 - {1.1.2}")
    @Order(10)
    @Test
    void SimpleTenTest() {
        int[] sides = {1, 1, 2};
        Triangle triangle = new Triangle(sides);
        assertFalse(triangle.isTriangle());
    }

    @DisplayName("Боевой тест 1")
    @Order(20)
    @Test
    void Action_YesTest() {
        String answer = isPossibleToCreateTriangleFromSides(new String[]{"5", "3", "4"});
        assertEquals("YES", answer);
    }

    @DisplayName("Боевой тест 2")
    @Order(21)
    @Test
    void Action_NoTest() {
        String answer = isPossibleToCreateTriangleFromSides(new String[]{"5", "30", "4"});
        assertEquals("NO", answer);
    }


    @DisplayName("Боевой тест 3 - Исключение на отрицательное число")
    @Order(22)
    @Test
    void Action_ExceptionTest() {
        assertThrows(Main.CustomException.class, () -> isPossibleToCreateTriangleFromSides(new String[]{"5", "-3", "4"}));
    }
}