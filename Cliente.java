import java.io.*;
import java.net.*;

//Classe principal do cliente 
public class Cliente {
	private static Socket socket;
	
	public static void main(String[] args) throws IOException {
		try { 
			//Para conectar corrretamente, digite, no console, o IP da maquina
			//que esta rodando o server.
			System.out.print("Digite o IP do server que deseja conectar: ");
			BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));			
			String serverHostname = stdIn.readLine();  
			socket = new Socket(serverHostname, 10008);
			new EnviarMsgCliente(socket);
			new ReceberMsgCliente(socket);
			
		} catch (IOException e) {
			System.err.println("Conexão falhou"); 
			System.exit(1); 
		}
    }
}

