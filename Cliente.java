import java.io.*;
import java.net.*;

//Classe principal do cliente 
public class Cliente {
	
	public static void main(String[] args) throws IOException {
		Socket socket = null; 
		//Para conectar corrretamente, digite, no console, o IP da maquina
		//que esta rodando o server.
		System.out.print("Digite o IP do server que deseja conectar: ");
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));			
		String serverHostname = stdIn.readLine(); 
		try { 	 
			socket = new Socket(serverHostname, 10008);
			try {
				new EnviarMsgCliente(socket);
				new ReceberMsgCliente(socket);
			} catch (IOException e) {
	            System.err.println("Couldn't get I/O for the connection to: " + serverHostname);
	            System.exit(1);
		    }		
		} catch (UnknownHostException e) {
            System.err.println("Don't know about host: " + serverHostname);
            System.exit(1);
        } 
		
		socket.close();
    }
}

