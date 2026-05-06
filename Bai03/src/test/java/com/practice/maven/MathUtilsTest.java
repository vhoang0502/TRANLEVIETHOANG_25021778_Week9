package com.practice.maven;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MathUtilsTest {

    @Test
    public void testAdd() {
        MathUtils math = new MathUtils();
        assertEquals(5, math.add(2, 3), "2 + 3 phai bang 5");
    }

    @Test
    public void testDivideByZero() {
        MathUtils math = new MathUtils();
        assertThrows(IllegalArgumentException.class, () -> {
            math.divide(5, 0);
        });
    }
}