import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class DataSender {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    InetAddress toAdr = InetAddress.getLocalHost();
    int toPort = 55555;
    DatagramSocket socket = new DatagramSocket();
    DatagramPacket packet;
    byte[] data;
    String prompt = "What do you want to send: ";
    String message;

    public DataSender() throws UnknownHostException, SocketException, IOException {
        System.out.println(prompt);
        while ((message = in.readLine()) != null) {
            if (message.equals("bye"))
                System.exit(0);
            data = message.getBytes();
            packet = new DatagramPacket(data, data.length, toAdr, toPort);
            socket.send(packet);
            System.out.println(prompt);
        }
    }
}
