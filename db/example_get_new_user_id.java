import java.sql.*;

/**
 * Created by dima_2 on 26.12.2016.
 */
public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("oracle.jdbc.driver.OracleDriver");

        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","TRAVEL_PORTAL","TRAVEL_PORTAL");

        CallableStatement stmt = connection.prepareCall("{? = call get_new_user_id()}");
        stmt.registerOutParameter(1, Types.INTEGER);
        stmt.execute();
        int output = stmt.getInt(1);

        System.out.println(output);

    }

}