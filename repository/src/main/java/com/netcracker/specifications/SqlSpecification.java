package com.netcracker.specifications;

/**
 * Created by Yuksi on 25.11.2016.
 */
public interface SqlSpecification extends Specification {
    String toSqlQuery();
}
