import java.net.*;
import java.io.*;

public class Client_C {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("www.example.com", 80);
        PrintWriter fromS = new PrintWriter(socket.getOutputStream(), true);
        fromS.println("GET / HTTP/1.1");
        fromS.println("Host: example.com");
        fromS.println("");
        socket.shutdownOutput();
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String line;
        StringBuilder data = new StringBuilder();

        while ((line = reader.readLine()) != null) {
            data.append("\n").append(line);
        }
        socket.shutdownInput();
        System.out.println(data);

        byte[] buf = new byte[2048];
        DatagramSocket udpSocket = new DatagramSocket();
        InetAddress address = InetAddress.getByName("127.0.0.1");
        buf = data.toString().getBytes();
        DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 12331);
        udpSocket.send(packet);
        System.out.println("\nDATA SENT");

        socket.close();
        udpSocket.close();
        fromS.close();
        reader.close();
    }
}
