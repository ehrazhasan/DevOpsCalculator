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


}
