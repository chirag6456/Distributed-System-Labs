
import java.io.*;
import java.net.*;

public class FileServer extends Thread {
	
	private ServerSocket ss;    //create server socket 
	
	public FileServer(int port) {
		try {
			ss = new ServerSocket(port);  //initialize socket on given port
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		while (true) {
			try {
				Socket clientSock = ss.accept(); //accept client connection
				saveFile(clientSock);            //invoke method for saving file
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void saveFile(Socket clientSock) throws IOException {
		DataInputStream dis = new DataInputStream(clientSock.getInputStream());
		FileOutputStream fos = new FileOutputStream("servercopy.py");
		byte[] buffer = new byte[4096];
		
		int filesize = 15123; // Send file size in separate msg
		int read = 0;
		int totalRead = 0;
		int remaining = filesize;
		while((read = dis.read(buffer, 0, Math.min(buffer.length, remaining))) > 0) {   //read file from client
			totalRead += read;                                   
			remaining -= read;
			System.out.println("read " + totalRead + " bytes.");
			fos.write(buffer, 0, read);                      //write using file output stream
		}
		
		fos.close();
		dis.close();
	}
	
	public static void main(String[] args) {
		FileServer fs = new FileServer(1988);     //create new object fs
		fs.start();
	}

}