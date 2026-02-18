# NetworkProgramming3 (UDP)

Simple UDP client/server example using `DatagramSocket` and `DatagramPacket`.

## What it does
- `server.java` listens on UDP port 5000 and replies with the uppercased message.
- `client.java` sends messages typed in the console and prints the server reply.
- Typing `exit` tells the server to shut down.

## How to run
1. Start the server:
   ```bash
   java ExtraCurricularSmallProjects.NetworkProgramming3.server
   ```
2. In a second terminal, run the client:
   ```bash
   java ExtraCurricularSmallProjects.NetworkProgramming3.client
   ```

## Notes
- UDP is connectionless, so packets can be lost or arrive out of order.
- The client uses an ephemeral local port; the server replies to the sender's address/port from the received packet.
