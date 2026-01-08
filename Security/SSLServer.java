
import java.io.*;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class SSLServer {

    public static void main(String[] args) {
        SSLServerSocketFactory factory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        try {
            SSLServerSocket socket = (SSLServerSocket) factory.createServerSocket(10200);
            System.out.println("SSL Server Created");

            SSLSocket client = (SSLSocket)socket.accept();
            PrintWriter pr = new PrintWriter(client.getOutputStream(), true);

            pr.println("Hello Client: "+client.getInetAddress().getHostName());

            client.close();
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
