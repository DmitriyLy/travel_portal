package com.netcracker.entities;

/**
 * Entity represent's CITIES table from TRAVEL_PORTAL database.
 *
 * @see com.netcracker.repositories.impl.CityRepositoryImpl
 */
public class City {
    private int id;
    private int stateId;
    private String name;

    public City() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
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

        if (id != city.id) return false;
        if (stateId != city.stateId) return false;
        return name != null ? name.equals(city.name) : city.name == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + stateId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
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
