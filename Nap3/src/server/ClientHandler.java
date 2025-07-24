package server;

import java.io.*;
import java.net.Socket;

public class ClientHandler  extends Thread{
    private Socket socket;

    public ClientHandler(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run(){
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            while(true){
                System.out.println("received"+bufferedReader.readLine());
                bufferedWriter.write("ok\n");
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
