package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ArtistController{
    public Connection connection;
    public String dbName = "artist";

    public ArtistController(Connection connection) {
        this.connection = connection;
    }

    public void create(String name, String country){
        Statement stmt = null;
        try{
            stmt = connection.createStatement();
            stmt.executeUpdate("insert into artist(name, country) values(" +  "'" + name + "'" + ',' + "'" + country + "'" + ");");
        }catch (SQLException e){
            System.out.println("Eroare");
        }
    }

    public int findByName(String name){
        try {
            Statement statement = connection.createStatement();
            String sql = "select * from " + dbName + " where name = '" + name + "' ;";
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                int id  = resultSet.getInt("id");
                String nume = resultSet.getString("name");
                String country = resultSet.getString("country");
                System.out.println(id +" " + nume + " "+ country);

                return id;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
