package com.love320.approxy.manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

import com.love320.approxy.Config;

public class FileOutMsg extends java.lang.Thread {
	
	private File file=new File(Config.FILESERVER);
	
	public FileOutMsg(File file){
		this.file = file;
	}
	
	private static Queue<String> queue = new LinkedList<String>();  
	
	public static void setData(String msg){
		synchronized (queue) {
			queue.offer(msg);
		}
	}
	
	@Override
	public void run() {
		P2PManager.msg("File: "+file.getAbsolutePath());
		try {
			FileOutputStream out=new FileOutputStream(file,true);
			while(true){
				String msg = queue.poll();
				if(msg != null) {
					out.write((msg+"\r\n").getBytes());
				}else{
					sleep(1000*1);
				}
			}
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}        
		
		
	}
	
	

}
