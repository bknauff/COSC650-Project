import java.net.*;

public class Client_C1 {
    public static void main(String[] args) throws Exception {
        byte[] buf = new byte[2048];
        DatagramSocket socket = new DatagramSocket(80);
        InetAddress address = InetAddress.getByName("127.0.0.1");
        String msg = "CLIENT C1 SYSTEM TIME IS " + System.currentTimeMillis();
        DatagramPacket packet = new DatagramPacket(msg.getBytes(), msg.getBytes().length, address, 12331);
        DatagramPacket returnPacket = new DatagramPacket(buf, buf.length);
        socket.send(packet);
        socket.receive(returnPacket);
        String returnMsg = new String(returnPacket.getData());
        System.out.println(returnMsg);

        socket.close();
    }
}
