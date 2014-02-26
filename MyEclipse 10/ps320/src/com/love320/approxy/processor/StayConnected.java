package com.love320.approxy.processor;

import java.io.IOException;

import com.love320.approxy.Config;
import com.love320.approxy.manager.P2PManager;

//维护关系 通信关系
public class StayConnected extends java.lang.Thread {

	@Override
	public void run() {
		P2PManager.msg("StayConnected OK .");
		for(;;){
			try {
				sleep(1000*10);
				ProcessorServer.sendConnetNewSocket(Config.TEST);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
				ProcessorServer.reSocketT();//重新获取新的
			}
		}
	}

}
