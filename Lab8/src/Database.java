import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import dao.*;

public class Database {
    private static Connection connection;

    private static Connection getConnection(){
        if(connection == null) {
            createConnection();
        }
        return connection;
    }

    private static void createConnection() {
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost/musicalbums","root","root");
        } catch (SQLException e){
            System.err.println("System cannot connect");
        }
    }


    public Database() {
        connection = getConnection();
        ArtistController artistController = new ArtistController(connection);
//        artistController.create("Juan", "Spain");
        int artist_id = artistController.findByName("Juan");
        AlbumController albumController = new AlbumController(connection);
        albumController.create("Anatolya", 2, 1995);
        albumController.findByArtist(2);
    }


}
