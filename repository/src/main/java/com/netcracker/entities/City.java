package com.netcracker.entities;

/**
 * Entity represent's CITIES table from TRAVEL_PORTAL database.
 *
 * @see com.netcracker.repositories.impl.CityRepositoryImpl
 */
public class City extends AbstractEntity {
    private long stateId;

    public City() {
    }

    public City(long id, String name, long stateId) {
        this.setId(id);
        this.stateId = stateId;
        this.setName(name);
    }

    public long getStateId() {
        return stateId;
    }

    public void setStateId(long stateId) {
        this.stateId = stateId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        long id = this.getId();
        String name = this.getName();
        City city = (City) o;

        if (id != city.getId()) return false;
        return name.equals(city.getName());
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + this.getId() +
                ", stateId=" + stateId +
                ", name='" + this.getName() + '\'' +
                '}';
    }
}
