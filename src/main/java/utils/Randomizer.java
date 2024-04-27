package utils;

import org.apache.commons.lang3.RandomStringUtils;

public class Randomizer {
    public static String getRandomString(int length, boolean letters, boolean digits) {
        return RandomStringUtils.random(length, letters, digits).toLowerCase();
    }
}