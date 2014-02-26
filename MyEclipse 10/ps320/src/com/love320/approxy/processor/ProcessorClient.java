package com.love320.approxy.processor;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;

import com.love320.approxy.Config;
import com.love320.approxy.manager.IPort;
import com.love320.approxy.manager.P2PManager;



public class ProcessorClient implements Runnable {

	private static Socket socketT = null;
	
	@Override
	public void run() {
			try {
				socketT = new Socket(Config.PROXY_HOST,Config.PROXY_TO_DOC);
				read();//读取
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			socketT = null;//异常后，清空连接
	}
	
	public void read() throws IOException{
		while(true){
			byte[] buffer = new byte[1024*4];
			int temp = 0;
			temp = socketT.getInputStream().read(buffer);
			if(temp==-1)break;
			String msg =new String(buffer,0,temp);
			
			List<IPort> iportlist = P2PManager.IPort(msg);
			if(iportlist.size() == 0){
				outWrite(msg.getBytes());//回复
			}else{
				for(IPort iport : iportlist){
					Socket clientSocket = new Socket(iport.getIp(),iport.getPort());
					P2PManager.msg("Target ClientSocket:"+clientSocket);
					Socket serverSocket = new Socket(Config.PROXY_HOST,Config.PROXY_TO_DOC);
					P2PManager.msg("PROXY_TO_DOC Server:"+serverSocket);
					P2PManager.P2PGO(clientSocket,serverSocket);//启动
				}
			}
		}
	}
	
	public static boolean isclose(){
		try {
			if(socketT == null ) return false;
			outWrite(Config.TEST.getBytes());
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}  
		return false;
	}
	
	public static boolean outWrite(byte[] bytes) throws IOException{
		DataOutputStream out = new DataOutputStream(socketT.getOutputStream());
		out.write(bytes);
		out.flush();//即刻写入
		return true;
	}
	

}
