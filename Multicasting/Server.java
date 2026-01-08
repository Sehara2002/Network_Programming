
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

public class Server {

    public static final String MCAST_IP = "224.0.0.5";
    public static final int MCAST_PORT = 50001;

    public static void main(String[] args) {
        try {
            DatagramSocket ServerSocket = new DatagramSocket();

            byte[] buffer = new byte[1024];

            InetAddress Host = InetAddress.getByName(MCAST_IP);
            DatagramPacket p = new DatagramPacket(buffer, buffer.length,Host,MCAST_PORT);
            while (true) {
                p.setData(new Date().toString().getBytes());
                ServerSocket.send(p);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
