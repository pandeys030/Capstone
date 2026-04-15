//q2) Moderate : online food ordering system
//Problem: A customer sends food order to restaurant.
//Solution: Create
//            --> A server that waits for a client message.
//            --> A client that sends: "I want to order pizza"
import java.io.*;
import java.net.*;

public class Server_SIT_702 {
    public static void main(String[] args) {
        try {
            ServerSocket servSocket = new ServerSocket(3500);
            System.out.println("Restaurant server started... Waiting for orders...");

            Socket socket = servSocket.accept(); // wait for client
            System.out.println("Client connected!");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            String message = in.readLine(); // receive message
            System.out.println("Client says: " + message);

            socket.close();
            servSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}