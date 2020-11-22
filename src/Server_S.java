import java.io.IOException;
import java.net.*;
import java.util.ArrayList;

public class Server_S implements Runnable {

/*
    static ArrayList<ClientHandler> clients = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ServerSocket listener = new ServerSocket(12331);

        while(true){
            Socket client = listener.accept();
            ClientHandler clientThread = new ClientHandler(client);
            clients.add(clientThread);
        }
    }

 */


    DatagramSocket udpSocket;
    DatagramPacket packet;
    byte[] buf;

    public Server_S() throws SocketException {
        udpSocket = new DatagramSocket(12331);
    }

    public void run() {
        try {
            buf = new byte[2048];
            packet = new DatagramPacket(buf, buf.length);
            udpSocket.receive(packet);
            String input = new String(packet.getData());
            if(input.contains("CLIENT C1")){
                System.out.println(input);
                String msg = "TIME ACK";
                DatagramPacket packetReturn = new DatagramPacket(msg.getBytes(), msg.getBytes().length, packet.getAddress(), 80);
                udpSocket.send(packetReturn);
            }
            else{
                System.out.println(input);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            udpSocket.close();
        }
    }

    public static void main(String[] args) throws IOException {
        Server_S server = new Server_S();
        Thread s1 = new Thread(server);
        s1.start();
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
