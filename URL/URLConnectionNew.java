
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;

public class URLConnectionNew {

    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.uom.lk");
            URLConnection con = url.openConnection();
            con.setConnectTimeout(5000);

            con.connect();

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

            String outputData = "{\"name\":\"John\", \"age\":30}";
            try {
                OutputStream writer = con.getOutputStream();

                byte[] input = outputData.getBytes("utf-8");
                writer.write(input, 0, input.length);

                writer.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }

            in.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch(SocketTimeoutException e){
            e.printStackTrace();
        } catch (ConnectException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
