package server;
import java.io.*;
import java.net.Socket;
import java.util.Map;

public class ClientHandler implements Runnable {
    private final Socket socket;
    private final Map<String, String> store;

    public ClientHandler(Socket socket, Map<String, String> store) {
        this.socket = socket;
        this.store = store;
    }
    @Override
    public void run() {
        try (
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        ) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                String[] parts = inputLine.trim().split(" ", 3);
                String command = parts[0].toUpperCase();

                switch (command) {
                    case "SET":
                        if (parts.length == 3) {
                            synchronized (store) {
                                store.put(parts[1], parts[2]);
                            }
                            out.println("OK");
                        } else {
                            out.println("ERROR: SET requires key and value");
                        }
                        break;
                    case "GET":
                        if (parts.length == 2) {
                            String value;
                            synchronized (store) {
                                value = store.get(parts[1]);
                            }
                            out.println(value != null ? value : "NULL");
                        } else {
                            out.println("ERROR: GET requires key");
                        }
                        break;
                    case "DELETE":
                        if (parts.length == 2) {
                            synchronized (store) {
                                store.remove(parts[1]);
                            }
                            out.println("Deleted");
                        } else {
                            out.println("ERROR: DELETE requires key");
                        }
                        break;
                    case "KEYS":
                        synchronized (store) {
                            String keys = String.join(",", store.keySet());
                            out.println(keys);
                        }
                        break;
                    default:
                        out.println("ERROR: Invalid command format");
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
