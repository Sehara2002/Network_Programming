import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{
    public static void main(String[] args) {
        try {
            //Empty Server Socket
            ServerSocket serverSocket = new ServerSocket();
            System.out.println("Server Started at port 8080");

            //Binding a socket to Socket Address
            // serverSocket.bind(new InetSocketAddress("localhost",8080));

            //Client Connection Acceptance
            Socket client = serverSocket.accept();
            System.out.println("Client Connected: " + client.getInetAddress().getHostAddress());

            //Reading from the Client
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            String clientMessage = in.readLine();
            System.out.println("Message from Client: " + clientMessage);

            //Send data to the Client
            PrintWriter output = new PrintWriter(client.getOutputStream(), true);
            output.println("Hello from Server!");

            //Close the connections
            client.close();
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}