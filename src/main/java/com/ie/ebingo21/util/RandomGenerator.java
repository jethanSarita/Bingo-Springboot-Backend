package com.ie.ebingo21.util;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomGenerator {
    private static final String CHARACTERS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final Random RANDOM   = new SecureRandom();

    public static String generateRandomString(int length) {
        if (length < 1) {
            throw new IllegalArgumentException("Length must be at least 1");
        }
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }

    public static List<Integer> generateNumbers(int start, int end, int length) {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < length) {
            int new_num = RANDOM.nextInt(end - start) + start;
            if (!numbers.contains(new_num)) {
                numbers.add(new_num);
            }
        }
        return numbers;
    }
}
