import java.net.*;

public class Server_S implements Runnable {

    public void run() {

    }
    /*
    public static void main(String[] args) throws Exception {
        DatagramSocket udpSocket = new DatagramSocket(12331);
        byte[] buf = new byte[2048];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        udpSocket.receive(packet);
        String input = new String(packet.getData()).trim();
        System.out.println(input);

        udpSocket.close();
    }
     */
}
