import java.io.*;
import java.net.*;

public class FileClient {
	
	private Socket s;
	
	public FileClient(String host, int port, String file) {      //initialize with localhost and port 1988 and file server.py
		try {
			s = new Socket(host, port);
			sendFile(file);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public void sendFile(String file) throws IOException {
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		FileInputStream fis = new FileInputStream(file);
		byte[] buffer = new byte[4096];
		
		while (fis.read(buffer) > 0) {
			dos.write(buffer);
		}
		
		fis.close();
		dos.close();	
	}
	
	public static void main(String[] args) {
		FileClient fc = new FileClient("localhost", 1988, "server.py");
	}

}