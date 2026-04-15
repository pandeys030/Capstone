import java.io.*;
import java.net.*;

public class SIT_Client_701 {
    public static void main(String[] args) throws UnknownHostException{
        try{
            Socket socket = new Socket("Localhost", 3000);

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            out.println("Hello support team");
        
            socket.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

//client-----------------server
// start ----------------> waiting 
//connected --------------> receive message
//close socket --------------> print message & close socket
//key concepts
//1) ServerSocket: waits for connection
//2) Socket: client & server use socket to communicate
//3) BufferedReader & PrintWriter: used to read & write data through socket
//4) input & output stream: used to read & write data through socket
//5) accept(): server waits for client connection

