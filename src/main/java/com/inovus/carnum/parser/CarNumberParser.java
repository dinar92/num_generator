package com.inovus.carnum.parser;

/**
 * A parser of the car number.
 */
public class CarNumberParser {

    /**
     * A single number regex.
     */
    private final static String NUMBER_PATTERN = "\\d";

    /**
     * A single not-number regex.
     */
    private final static String CHAR_PATTERN = "\\D";

    private final SimpleMatcher matcher = new SimpleMatcher();

    /**
     * Return first three numbers from the car number.
     *
     * @param code - car number.
     * @return - numbers.
     */
    public String getNumbers(String code) {
        return this.matcher.getMatches(NUMBER_PATTERN, code, 3);
    }

    /**
     * Return first three letters from the car number.
     *
     * @param code - car number.
     * @return - letters.
     */
    public String getLetters(String code) {
        return this.matcher.getMatches(CHAR_PATTERN, code, 3);
    }
}
