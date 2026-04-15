// Client.java
import java.io.*;
import java.net.*;

public class Client_704 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 5000); // connect to server

            BufferedReader userInput = new BufferedReader(
                    new InputStreamReader(System.in)
            );

            PrintWriter out = new PrintWriter(
                    socket.getOutputStream(), true
            );

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            // take deposit amount from user
            System.out.print("Enter deposit amount: ");
            String amount = userInput.readLine();

            // send to server
            out.println(amount);

            // receive response from server
            String response = in.readLine();
            System.out.println("🏦 Server: " + response);

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}