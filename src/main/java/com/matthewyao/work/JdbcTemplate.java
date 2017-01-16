package com.matthewyao.work;

import java.sql.*;

/**
 * Created by matthewyao on 2016/11/25.
 */
public class JdbcTemplate {
    // Declare the JDBC objects.
    private static Connection connection = null;
    private static Statement statement = null;

    static {
//        String connectionString = "jdbc:sqlserver://10.200.11.237:1433;DatabaseName=crm;user=crmUser;password=crm111111;";
        String connectionString = "jdbc:sqlserver://sh-oa2:1433;DatabaseName=crm;user=crmUser;password=crm111111;";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            connection = DriverManager.getConnection(connectionString);
            // Create and execute a SELECT SQL statement.
            statement = connection.createStatement();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Connect to your database.
    // Replace server name, username, and password with your credentials
    public static ResultSet queryForRowSet(String sql) throws SQLException {
        return statement.executeQuery(sql);
    }
}
