package networkprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        int port = 2000;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server listening on port " + port);

            try (Socket socket = serverSocket.accept();
                 BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintStream ps = new PrintStream(socket.getOutputStream())) {

                String msg = "";
                do {
                    String input = br.readLine();
                    if (input == null) {
                        break;
                    }

                    msg = new StringBuilder(input).reverse().toString();
                    ps.println(msg);
                } while (!"dne".equals(msg));
            }
        }
    }
}
