package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(15000);
            while(true){
                new ClientHandler(server.accept()).start();
            }
        } catch (IOException e) {
            
        }
    }
}
