import config.Config;
import requests.RequestHandler;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) {
            ServerSocket serverSocket = null;
            Config config = new Config();
            try {
                serverSocket = new ServerSocket(Config.port);
                System.out.println("Connection Socket Created");
                try {
                    while (true) {
                        System.out.println("Waiting for Connection");
                        new Thread(new RequestHandler(serverSocket.accept())).start();
                    }
                } catch (IOException e) {
                    System.err.println("Accept failed.");
                    System.exit(1);
                }
            } catch (IOException e) {
                System.err.println("Could not listen on port: 10008.");
                System.exit(1);
            } finally {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    System.err.println("Could not close port: 10008.");
                    System.exit(1);
                }
            }
        }
}


