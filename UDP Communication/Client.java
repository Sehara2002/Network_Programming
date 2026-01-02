
import java.io.IOException;
import java.net.*;

public class Client {

    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();

            String message = "Hello from client";
            byte[] s_buffer = message.getBytes();
            DatagramPacket s_packet = new DatagramPacket(s_buffer, s_buffer.length, InetAddress.getByName("localhost"), 8080);
            socket.send(s_packet);

            byte[] r_buffer = new byte[1024];
            DatagramPacket r_packet = new DatagramPacket(r_buffer, r_buffer.length);
            socket.receive(r_packet);
            String response = new String(r_packet.getData(), 0, r_packet.getLength());
            System.out.println("Received from server: " + response);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
