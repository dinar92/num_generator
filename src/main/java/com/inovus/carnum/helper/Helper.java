package com.inovus.carnum.helper;

/**
 * Helper for working with car numbers.
 * Doesn't iterate symbols.
 * Work requires - the availability of the first number.
 */
public interface Helper {

    /**
     * Returns the next sequence of symbols.
     *
     * @param symbols - current symbols.
     * @return - next symbols.
     */
    String getNext(String symbols);

    /**
     * Checks existing of the next sequence of symbols.
     *
     * @param symbols - current symbols.
     * @return - true - if has, false - otherwise.
     */
    boolean hasNext(String symbols);
}
