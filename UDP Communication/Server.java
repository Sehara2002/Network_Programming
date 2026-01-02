import java.io.IOException;
import java.net.*;
public class Server{
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(8080);
            System.out.println("Server is listening on port 8080...");

            byte[] r_buffer = new byte[1024];
            DatagramPacket r_packet = new DatagramPacket(r_buffer, r_buffer.length);
            socket.receive(r_packet);
            String message = new String(r_packet.getData(),0, r_packet.getLength());
            System.out.println("Received from client: " + message);

            String response = "Hello from server";
            byte[] s_buffer = response.getBytes();
            DatagramPacket s_packet = new DatagramPacket(s_buffer, s_buffer.length, r_packet.getAddress(), r_packet.getPort());
            socket.send(s_packet);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}