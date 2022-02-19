import java.net.*; 
import java.io.*; 

//Classe principal que ira inicializar o socket e as threads do servidor

public class Server {
	public static void main(String[] args) throws IOException { 
		ServerSocket serverSocket = null;
		
		try { 
			//criando a conexao de socket
			serverSocket = new ServerSocket(10008); 
			System.out.println ("Conexão de socket criada");
			try { 
				while (true){
					Socket s = serverSocket.accept(); 
					System.out.println ("Esperando conexão");
					//criacao das threads
					new EnviarMsgServer(s);
					new ReceberMsgServer(s);
				}
			} catch (IOException e) {
				System.err.println("Conexão falhou"); 
				System.exit(1); 
			}
		} catch (IOException e) {
			System.err.println("Não foi possivel acessar a porta: 10008."); 
			System.exit(1); 
		} finally {
			try {
				serverSocket.close(); 
			} catch (IOException e) { 
				System.err.println("Não foi possivel fechar a porta: 10008."); 
				System.exit(1); 
			} 
		}
	}
}
