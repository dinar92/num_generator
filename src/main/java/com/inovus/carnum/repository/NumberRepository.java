package com.inovus.carnum.repository;

import com.inovus.carnum.model.CarNumber;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * The repository of car numbers.
 * Stores already generated numbers.
 */
@Repository
public interface NumberRepository extends CrudRepository<CarNumber, Long> {

    /**
     * Returns a car number instance by code.
     *
     * @param code - code.
     * @return - an instance of CarNumber, null - otherwise.
     */
    CarNumber findByCode(String code);

    /**
     * Returns a car number by a marked last item.
     *
     * @return - a last car number.
     */
    CarNumber findByLastTrue();

    /**
     * Count of all numbers.
     *
     * @return - count.
     */
    long count();

}
