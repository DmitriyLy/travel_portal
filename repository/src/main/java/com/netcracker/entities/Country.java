package com.netcracker.entities;

/**
 * Entity represent's COUNTRIES table from TRAVEL_PORTAL database.
 *
 * @see com.netcracker.repositories.impl.CountryRepositoryImpl
 */
public class Country extends AbstractEntity {

    public Country() {
    }

    public Country(long id, String name) {
        this.setId(id);
        this.setName(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        long id = this.getId();
        String name = this.getName();
        Country country = (Country) o;

        if (id != country.getId()) return false;
        return name.equals(country.getName());
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + this.getId() +
                ", name='" + this.getName() + '\'' +
                '}';
    }
}
