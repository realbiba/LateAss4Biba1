package data;


import data.interfaces.IDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresDB implements IDB {
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String Url = "jdbc:postgresql://localhost:5432/Postgres";
        try {
            Class.forName("org.postgresql.Driver");

            Connection con = DriverManager.getConnection(Url, "postgres", "9803");

            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}