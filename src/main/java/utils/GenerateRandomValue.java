package utils;

import core.Logger;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;

public class GenerateRandomValue {

    /**
     * Generate random a-z string in LOWERCASE with X length
     */
    static public String generateRandomStringLowerCase(int targetStringLength) {
        Logger.getLog(Level.ALL, "Generate random a-z string in LOWERCASE");

        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'

        return new Random().ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    /**
     * Generate random A-Z string in UPPERCASE with X length
     */
    static public String generateRandomStringUpperCase(int targetStringLength) {
        Logger.getLog(Level.ALL, "Generate random A-Z string in UPPERCASE");

        int leftLimit = 65; // letter 'A'
        int rightLimit = 90; // letter 'Z'

        return new Random().ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    /**
     * Generate random Alphanumeric (0-9 A-z) String with X length
     */
    static public String generateRandomAlphanumericString(int targetStringLength) {
        Logger.getLog(Level.ALL, "Generate random Alphanumeric (0-9 A-z) string");

        int leftLimit = 48; // letter '0'
        int rightLimit = 122; // letter 'z'

        String generatedString = new Random().ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;
    }

    /**
     * Generate random number with X digits (Max 10 symbols - length)
     */
    static public int generateRandomNumberMax10digits(int yourNumberLength) {
        Logger.getLog(Level.ALL, "Generate random number with X digits (Max 10)");

        int m = (int) Math.pow(10, yourNumberLength - 1);
        return m + new Random().nextInt(9 * m);
    }

    /**
     * Generate random number with X digits (Max 9 symbols - length)
     */
    static public int generateRandomNumberMax9digits(int yourNumberLength) {
        Logger.getLog(Level.ALL, "Generate random number with X digits (Max 9)");

        int leftLimit = 48; // digit '0'
        int rightLimit = 57; // digit '9'

        String generatedNumber = new Random().ints(leftLimit, rightLimit + 1)
                .limit(yourNumberLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return Integer.parseInt(generatedNumber);
    }

    /**
     * Generate random number between min & max range
     */
    static public int generateRandomNumberRange(int min, int max) {
        Logger.getLog(Level.ALL, "Generate random number between min & max range");

        return new Random().nextInt((max - min) + 1) + min; // Using Random class
    }

    /**
     * Generate random boolean value
     */
    static public boolean generateRandomBoolean() {
        Logger.getLog(Level.ALL, "Generate random boolean value");

        return new Random().nextBoolean();
    }
}
