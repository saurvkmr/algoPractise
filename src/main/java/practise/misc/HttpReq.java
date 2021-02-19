package practise.misc;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpReq {
    public static void main(String[] args) {

    }

    private static void makeHttpReq() throws IOException {
        URL url = new URL("http://www.google.com");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
    }
}
