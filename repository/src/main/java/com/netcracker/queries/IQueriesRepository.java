package com.netcracker.queries;

/**
 * Created by Yuksi on 28.11.2016.
 */
public interface IQueriesRepository {
    String INSERTCOUNTRY = "INSERT INTO COUNTRIES(id,name) values(?,?)";
    String UPDATECOUNTRY = "UPDATE COUNTRIES SET name=? WHERE id=?";
    String DELETECOUNTRY = "DELETE FROM COUNTRIES WHERE id=?";
}
