package com.inovus.carnum.helper;

import java.util.TreeSet;

/**
 * The helper for working with letters.
 * Excludes the region partition.
 * Handles only three letter sequences.
 */
public class CarLettersHelper implements Helper {

    /**
     * The sorted sequence of available characters of the car number.
     */
    private final TreeSet<Character> characters;

    public CarLettersHelper(TreeSet<Character> characters) {
        this.characters = characters;
    }

    /**
     * Returns the next sequence of letters.
     * Changes begin from the last letter.
     *
     * @param symbols - current symbols.
     * @return - next letters.
     */
    @Override
    public String getNext(String symbols) {
        Character last = this.characters.last();
        Character firstChar = symbols.charAt(0);
        Character secondChar = symbols.charAt(1);
        Character thirdChar = symbols.charAt(2);

        if (last.equals(thirdChar)) {
            if (last.equals(secondChar)) {
                if (last.equals(firstChar)) {
                    return null;
                } else {
                    firstChar = this.characters.higher(firstChar);
                }
                secondChar = this.characters.first();
            } else {
                secondChar = this.characters.higher(secondChar);
            }
            thirdChar = this.characters.first();
        }
        return String.format("%s%s%s", firstChar, secondChar, thirdChar);
    }

    /**
     * Checks existing of the next combination of letters.
     *
     * @param symbols - current symbols.
     * @return true - if has, false - otherwise.
     */
    @Override
    public boolean hasNext(String symbols) {
        char higherChar = characters.last().charValue();

        return symbols.chars().filter(ch -> ch == higherChar).count() != symbols.length();
    }
}
