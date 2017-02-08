package com.netcracker.entities;

/**
 * Entity represent's CATEGORIES table from TRAVEL_PORTAL database.
 *
 * @see com.netcracker.repositories.impl.CategoryRepositoryImpl
 */
public class Category extends AbstractEntity{

    public Category() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        long id = this.getId();
        String name =  this.getName();
        Category category = (Category) o;

        if (id != category.getId()) return false;
        return name != null ? name.equals(category.getName()) : category.getName() == null;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + this.getId() +
                ", name='" + this.getName() + '\'' +
                '}';
    }
}
