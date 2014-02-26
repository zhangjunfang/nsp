package com.love320.approxy.processor;

import com.love320.approxy.manager.P2PManager;

//维护关系 通信关系
public class StayConnectedServer extends java.lang.Thread {

	@Override
	public void run() {
		P2PManager.msg("StayConnected OK .");
		for(;;){
				try {
					sleep(1000*30);
					if(ProcessorServer.isconn) {
						ProcessorServer.isconn = false;
					}else{
						ProcessorServer.reSocketT();//重新获取新的
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}
	}

}
