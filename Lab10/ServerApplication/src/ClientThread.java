import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket socket = null;
    private static String string = "null";
    public ClientThread(Socket socket){
        this.socket = socket;
    }

    public void run(){
        try{
            while(true) {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String request = in.readLine();
                System.out.println(request);
                if(request.equals("exit")){
                    socket.close();
                    break;
                }
                if(request.equals("stop")){
                    string = "stop";
                    PrintWriter out = new PrintWriter(socket.getOutputStream());
                    String raspuns = "Server stopped";
                    out.println(raspuns);
                    out.flush();
                    socket.close();
                    break;
                }
                PrintWriter out = new PrintWriter(socket.getOutputStream());
                String raspuns = "Server received your request...";
                out.println(raspuns);
                out.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String returnStop(){
        return string;
    }
}
