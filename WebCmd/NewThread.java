package shell;

import shell.CommandeShell;

public class NewThread extends Thread {
	String deplacement;

	 public NewThread(String deplacement){
		    this.deplacement=deplacement;
		  }
	 
	 public void run() 
	 {
		  
		    CommandeShell obj = new CommandeShell();
		    String command1 = "java -jar RobotCmd.jar GET_MAP_STRING " + deplacement ;
			String output2 = obj.executeCommand(command1);
			System.out.println(output2);
		 
		 
	 }
	 
	 
}
	 


