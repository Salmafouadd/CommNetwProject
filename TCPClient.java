package networks;

import java.io.*; 
import java.net.*; 
class TCPClient { 

    public static void main(String argv[]) throws Exception 
    { 
       
       String sentence=""; 
       String modifiedSentence=""; 
       
       BufferedReader inFromUser = 
    	          new BufferedReader(new InputStreamReader(System.in)); 

    	   Socket clientSocket = new Socket("192.168.43.71", 6789); 

    	   DataOutputStream outToServer = 
    	          new DataOutputStream(clientSocket.getOutputStream()); 
    	   
    	   BufferedReader inFromServer = 
    	                new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); 

    	   sentence = inFromUser.readLine();
    	   
    	   if(!sentence.equals("connect")){
    		   System.out.println("Please connect first and try again");
    		   clientSocket.close();
    	   }
	while(sentence.equals("connect")) {
		
		while(!sentence.equals("end")){
			
		     sentence = inFromUser.readLine();
		     if(sentence.equals("end")) {
		    	 	clientSocket.close(); 
		    	 	break;
		     }
		     else {
			     outToServer.writeBytes(sentence + "\n");
			     modifiedSentence = inFromServer.readLine();
			     System.out.println("FROM SERVER: " + modifiedSentence);
		     }
	     	}
		 clientSocket.close(); 
		}
	       
	       
    }
    }

