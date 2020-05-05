import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {

    public static final int PORT = 8100;

    public GameServer() throws IOException{
        ServerSocket serverSocket = null;
        try{
            serverSocket=new ServerSocket(PORT);
            while(true){
                System.out.println("Waiting for a client");
                serverSocket.setSoTimeout(10000);
                Socket socket = serverSocket.accept();

                new ClientThread(socket).start();
                if(ClientThread.returnStop().equals("stop")) {
                    serverSocket.close();
                    break;
                }
            }
        }catch (IOException e){
            System.err.println(e);
        }finally {
            serverSocket.close();
        }
    }

    public static void main(String[] args) throws IOException {
        GameServer gameServer = new GameServer();
    }
}
