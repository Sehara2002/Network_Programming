
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TCPServer {

    public static int COUNT = 0;

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(8080);

            ExecutorService executor = Executors.newFixedThreadPool(10);

            // Handling Server Request Using Threads
            while (true) {
                Socket client = server.accept();
                System.out.println("Client Connected.....");

                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        requestHandler(client);
                    }
                });
                executor.submit(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void requestHandler(Socket socket) {
        BufferedReader br = null;

        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            PrintWriter pr = new PrintWriter(socket.getOutputStream(), true);

            String number = br.readLine();
            int clientNumber = Integer.parseInt(number);
            synchronized (TCPServer.class) {
                COUNT += clientNumber;
            }

            String Message = "Hi Client Updated Count is " + COUNT;
            pr.write(Message);

            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
