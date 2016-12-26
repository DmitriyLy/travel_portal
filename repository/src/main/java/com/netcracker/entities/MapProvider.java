package com.netcracker.entities;

/**
 * Entity represent's MAP_PROVIDERS table from TRAVEL_PORTAL database.
 *
 * @see com.netcracker.repositories.impl.MapProviderRepositoryImpl
 */
public class MapProvider {
    private long id;
    private String name;
    private String coordSysName;

    public MapProvider() {
    }

    public MapProvider(long id, String name, String coordSysName) {
        this.id = id;
        this.name = name;
        this.coordSysName = coordSysName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
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
