package server;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class KeyValueStoreServer {
    public static void main(String[] args) {
        int port = 12345;
        Map<String, String> store = Collections.synchronizedMap(new HashMap<>());

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Key-Value Store Server started on port " + port);
            
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket);
                new Thread(new ClientHandler(clientSocket, store)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
