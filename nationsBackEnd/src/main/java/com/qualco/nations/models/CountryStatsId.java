package com.qualco.nations.models;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CountryStatsId implements Serializable {
    private static final long serialVersionUID = -2599818497275858098L;
    @Column(name = "country_id", nullable = false)
    private Integer countryId;
    @Column(name = "year", nullable = false)
    private Integer year;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, countryId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CountryStatsId entity = (CountryStatsId) o;
        return Objects.equals(this.year, entity.year) &&
                Objects.equals(this.countryId, entity.countryId);
    }
}