package com.inovus.carnum.service;

import com.inovus.carnum.model.CarNumber;

/**
 * Generator of car numbers.
 */
public interface GeneratorService {

    /***
     * Generates the car number.
     * @return - the car number.
     */
    CarNumber generate();
}
