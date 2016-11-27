package com.netcracker.entities;

/**
 * Simple JavaBeans domain object with only one String field.
 *
 * @author Oveian Egor
 */

public class BasicEntity {

    private String basicField;

    public BasicEntity() {
    }

    public String getBasicField() {
        return basicField;
    }

    public void setBasicField(String basicField) {
        this.basicField = basicField;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BasicEntity that = (BasicEntity) o;

        return basicField != null ? basicField.equals(that.basicField) : that.basicField == null;
    }

    @Override
    public int hashCode() {
        return basicField != null ? basicField.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "BasicEntity{" +
                "basicField='" + basicField + '\'' +
                '}';
    }
}
