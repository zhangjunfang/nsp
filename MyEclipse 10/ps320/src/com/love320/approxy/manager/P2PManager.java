package com.love320.approxy.manager;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class P2PManager {
	
	public static void msg(String message){
		System.out.println("Msg :"+message);
		FileOutMsg.setData(message);
	}
	
	//绑定通信
	public static void P2PGO(Socket clientSocket,Socket serverSocket){
		
		P2PSocket p2pC = new P2PSocket(clientSocket,serverSocket);
		P2PSocket p2pS = new P2PSocket(serverSocket,clientSocket);
		
		new Thread(p2pC).start();
		new Thread(p2pS).start();
		
	}
	
	//生成IP:port通信协议
	public static String IPort(String ip,Integer port){
		return "@"+ip +"#"+port+"@";
	}
	
	//解释IP:port通信协议
	public static List<IPort> IPort(String msg){
		List<IPort> list = new ArrayList<IPort>();
		if(msg == null) return list;
		
		String[] iports = msg.split("@");
		for(String sing : iports){
			String[] ss = sing.split("#");
			if(ss.length == 2){
				list.add(new IPort(ss[0],Integer.valueOf(ss[1])));
			}
		}
		return list;
	}

}
