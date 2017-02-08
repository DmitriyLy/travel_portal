package com.netcracker.entities;

/**
 * Entity represent's MAP_PROVIDERS table from TRAVEL_PORTAL database.
 *
 * @see com.netcracker.repositories.impl.MapProviderRepositoryImpl
 */
public class MapProvider extends AbstractEntity{
    private String coordSysName;

    public MapProvider() {
    }

    public MapProvider(long id, String name, String coordSysName) {
        this.setId(id);
        this.setName(name);
        this.coordSysName = coordSysName;
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

        long id = this.getId();
        String name = this.getName();
        MapProvider that = (MapProvider) o;

        if (id != that.getId()) return false;
        return name.equals(that.getName());
    }

    @Override
    public String toString() {
        return "MapProvider{" +
                "id=" + this.getId() +
                ", name='" + this.getName() + '\'' +
                '}';
    }
}
