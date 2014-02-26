package com.love320.approxy.mode;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import com.love320.approxy.Config;
import com.love320.approxy.manager.IPort;
import com.love320.approxy.manager.P2PManager;
import com.love320.approxy.processor.ActionSocketServer;
import com.love320.approxy.processor.ProcessorServer;




public class P2PServerReverse implements Runnable{
	
	private IPort iport;
	
	public static boolean action(){
		
		ProcessorServer processor = new ProcessorServer();
		new Thread(processor).start();//启动专用通信线程
		
		for(IPort iport:Config.IPORTLIST){
			//if(iport.getType() != 2) continue;//类型判断
			P2PManager.msg("Started(Listen Port:"+iport.getProxy()+") for P2PServerReverse ");
			P2PServerReverse server= new P2PServerReverse();
			server.setIport(iport);
			new Thread(server).start();
		}
		
		return true;
	}

	@Override
	public void run() {
		
		try {
			ServerSocket proxySocket = new ServerSocket(iport.getProxy());
			while (true) {
					Socket clientSocket = proxySocket.accept();//取客户连接
					P2PManager.msg("My Client for P2PServerReverse:"+clientSocket);
					ActionSocketServer ass = new ActionSocketServer(clientSocket,iport.getIp(),iport.getPort());//绑定相关连接
					new Thread(ass).start();//启动
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}

	public void setIport(IPort iport) {
		this.iport = iport;
	}
	
	

}
