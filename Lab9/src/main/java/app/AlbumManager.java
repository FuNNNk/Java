package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AlbumManager {
    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/musicalbums","root","root");

    public AlbumManager() throws SQLException {
    }
}
