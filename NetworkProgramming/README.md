# Network Programming (TCP Reverse Echo)

Small TCP client/server example that reverses each line sent from the client.

## How it works
- `Server` listens on port `2000`, accepts one client, reads a line, reverses it, and sends it back.
- `Client` connects to `localhost:2000`, reads a line from your keyboard, sends it, and prints the reply.
- The session ends when the client sends `end`. The server reverses it to `dne`, and both sides exit when they see `dne`.

## Key classes used (and why)
- `ServerSocket` (server side)
  - Binds to a port and waits for incoming TCP connections.
  - `accept()` blocks until a client connects, then returns a `Socket` for that client.
- `Socket` (client and server side)
  - Represents the TCP connection between client and server.
  - Provides input and output streams for reading and writing bytes.
- `InputStreamReader`
  - Bridges from byte streams (`InputStream`) to character streams (`Reader`).
  - Needed because sockets provide bytes, but we want to read text.
- `BufferedReader`
  - Wraps a `Reader` and allows efficient reading of text lines with `readLine()`.
  - This code uses a simple line-based protocol, so `readLine()` is convenient.
- `PrintStream`
  - Wraps the socket output stream and provides easy `println()` for sending text lines.
- `StringBuilder`
  - Used to reverse the received string efficiently before sending it back.

## Project structure
- `NetworkProgramming/src/networkprogramming/Server.java`
- `NetworkProgramming/src/networkprogramming/Client.java`

## Run (IntelliJ)
1. Run `Server` first.
2. Run `Client` in a second run configuration.
3. Type messages in the client console.
   - Example: `hello` -> server replies `olleh`.
   - Type `end` to stop both.

## Run (terminal)
From `NetworkProgramming/src`:

```bash
javac networkprogramming/Server.java networkprogramming/Client.java
```

Terminal 1 (server):

```bash
java networkprogramming.Server
```

Terminal 2 (client):

```bash
java networkprogramming.Client
```

## Notes
- This is a single-client, blocking server for learning purposes.
- The protocol is line-based, so each message must end with a newline.
