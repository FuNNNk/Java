import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class GameClient {

    public static void main(String[] args) {
        String serverAddress = "127.0.0.1"; // The server's IP address
        int PORT = 8100; // The server's port
        try (
                Socket socket = new Socket(serverAddress, PORT);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader ( new InputStreamReader(socket.getInputStream()))
        )
        {
            while(true) {
                Scanner scanner = new Scanner(System.in);
                String request = scanner.nextLine();
                out.println(request);// Wait the response from the server ("Hello World!")
                if (request.equals("exit"))
                    System.exit(0);

                String response = in.readLine();
                System.out.println(response);
                if (request.equals("stop"))
                    System.exit(0);
            }
        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
