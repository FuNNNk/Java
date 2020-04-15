package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AlbumController {
    public Connection connection;
    public String dbName = "albums";

    public AlbumController(Connection connection) {
        this.connection = connection;
    }

    public void create(String name, int artist_id, int releaseYear){
        Statement stmt = null;
        try{
            stmt = connection.createStatement();
            stmt.executeUpdate("insert into " + dbName + " values(" + name + ',' + artist_id + ',' + releaseYear + ");");
        }catch (SQLException e){
            System.out.println("Eroare");
        }

    }

    public void findByArtist(int artistId){
        try {
            Statement statement = connection.createStatement();
            String sql = "select * from " + dbName + " where artist_id is " + artistId + ";";
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                int id = resultSet.getInt("artist_id");
                System.out.println(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
