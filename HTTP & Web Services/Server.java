
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Server {

    public static void main(String[] args) {
        try {
            // URL url = new URL("https://jsonplaceholder.typicode.com/posts/1");
            // HttpURLConnection con = (HttpURLConnection)url.openConnection();
            // con.setRequestMethod("GET");
            // int StatusCode = con.getResponseCode();
            // String message = con.getResponseMessage();

            // System.out.println("Response Message: "+message);
            // System.out.println("Response Code: "+StatusCode);
            // BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            // while (true) { 
            //     String line = br.readLine();
            //     if(line==null){
            //         break;
            //     }
            //     System.out.println(line);
            // }
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://jsonplaceholder.typicode.com/posts/101")).GET().header("Accept", "application/json").build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                String json = """
                    {
                      "title": "Hello Java",
                      "body": "This is a POST request",
                      "userId": 1
                    }
                    """;
                // HttpRequest post_req = HttpRequest.newBuilder().uri(URI.create("https://jsonplaceholder.typicode.com/posts")).POST(HttpRequest.BodyPublishers.ofString(json)).build();

                // HttpResponse<String> response2 = client.send(post_req,HttpResponse.BodyHandlers.ofString());

                // System.out.println(response2.body());

                System.out.println(response.body());
            } catch (Exception e) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
