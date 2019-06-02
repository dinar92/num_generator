package com.inovus.carnum.controller;

import com.inovus.carnum.model.CarNumber;
import com.inovus.carnum.repository.NumberRepository;
import com.inovus.carnum.service.ConsecutiveCarNumberGeneratorService;
import com.inovus.carnum.service.RandomCarNumberGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;

@RestController
public class NumberController {

    @Autowired
    NumberRepository numberRepository;

    @Autowired
    RandomCarNumberGeneratorService randomCarNumberGeneratorService;

    @Autowired
    ConsecutiveCarNumberGeneratorService consecutiveCarNumberGeneratorService;

    /**
     * Returns a random car numbers.
     *
     * @return - response entity with text and status of response. Contains NO CONTENT status if possible
     * numbers run out.
     */
    @GetMapping("/number/random")
    public ResponseEntity generateRandomNumber() {

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(new MediaType(org.springframework.http.MediaType.TEXT_PLAIN, StandardCharsets.UTF_8));
        CarNumber carNumber = this.randomCarNumberGeneratorService.generate();

        if (carNumber == null) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        this.numberRepository.save(carNumber);

        return new ResponseEntity(carNumber.getCode(), httpHeaders, HttpStatus.OK);
    }

    /**
     * Returns a consecutive car numbers.
     *
     * @return - response entity with text and status of response. Contains NO CONTENT status if possible
     * numbers run out.
     */
    @GetMapping("/number/next")
    public ResponseEntity generateNextNumber() {
        CarNumber carNumber = this.consecutiveCarNumberGeneratorService.generate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(new MediaType(org.springframework.http.MediaType.TEXT_PLAIN, StandardCharsets.UTF_8));

        if (carNumber == null) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        CarNumber existsCarNumber = this.numberRepository.findByLastTrue();
        existsCarNumber.setLast(false);
        this.numberRepository.save(existsCarNumber);
        this.numberRepository.save(carNumber);

        return new ResponseEntity(carNumber.getCode(), httpHeaders, HttpStatus.OK);
    }
}
