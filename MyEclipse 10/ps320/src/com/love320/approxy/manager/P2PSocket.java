package com.love320.approxy.manager;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class P2PSocket  implements Runnable{
	
	private Socket clientSocket;   
	private Socket serverSocket;   
	
    public P2PSocket (Socket clientSocket,Socket serverSocket){   
        this.clientSocket= clientSocket;   
        this.serverSocket = serverSocket;
    }   

	@Override
	public void run() {
		try {
	    	DataOutputStream out =new DataOutputStream(clientSocket.getOutputStream());   
	    	InputStream in =serverSocket.getInputStream();

	    	byte[] buffer = new byte[1024*4];   
	    	int temp = 0;   
	    	while(true){
	    		temp = in.read(buffer);
	    		if(temp==-1)break;
	    		String msg =new String(buffer,0,temp);
	    		P2PManager.msg(msg);
	    		out.write(buffer,0,temp);
	    	}
		} catch (IOException e) {
			e.printStackTrace();
		}   
		socketClose(clientSocket);
	}
	
	public static void socketClose(Socket socket){
		P2PManager.msg("Close:"+socket);
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	
}
