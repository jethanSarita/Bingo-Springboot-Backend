package com.ie.ebingo21.util;

import java.util.List;

public class CardHelper {
    public List<Integer> generateB() {
        return RandomGenerator.generateNumbers(1, 16, 5);
    }
    public List<Integer> generateI() {
        return RandomGenerator.generateNumbers(16, 31, 5);
    }
    public List<Integer> generateN() {
        return RandomGenerator.generateNumbers(31, 46, 5);
    }
    public List<Integer> generateG() {
        return RandomGenerator.generateNumbers(46, 61, 5);
    }
    public List<Integer> generateO() {
        return RandomGenerator.generateNumbers(61, 76, 5);
    }
}
