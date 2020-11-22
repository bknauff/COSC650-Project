import java.net.*;

public class ClientHandler implements Runnable{

    DatagramSocket client;
    DatagramPacket packet;
    byte[] buf;

    public ClientHandler(DatagramSocket clientSocket){
        this.client = clientSocket;
        buf = new byte[2048];
        packet = new DatagramPacket(buf, buf.length);
    }

    public void run() {
        try{
            client.receive(packet);
            String input = new String(packet.getData());
            if(input.contains("CLIENT C1")){
                System.out.println(input);
            }
            else {
                System.out.println(input);
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            client.close();
        }
    }
}
