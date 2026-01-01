import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPConnection {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.uom.lk");
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setConnectTimeout(5000);
            con.connect();

            int responseCode = con.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            if(responseCode == HttpURLConnection.HTTP_OK){
                System.out.println("Connection successful.");

                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String line;
                while((line = in.readLine())!=null ){
                    System.out.println(line);
                }
            }
            
            con.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
