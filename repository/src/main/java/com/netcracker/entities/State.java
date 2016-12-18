package com.netcracker.entities;

/**
 * Entity represent's STATES table from TRAVEL_PORTAL database.
 *
 * @see com.netcracker.repositories.impl.StateRepositoryImpl
 */
public class State {
    private int id;
    private int countryId;
    private String name;

    public State() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
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

        State state = (State) o;

        if (id != state.id) return false;
        if (countryId != state.countryId) return false;
        return name != null ? name.equals(state.name) : state.name == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + countryId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "State{" +
                "id=" + id +
                ", countryId=" + countryId +
                ", name='" + name + '\'' +
                '}';
    }
}
