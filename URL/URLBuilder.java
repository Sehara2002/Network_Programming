import java.net.URL;
public class URLBuilder {
    public static void main(String[] args) {
        try {
            String protocol = "https";
            String host = "www.freedom.com";
            int port = 8090;
            String path = "/path/freedom.html";

            URL u1 = new URL(protocol,host,path);
            URL u2 = new URL(protocol,host,port,path);

            URL baseURL = new URL("https://www.freedom.com:8090");
            URL u3 = new URL(baseURL, path);
            
            System.out.println(u1);
            System.out.println(u2);
            System.out.println(u3);
        } catch (Exception e) {

        }
    }
}
