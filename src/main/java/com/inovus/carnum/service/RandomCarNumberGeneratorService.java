package com.inovus.carnum.service;

import com.inovus.carnum.model.CarNumber;
import com.inovus.carnum.repository.NumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.inovus.carnum.data.CarNumbersData.*;

/**
 * Generator of random car numbers.
 */
@Service
public class RandomCarNumberGeneratorService implements GeneratorService {

    @Autowired
    NumberRepository numberRepository;

    /**
     * Returns a next random new car number.
     *
     * @return - the car number, null - if all combinations of numbers are used.
     */
    @Override
    public CarNumber generate() {

        if (COMBINATIONS_NUMBER == this.numberRepository.count()) {
            return null;
        }

        String newRandomCode = this.getRandomCarNumber();
        CarNumber existCarNumber = this.numberRepository.findByCode(newRandomCode);

        while (existCarNumber != null) {
            newRandomCode = this.getRandomCarNumber();
            existCarNumber = this.numberRepository.findByCode(newRandomCode);
        }

        return new CarNumber(newRandomCode, false);
    }

    /**
     * Returns a random character of allowable characters.
     *
     * @return - the random character.
     */
    private String getRandomChar() {
        return String.valueOf(CHARS[(int) (CHARS.length * Math.random())]);
    }

    /**
     * Returns a random number between 0 - 9.
     *
     * @return - the random number.
     */
    private int getRandomNumber() {
        return (int) (Math.random() * 10);
    }

    /**
     * Returns a full car number as a text.
     *
     * @return - the car number.
     */
    private String getRandomCarNumber() {
        return String.format("%s%d%d%d%s%s %s",
                this.getRandomChar(),
                this.getRandomNumber(),
                this.getRandomNumber(),
                this.getRandomNumber(),
                this.getRandomChar(),
                this.getRandomChar(),
                REGION
        );
    }
}
