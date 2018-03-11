package com.socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

//用于接收
public class Receive implements Runnable{

  private Socket client;
  private DataInputStream dis;
  private boolean flag = true;
  
  public Receive(Socket client){
         this.client =  client;
      try {
         dis = new DataInputStream(client.getInputStream());
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
         flag = false;
         CloseUtil.closeAll(dis);
      }
      
  }
  
  
  public String read() throws IOException{
      String msg = dis.readUTF();
      return msg;
  }
  
  @Override
  public void run() {
      while(flag){
         try {
          System.out.println(read());
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
  }
  
}



