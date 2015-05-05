

import java.io.*;
import java.net.*;

public class Requester{
	Socket requestSocket;
	ObjectOutputStream out;
 	ObjectInputStream in;
 	String message;
	Requester(){}
	void run()
	{
		
		try{
			//1. creating a socket to connect to the server
			requestSocket = new Socket("127.0.0.1",5455);
			System.out.println("Connected to localhost in port 5555");
			
			//2. get Input and Output streams
			out = new ObjectOutputStream(requestSocket.getOutputStream());
			out.flush();
			
			in = new ObjectInputStream(requestSocket.getInputStream());
			System.out.println("coucou");
			//3: Communicating with the server
			
				sendMessage("CLIENT");
			
		}
		catch(UnknownHostException unknownHost){
			System.err.println("You are trying to connect to an unknown host!");
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
		finally{
			//4: Closing connection
			try{
				in.close();
				out.close();
				requestSocket.close();
			}
			catch(IOException ioException){
				ioException.printStackTrace();
			}
		}
	}
	void sendMessage(String msg)
	{
		try{
			out.writeObject(msg);
			out.flush();
			System.out.println("Le Client envoie >");
			System.out.println(msg);
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
	}
	
	public static void main(String args[])
	{
		Requester client = new Requester();
		client.run();
	}
	
	
}

