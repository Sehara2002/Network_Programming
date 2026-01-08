
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class SSLClient {
    public static void main(String[] args) {
        try {
            SSLSocketFactory factory = (SSLSocketFactory)SSLSocketFactory.getDefault();

            SSLSocket socket = (SSLSocket)factory.createSocket("localhost",10300);

            socket.connect(new InetSocketAddress("localhost",10200));
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String s = br.readLine();

            System.out.println("From Server: "+s);

            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
