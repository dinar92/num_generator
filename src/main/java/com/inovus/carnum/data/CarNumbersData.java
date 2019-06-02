package com.inovus.carnum.data;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * An information about car numbers.
 */
public class CarNumbersData {

    /**
     * Possible characters of the car number into the code partition.
     */
    public static final Character[] CHARS = {'А', 'Е', 'Т', 'О', 'Р', 'Н', 'У', 'К', 'Х', 'С', 'В', 'М'};

    /**
     * The first car number of the sequence.
     */
    public static final String FIRST_NUMBER = "А000АА 116 RUS";

    /**
     * The sorted collection of possible numbers.
     */
    public static final TreeSet<Character> CHARACTER_SET = new TreeSet<>(Arrays.asList(CHARS));

    /**
     * The max count of combinations of the car number symbols.
     * Excludes the region partition.
     */
    public static final int COMBINATIONS_NUMBER = 1728000;

    /**
     * The region partition of the car number.
     */
    public static final String REGION = "116 RUS";
}
