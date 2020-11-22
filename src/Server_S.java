import java.net.*;

public class Server_S {
    public static void main(String[] args) throws Exception {

        DatagramSocket udpSocket = new DatagramSocket(12331);
        byte[] buf = new byte[512];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        udpSocket.receive(packet);
        String input = new String(packet.getData()).trim();
        System.out.println(input);

        System.out.println();
        udpSocket.close();
    }
}
