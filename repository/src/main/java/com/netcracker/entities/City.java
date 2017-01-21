package com.netcracker.entities;

/**
 * Entity represent's CITIES table from TRAVEL_PORTAL database.
 *
 * @see com.netcracker.repositories.impl.CityRepositoryImpl
 */
public class City {
    private long id;
    private long stateId;
    private String name;

    public City() {
    }

    public City(long id, String name, long stateId) {
        this.id = id;
        this.stateId = stateId;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getStateId() {
        return stateId;
    }

    public void setStateId(long stateId) {
        this.stateId = stateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        return id == city.id;
    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", stateId=" + stateId +
                ", name='" + name + '\'' +
                '}';
    }
}
