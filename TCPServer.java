 package networks;

import java.io.*; 
import java.net.*; 

class TCPServer { 
	

public static void main(String argv[]) throws Exception 
    { 
      String clientSentence=""; 
      String capitalizedSentence=""; 

 //  try {
    	ServerSocket welcomeSocket = new ServerSocket(6789);   
      Socket connectionSocket = welcomeSocket.accept(); 
      
      while(true) { 
	  		
         
          BufferedReader inFromClient = 
             new BufferedReader(new
             InputStreamReader(connectionSocket.getInputStream())); 

          DataOutputStream  outToClient = 
                  new DataOutputStream(connectionSocket.getOutputStream()); 
          
          clientSentence = inFromClient.readLine();   
          if(clientSentence!=null){
        	  if (!clientSentence.equals("end")) {        		                 
               	 capitalizedSentence = clientSentence.toUpperCase() + '\n';
               	 outToClient.writeBytes(capitalizedSentence); 
        		  }
        	  else {
        		  connectionSocket.close();
             } 
     	}
       

    
      } 
    } 
}
       

