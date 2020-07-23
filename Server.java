import java.io.*;
import java.net.*;
import java.util.*;

public class Server {

    readConfigFile confFile = new readConfigFile("./config.properties");
    private int port = confFile.getPort();
    private String message = confFile.getMessage();
    ServerSocket serverSocket = null;
    Socket socket = null;

    public Server() {

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);

            while (true) {
                socket = serverSocket.accept();
                System.out.println("New client connected");

                new ServerThread(socket, message).start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {
        Server server = new Server();
    }
}