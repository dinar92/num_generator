package com.inovus.carnum.service;

import com.inovus.carnum.format.CarNumberHandler;
import com.inovus.carnum.helper.CarLettersHelper;
import com.inovus.carnum.helper.CarNumbersHelper;
import com.inovus.carnum.helper.Helper;
import com.inovus.carnum.model.CarNumber;
import com.inovus.carnum.parser.CarNumberParser;
import com.inovus.carnum.repository.NumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.inovus.carnum.data.CarNumbersData.*;

/**
 * Generator of consecutive car numbers.
 * Uses the marker for defining the last generated number.
 */
@Service
public class ConsecutiveCarNumberGeneratorService implements GeneratorService {


    @Autowired
    NumberRepository numberRepository;

    /**
     * Returns a next by order new car number.
     *
     * @return - the car number, null - if all combinations of numbers are used.
     */
    @Override
    public CarNumber generate() {
        this.firstNumberInit();
        CarNumber existsCarNumber = this.numberRepository.findByLastTrue();
        String carNumber = this.getNextCarNumber(existsCarNumber.getCode());

        return carNumber == null ? null : new CarNumber(carNumber, true); }

    /**
     * Returns a next car number after specified.
     *
     * @param currentNumber - the current number.
     * @return - new number as a string, null - if all combinations of numbers are used.
     */
    private String getNextCarNumber(String currentNumber) {
        CarNumberParser parser = new CarNumberParser();
        String numbers = parser.getNumbers(currentNumber);
        Helper numbersHelper = new CarNumbersHelper();
        Helper lettersHelper = new CarLettersHelper(CHARACTER_SET);
        CarNumberHandler formatter = new CarNumberHandler();
        String newCode;

        do {
            if (numbersHelper.hasNext(numbers)) {
                newCode = formatter.updateNumbers(currentNumber, numbersHelper.getNext(numbers));
            } else {
                String chars = parser.getLetters(currentNumber);
                if (lettersHelper.hasNext(chars)) {
                    newCode = formatter.updateLetters(currentNumber, lettersHelper.getNext(chars));
                } else {
                    newCode = null;
                }
            }
        } while (newCode != null && this.isIssued(newCode));

        return newCode;
    }

    /**
     * Checks, that the new code already exists in the repository.
     *
     * @param newCode - new code.
     * @return - true - if issued, false - otherwise.
     */
    private boolean isIssued(String newCode) {
        return this.numberRepository.findByCode(newCode) != null;
    }

    /**
     * Inits first number in the repository.
     */
    private void firstNumberInit() {
        if (this.numberRepository.findByLastTrue() == null) {
            this.numberRepository.save(new CarNumber(FIRST_NUMBER, true));
        }
    }
}
