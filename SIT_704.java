import java.io.*;
import java.net.*;

public class SIT_704 extends Thread {
    Socket socket;
    static int bankBalance = 1000;

    SIT_704(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );

            PrintWriter out = new PrintWriter(
                    socket.getOutputStream(), true
            );

            int deposit = Integer.parseInt(in.readLine());

            synchronized (SIT_704.class) {
                bankBalance += deposit;
                out.println("Deposit successful. Current balance: " + bankBalance);
            }

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println(" Bank Server Started...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            SIT_704 clientThread = new SIT_704(socket);
            clientThread.start(); // multi-client handling
        }
    }
}