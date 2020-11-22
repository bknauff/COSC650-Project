import java.net.*;

public class Client_C1 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress address = InetAddress.getByName("127.0.0.1");
        String msg = "CLIENT C1 SYSTEM TIME IS " + System.currentTimeMillis();
        DatagramPacket packet = new DatagramPacket(msg.getBytes(), msg.getBytes().length, address, 12331);
        socket.send(packet);

        socket.close();
    }
}
