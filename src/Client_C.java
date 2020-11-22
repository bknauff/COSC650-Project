import java.net.*;
import java.io.*;

public class Client_C {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("www.example.com", 80);
        PrintWriter fromS = new PrintWriter(socket.getOutputStream(), true);
        fromS.println("GET / HTTP/1.1");
        fromS.println("Host: example.com");
        fromS.println("User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:83.0) Gecko/20100101 Firefox/83.0");
        fromS.println("Accept: text/html");
        fromS.println("Accept-Language: en-US");
        fromS.println("");
        socket.shutdownOutput();
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String line;
        StringBuilder data = new StringBuilder();
        DatagramSocket udpSocket = new DatagramSocket();
        byte[] buf = new byte[1024];
        InetAddress address = InetAddress.getByName("127.0.0.1");
        DatagramPacket packet;


        while((line = reader.readLine()) != null){
            data.append("\n").append(line);
        }
        System.out.println(data);
        buf = data.toString().getBytes();
        packet = new DatagramPacket(buf, buf.length, address, 12331);
        udpSocket.send(packet);
        socket.shutdownInput();
        System.out.println("DATA SENT");

        socket.close();
        fromS.close();
        reader.close();
    }
}
