import java.net.URI;
import java.net.URL;
public class URLtoURI {

    public static void main(String[] args) {
        try {
            URL u1 = new URL("https://www.domain.lk/path/1.html");
            URI uri = u1.toURI();

            URI u2 = new URI("https","www.domain2.lk","/path/2.html");
            URL url = u2.toURL();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
