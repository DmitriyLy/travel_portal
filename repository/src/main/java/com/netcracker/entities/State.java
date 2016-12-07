package com.netcracker.entities;

/**
 * Created by logariett on 28.11.2016.
 */
public class State {
    private int id;
    private int countryId;
    private String name;

    public State() {
    }

    public State(int id, int countryId, String name) {
        this.id = id;
        this.countryId = countryId;
        this.name = name;
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
