import java.net.*;

public class ClientHandler implements Runnable{

    DatagramSocket client;
    DatagramPacket packet;
    byte[] buf;

    public ClientHandler(DatagramSocket socket, DatagramPacket packet){
        this.client =socket;
        this.packet = packet;
        buf = new byte[2048];
    }

    public void run() {
        try{
            String input = new String(packet.getData());
            if (input.contains("CLIENT C1")) {
                System.out.println(input);
                String msg = "TIME ACK";
                DatagramPacket packetReturn = new DatagramPacket(msg.getBytes(), msg.getBytes().length, packet.getAddress(), 80);
                client.send(packetReturn);
            } else {
                System.out.println(input);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
