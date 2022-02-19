import java.io.*;
import java.net.*;

public class Cliente {
	private static Socket socket;
	
	public static void main(String[] args) throws IOException {
		String serverHostname = new String ("192.168.15.8");
		socket = new Socket(serverHostname, 10008);
		new ReceberMsgCliente(socket);
		new EnviarMsgCliente(socket); 
    }
}

