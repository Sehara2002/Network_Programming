import java.net.URI;

public class URIBasics {
    public static void main(String[] args) {
        try {
            URI u1 = new URI("https://www.freedom.com:8090/path/freedom.html?pages=2#Sec1");

            URI u2 = new URI("https", "user:pass", "www.freedom.com", 8090, "/path/freedom.html", "pages=2", "Sec1");
            System.out.println("URI 1: " + u1);
            System.out.println("URI 2: " + u2);

            System.out.println("Scheme : " + u1.getScheme());
            System.out.println("Host : " + u1.getHost());
            System.out.println("Port : " + u1.getPort());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
