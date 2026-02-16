package ExtraCurricularSmallProjects.NetworkProgramming2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

public class code extends Thread{
    private static final AtomicInteger ACTIVE_CLIENTS = new AtomicInteger(0);
    Socket skt;

    public code(Socket skt) {
        this.skt = skt;
    }

    public void run(){
        try (Socket socket = skt;
             BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            String msg;
            while ((msg = br.readLine()) != null) {
                if ("dne".equals(msg)) {
                    break;
                }
                String reversed = new StringBuilder(msg).reverse().toString();
                out.println(reversed);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            int active = ACTIVE_CLIENTS.decrementAndGet();
            System.out.println("Client disconnected. Active clients: " + active);
        }
    }
    public static void main(String[] args) throws Exception {
        final int PORT = 12345;
        try (ServerSocket ss = new ServerSocket(PORT)) {
            while (true) {
                Socket client = ss.accept();
                code c = new code(client);
                int active = ACTIVE_CLIENTS.incrementAndGet();
                System.out.println("Client connected. Active clients: " + active);
                c.start();
            }
        }
    }
}



