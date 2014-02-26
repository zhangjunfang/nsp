package com.love320.approxy.mode;

import java.io.File;
import java.io.IOException;
import com.love320.approxy.Config;
import com.love320.approxy.manager.FileOutMsg;
import com.love320.approxy.manager.P2PManager;
import com.love320.approxy.processor.ProcessorClient;



public class P2PClient extends java.lang.Thread  {
	
	public static void main(String[] args) throws IOException {
		
		FileOutMsg fom = new FileOutMsg(new File(Config.FILECLIENT));//日志
		new Thread(fom).start();//启动日志
		
		P2PManager.msg("Started Listen Port:"+Config.PROXY_HOST+":"+Config.PROXY_TO_DOC);
		
		ProcessorClient processor = new ProcessorClient();
		
		Thread mainthread= null;
		while(true){
			try {
				if(!ProcessorClient.isclose()){
					mainthread= new Thread(processor);//启动专用通信线程
					mainthread.start();
					P2PManager.msg("clinet for server Go ...");
				}
				sleep(1000*5);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
}
