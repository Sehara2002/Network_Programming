
import java.net.URL;

public class URLBasics {

    public static void main(String[] args) {
        try {
            URL u1 = new URL("https://user:pass@www.freedom.com:8090/path/freedom.html?pages=2#Sec1");

            System.out.println("Protocol : " + u1.getProtocol());
            System.out.println("User Info : " + u1.getUserInfo());
            System.out.println("Host : " + u1.getHost());
            System.out.println("Port : " + u1.getPort());
            System.out.println("Path : " + u1.getPath());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
