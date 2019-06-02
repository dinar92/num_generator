package com.inovus.carnum.format;

/**
 * A handler of car numbers.
 */
public class CarNumberHandler {

    /**
     * Changes letters of a car number to specified letters.
     * Excludes the region partition.
     *
     * @param carNumber  - a car number for formatting.
     * @param newLetters - new letters.
     * @return - a car number with updated letters.
     */
    public String updateLetters(String carNumber, String newLetters) {

        StringBuilder builder = new StringBuilder(carNumber);
        builder.setCharAt(0, newLetters.charAt(0));
        builder.setCharAt(4, newLetters.charAt(1));
        builder.setCharAt(5, newLetters.charAt(2));

        return builder.toString();
    }

    /**
     * Changes numbers of a car number to specified letters.
     * Excludes the region partition.
     *
     * @param carNumber  - a car number for formatting.
     * @param newNumbers - new numbers.
     * @return - a car number with updated numbers.
     */
    public String updateNumbers(String carNumber, String newNumbers) {

        StringBuilder builder = new StringBuilder(carNumber);
        builder.setCharAt(1, newNumbers.charAt(0));
        builder.setCharAt(2, newNumbers.charAt(1));
        builder.setCharAt(3, newNumbers.charAt(2));

        return builder.toString();
    }
}
