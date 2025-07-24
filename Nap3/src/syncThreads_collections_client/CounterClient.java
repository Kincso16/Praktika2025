package syncThreads_collections_client;

import java.io.*;
import java.net.Socket;

public class CounterClient {
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;

    public CounterClient(){
        try {
            socket=new Socket("localhost",15000);
            bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            bufferedWriter=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendMessage(String message) {
        try {
            bufferedWriter.write(message+"\n");
            bufferedWriter.flush();
            System.out.println(bufferedReader.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
