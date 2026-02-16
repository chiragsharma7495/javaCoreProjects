package networkprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        String host = "localhost";
        int port = 2000;

        try (Socket socket = new Socket(host, port);
             BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintStream ps = new PrintStream(socket.getOutputStream())) {

            String msg;
            do {
                msg = key.readLine();
                if (msg == null) {
                    break;
                }

                ps.println(msg);
                String reply = br.readLine();
                if (reply == null) {
                    break;
                }

                System.out.println("from server " + reply);
                msg = reply;
            } while (!"dne".equals(msg));
        }
    }
}
