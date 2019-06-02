package com.inovus.carnum.model;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * A persistence entity of a representation of a car number.
 */
@Entity
@Table(name = "car_numbers", catalog = "numbers")
public class CarNumber implements Serializable {

    @Id
    @GeneratedValue(strategy=IDENTITY)
    private Long id;

    /**
     * A full car number as text.
     */
    @Column(name="code", nullable=false)
    private String code;

    /**
     * A marker of a last generated number among sequentially generated numbers.
     */
    @Column(name="is_last", nullable = false, columnDefinition = "boolean default false")
    private boolean last;

    public CarNumber() {
    }

    public CarNumber(String code, boolean last) {
        this.code = code;
        this.last = last;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarNumber)) return false;

        CarNumber carNumber = (CarNumber) o;

        return code != null ? code.equals(carNumber.code) : carNumber.code == null;
    }

    @Override
    public int hashCode() {
        return code != null ? code.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "CarNumber{" +
                "code='" + code + '\'' +
                ", last=" + last +
                '}';
    }
}
