package com.example.demo.util;

public class RepeatOffenderCalculator {

    /**
     * Calculates the next repeat-offender count
     *
     * @param previousCount number of previous offenses
     * @return updated offense count
     */
    public static int calculateNextCount(int previousCount) {
        if (previousCount < 0) {
            return 1;
        }
        return previousCount + 1;
    }
}
