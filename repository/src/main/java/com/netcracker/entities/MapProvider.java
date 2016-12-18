package com.netcracker.entities;

/**
 * Entity represent's MAP_PROVIDERS table from TRAVEL_PORTAL database.
 *
 * @see com.netcracker.repositories.impl.MapProviderRepositoryImpl
 */
public class MapProvider {
    private int id;
    private String name;
    private String coordSysName;

    public MapProvider() {
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

    public String getCoordSysName() {
        return coordSysName;
    }

    public void setCoordSysName(String coordSysName) {
        this.coordSysName = coordSysName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MapProvider that = (MapProvider) o;

        if (id != that.id) return false;
        return name != null ? name.equals(that.name) : that.name == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MapProvider{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
