package com.netcracker.specifications;

/**
 * Created by Yuksi on 25.11.2016.
 *
 * interface generates desirable String query
 */
public interface SqlSpecification extends Specification {
    String toSqlQuery();
}
