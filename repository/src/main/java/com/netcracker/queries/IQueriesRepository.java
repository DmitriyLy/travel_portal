package com.netcracker.queries;

/**
 * Created by Yuksi on 28.11.2016.
 */
public interface IQueriesRepository {
    String INSERT_COUNTRY = "INSERT INTO COUNTRIES(id,name) values(?,?)";
    String UPDATE_COUNTRY = "UPDATE COUNTRIES SET name=? WHERE id=?";
    String DELETE_COUNTRY = "DELETE FROM COUNTRIES WHERE id=?";
    String GET_COUNTRY_BY_ID = "SELECT * FROM COUNTRIES WHERE id=?";
}
