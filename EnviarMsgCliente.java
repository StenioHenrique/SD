import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.*;

public class EnviarMsgCliente extends Thread {
	private BufferedWriter bfw;
	private OutputStream ou ;
	private Writer ouw;
	private Socket socket;
	
	public EnviarMsgCliente(Socket socket) throws IOException { 
		this.socket = socket; 
		ou = this.socket.getOutputStream();
	    ouw = new OutputStreamWriter(ou);
	    bfw = new BufferedWriter(ouw);
	    bfw.flush();
	    start(); 
	}
	
	public void run(){
		try { 
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
			String inputLine; 
			while ((inputLine = in.readLine()) != null) {
				bfw.write(inputLine+"\r\n");
				if (inputLine.equals("Bye."))
					break;
				bfw.flush();
			}
			
			bfw.close();
			ouw.close();
			ou.close();
		} catch (IOException e) {
			System.err.println("Problem with connection server!");
			System.exit(1); 
		}
	}
}

