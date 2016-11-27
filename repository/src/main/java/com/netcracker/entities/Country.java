package com.netcracker.entities;

/**
 * Created by Yuksi on 25.11.2016.
 */
public class Country {
    private int id;
    private String name;

    public Country(){}
    public  Country(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

        Country country = (Country) o;

        if (id != country.id) return false;
        return name != null ? name.equals(country.name) : country.name == null;
    }

    @Override
    public int hashCode() {
        int result = (int) id ^ (id >>> 32);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "{id = " + id + ", name = " + name + "}";
    }
}
