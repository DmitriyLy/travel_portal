package com.netcracker.specifications;

/**
 * Interface generates desirable String query.
 *
 * @author Yuksi
 */
public interface SqlSpecification extends Specification {
    String toSqlQuery();
}
