package tests;

import org.junit.Test;
import utils.GenerateRandomValue;

public class Task11 {

    @Test
    public void task11_test1() {
        GenerateRandomValue generateRandomValue = new GenerateRandomValue();

        System.out.println(generateRandomValue.generateRandomStringLowerCase(10));
        System.out.println(generateRandomValue.generateRandomStringUpperCase(10));
        System.out.println(generateRandomValue.generateRandomAlphanumericString(10));
        System.out.println(generateRandomValue.generateRandomNumberMax10digits(10));
        System.out.println(generateRandomValue.generateRandomNumberMax9digits(9));
        System.out.println(generateRandomValue.generateRandomNumberRange(1, 10));
        System.out.println(generateRandomValue.generateRandomBoolean());
    }
}
