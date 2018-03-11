package com.socket;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


//用于接收的类
public class Send implements Runnable{

  private BufferedReader console;
  private DataOutputStream dos;
  private Socket client;
  private boolean isRunning = true;
  private String name;
  
  public Send(Socket client,String name){
     console = new BufferedReader(new InputStreamReader(System.in));
     this.client = client;
     this.name = name;
     
     try {
         dos = new DataOutputStream(client.getOutputStream());
     } catch (IOException e) {
         // TODO 
         e.printStackTrace();
        isRunning = false;
        CloseUtil.closeAll(dos,console);
     }
     
     try {
       send(name);
     } catch (IOException e1) {
      // TODO Auto-generated catch block
       e1.printStackTrace();
     }
     
  }
  
  private String getMsgFromconsole() throws IOException{
      return console.readLine();
  }
  
  public void send(String msg) throws IOException{
      if(null!=msg){
          dos.writeUTF(msg);
          dos.flush();
      }
  }
  
  public void run() {
      while(isRunning){
         try {
          send(getMsgFromconsole());
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
  }
      
}







