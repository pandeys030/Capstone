// Client.java
import java.io.*;
import java.net.*;

public class Client_702 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 3500); // connect to server

            PrintWriter out = new PrintWriter(
                    socket.getOutputStream(), true
            );
            out.println("I want to order pizza"); // send message
            System.out.println(" Order sent to restaurant!");

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
