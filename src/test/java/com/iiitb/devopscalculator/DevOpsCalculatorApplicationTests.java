package com.iiitb.devopscalculator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DevOpsCalculatorApplicationTests {
    private static final double DELTA = 1e-15;
    MainController calculator = new MainController();
    @Test
    public void logTruePositive(){
        System.out.println("Finding natural log for True Positive");
        assertEquals(0, calculator.getLog(String.valueOf(1)), DELTA);
        assertEquals(0, calculator.getLog(String.valueOf(1)), DELTA);
    }

    @Test
    public void logFalsePositive(){
        System.out.println("Finding natural log for False Positive");
        assertNotEquals(6, calculator.getLog(String.valueOf(2.4)), DELTA);
        assertNotEquals(7.3, calculator.getLog(String.valueOf(2.1)), DELTA);
    }

    @Test
    public void factorialTruePositive(){
        System.out.println("Finding factorial for True Positive");
        assertEquals(6, calculator.getFact(String.valueOf(3)), DELTA);
        assertEquals(24, calculator.getFact(String.valueOf(4)), DELTA);
    }

    @Test
    public void factorialFalsePositive(){
        System.out.println("Finding factorial for False Positive");
        assertNotEquals(120, calculator.getFact(String.valueOf(6)), DELTA);
        assertNotEquals(24, calculator.getFact(String.valueOf(3)), DELTA);
    }

    @Test
    public void powerTruePositive(){
        System.out.println("Finding Power for True Positive");
        assertEquals(8, calculator.getPower(String.valueOf(2), String.valueOf(3)), DELTA);
        assertEquals(64, calculator.getPower(String.valueOf(4), String.valueOf(3)), DELTA);
    }

    @Test
    public void powerFalsePositive(){
        System.out.println("Finding Power for False Positive");
        assertNotEquals(6, calculator.getPower(String.valueOf(2), String.valueOf(2)), DELTA);
        assertNotEquals(-7.3, calculator.getPower(String.valueOf(2), String.valueOf(3)), DELTA);
    }

    @Test
    public void sqrtTruePositive(){
        System.out.println("Finding SQRT for True Positive");
        assertEquals(2, calculator.getSquareRoot(String.valueOf(4)), DELTA);
        assertEquals(1, calculator.getSquareRoot(String.valueOf(1)), DELTA);
    }

    @Test
    public void sqrtFalsePositive(){
        System.out.println("Finding SQRT for False Positive");
        assertNotEquals(1, calculator.getSquareRoot(String.valueOf(3)), DELTA);
        assertNotEquals(0, calculator.getSquareRoot(String.valueOf(4)), DELTA);

    }
}
