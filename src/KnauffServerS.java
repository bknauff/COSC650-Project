import java.io.IOException;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class KnauffServerS implements Runnable {
    public void run() {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        DatagramSocket udpSocket = null;
        try {
            udpSocket = new DatagramSocket(12331);
            while (true) {
                byte[] buf = new byte[2048];
                DatagramPacket packet = new DatagramPacket(buf, buf.length);

                try {
                    udpSocket.receive(packet);
                    pool.execute(new KnauffClientHandler(udpSocket, packet));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (udpSocket != null)
                udpSocket.close();
        }
    }

    public static void main(String[] args) throws IOException {
        KnauffServerS server = new KnauffServerS();
        server.run();
    }
}
