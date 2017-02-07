package com.netcracker.entities;

/**
 * Entity represent's TAGS table from TRAVEL_PORTAL database.
 *
 * @see com.netcracker.repositories.impl.TagRepositoryImpl
 */
public class Tag extends AbstractEntity {

    public Tag() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tag)) return false;

        long id = this.getId();
        String name = this.getName();
        Tag tag = (Tag) o;

        if (id != tag.getId()) return false;
        return name != null ? name.equals(tag.getName()) : tag.getName() == null;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + this.getId() +
                ", name='" + this.getName() + '\'' +
                '}';
    }
}
