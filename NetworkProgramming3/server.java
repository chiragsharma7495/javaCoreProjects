package ExtraCurricularSmallProjects.NetworkProgramming3;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.charset.StandardCharsets;

public class server {
    // Simple UDP echo server. Listens on PORT and replies with uppercased text.
    private static final int PORT = 5000;
    private static final int MAX_PACKET_SIZE = 1024;

    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(PORT)) {
            byte[] buffer = new byte[MAX_PACKET_SIZE];
            System.out.println("UDP server listening on port " + PORT);

            while (true) {
                DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                socket.receive(request);

                String message = new String(
                        request.getData(),
                        request.getOffset(),
                        request.getLength(),
                        StandardCharsets.UTF_8
                );

                if ("exit".equalsIgnoreCase(message.trim())) {
                    String reply = "Server shutting down.";
                    byte[] out = reply.getBytes(StandardCharsets.UTF_8);
                    DatagramPacket response = new DatagramPacket(
                            out,
                            out.length,
                            request.getAddress(),
                            request.getPort()
                    );
                    socket.send(response);
                    break;
                }

                String reply = message.toUpperCase();
                byte[] out = reply.getBytes(StandardCharsets.UTF_8);
                DatagramPacket response = new DatagramPacket(
                        out,
                        out.length,
                        request.getAddress(),
                        request.getPort()
                );
                socket.send(response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
