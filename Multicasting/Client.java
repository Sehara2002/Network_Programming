
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Client {

    public static final String MCAST_IP = "224.0.0.5";
    public static final int MCAST_PORT = 50001;

    public static void main(String[] args) {
        try {
            MulticastSocket client = new MulticastSocket(MCAST_PORT);
            InetAddress Host = InetAddress.getByName(MCAST_IP);

            client.joinGroup(Host);

            byte[] buffer = new byte[1024];
            DatagramPacket p = new DatagramPacket(buffer, buffer.length, Host,MCAST_PORT);
            client.receive(p);

            String data = new String(p.getData());
            System.out.println("Received: "+data);

            client.leaveGroup(Host);
            client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
