package com.inovus.carnum.helper;

/**
 * The helper for working with numbers.
 * Excludes the region partition.
 * Handles only three number sequences.
 */
public class CarNumbersHelper implements Helper {

    /**
     * Returns the next sequence of numbers.
     * Changes begin from the last number.
     *
     * @param numbers - current numbers.
     * @return - next numbers as string.
     * Start positions fills with zero, if has less than three digit.
     */
    @Override
    public String getNext(String numbers) {
        int nextNumber = Integer.parseInt(numbers) + 1;
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(nextNumber));

        if (nextNumber < 10) {
            stringBuilder.insert(0, "00");
        } else if (nextNumber < 100) {
            stringBuilder.insert(0, "0");
        }

        return stringBuilder.toString();
    }

    /**
     * Checks existing of the next combination of numbers.
     *
     * @param numbers - current numbers.
     * @return true - if has, false - otherwise.
     */
    @Override
    public boolean hasNext(String numbers) {
        int intNumber = Integer.parseInt(numbers);
        return intNumber < 999 && intNumber >= 0;
    }
}
