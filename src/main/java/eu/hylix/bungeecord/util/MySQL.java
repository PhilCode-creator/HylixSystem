package eu.hylix.bungeecord.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL {

    private Connection connection;

    public void connect() {

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void disconnect() {

    }

}
