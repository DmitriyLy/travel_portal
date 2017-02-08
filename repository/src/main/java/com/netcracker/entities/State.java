package com.netcracker.entities;

/**
 * Entity represent's STATES table from TRAVEL_PORTAL database.
 *
 * @see com.netcracker.repositories.impl.StateRepositoryImpl
 */
public class State extends AbstractEntity {
    private long countryId;

    public State() {
    }

    public long getCountryId() {
        return countryId;
    }

    public void setCountryId(long countryId) {
        this.countryId = countryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        long id = this.getId();
        String name = this.getName();
        State state = (State) o;

        if (id != state.getId()) return false;
        if (countryId != state.countryId) return false;
        return name.equals(state.getName());
    }

    @Override
    public int hashCode() {
        long id = this.getId();
        String name = this.getName();
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) countryId;
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "State{" +
                "id=" + this.getId() +
                ", countryId=" + countryId +
                ", name='" + this.getName() + '\'' +
                '}';
    }
}
