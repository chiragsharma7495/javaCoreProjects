# NetworkProgramming2

Simple TCP client/server example. The server reverses each line the client sends.

## What it does
- `code` (server) listens on `127.0.0.1:12345`
- `Client` connects to the server, sends lines you type
- For each line, the server replies with the reversed string
- Type `dne` to close the connection

## Prerequisites
- JDK 8+ installed (`javac` and `java` on PATH)

## How to run
From the repo root:

1. Compile
```bash
javac -d out NetworkProgramming2/code.java NetworkProgramming2/Client.java
```

2. Start the server (terminal 1)
```bash
java -cp out ExtraCurricularSmallProjects.NetworkProgramming2.code
```

3. Start the client (terminal 2)
```bash
java -cp out ExtraCurricularSmallProjects.NetworkProgramming2.Client
```

4. Type messages in the client terminal
- Example input: `hello`
- Example response: `server: olleh`
- To exit, type: `dne`

## Notes
- Each client is handled on its own thread.
- The server prints active client count when clients connect or disconnect.
- If you change the port, update it in both `code` and `Client`.
