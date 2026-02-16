package ExtraCurricularSmallProjects.NetworkProgramming2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        final String HOST = "127.0.0.1";
        final int PORT = 12345;

        try (Socket socket = new Socket(HOST, PORT);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader console = new BufferedReader(new InputStreamReader(System.in))) {

            String line;
            while ((line = console.readLine()) != null) {
                out.println(line);
                if ("dne".equals(line)) {
                    break;
                }
                String response = in.readLine();
                if (response == null) {
                    break;
                }
                System.out.println("server: " + response);
            }
        }
    }
}
