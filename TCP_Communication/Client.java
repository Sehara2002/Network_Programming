import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
public class Client {
    public static void main(String[] args) {
        try {
            // Creating socket to connect to the Server
            Socket socket = new Socket("localhost", 8080);

            // Sending data to the Server
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("Hello from Client!");

            //Reading dats from the Server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String serverMessage = in.readLine();
            System.out.println("Message from Server: " + serverMessage);

            //Close the connections
            socket.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
