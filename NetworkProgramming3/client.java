package ExtraCurricularSmallProjects.NetworkProgramming3;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class client {
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 5000;
    private static final int MAX_PACKET_SIZE = 1024;

    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket();
             Scanner scanner = new Scanner(System.in)) {
            InetAddress serverAddress = InetAddress.getByName(HOST);
            byte[] buffer = new byte[MAX_PACKET_SIZE];

            System.out.println("Type messages to send. Type 'exit' to stop.");
            while (true) {
                String line = scanner.nextLine();
                byte[] out = line.getBytes(StandardCharsets.UTF_8);
                DatagramPacket request = new DatagramPacket(out, out.length, serverAddress, PORT);
                socket.send(request);

                DatagramPacket response = new DatagramPacket(buffer, buffer.length);
                socket.receive(response);
                String reply = new String(
                        response.getData(),
                        response.getOffset(),
                        response.getLength(),
                        StandardCharsets.UTF_8
                );
                System.out.println("Server: " + reply);

                if ("exit".equalsIgnoreCase(line.trim())) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
