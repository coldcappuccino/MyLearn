package com.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private List<Mychannel> list = new ArrayList();
  
    public static void main(String[]args) throws IOException{
           new Server().Start();
         
    }
    
    
    public void Start() throws IOException{
         ServerSocket server = new ServerSocket(9999);
         while(true){
           Socket client = server.accept();
           Mychannel mychannel = new Mychannel(client);
           list.add(mychannel);
           new Thread(mychannel).start();
         }
    }
    
    private class Mychannel implements Runnable{
      
        private DataInputStream dis;
        private DataOutputStream dos;
        private boolean isRunning = true;
        private String name = null;
        public Mychannel(Socket client){
            try {
               dis = new DataInputStream(client.getInputStream());
               dos = new DataOutputStream(client.getOutputStream());
               name = dis.readUTF();
               System.out.println(name);
               this.Send("欢迎进入聊天室");
               this.SendOthers(name+"进入聊天室");
            } catch (IOException e) {
              // TODO Auto-generated catch block
               e.printStackTrace();
               CloseUtil.closeAll(dis,dos);
               isRunning = false;
            }
            
        }
      
        public void run() {
               while(isRunning){
                   try {
                      SendOthers(Receive());
                  } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                  }
               }
        }
        
        private String Receive() throws IOException{
              return dis.readUTF();
        }
        
        public void Send(String msg){
             if(null!=msg){
                 try {
                  dos.writeUTF(msg);
                  dos.flush();
                } catch (IOException e) {
                  // TODO Auto-generated catch block
                  e.printStackTrace();
                  CloseUtil.closeAll(dis,dos);
                  isRunning = false;
                }
             }
        }
        
        public void SendOthers(String msg) throws IOException{
            
             if(msg.startsWith("@")&&msg.indexOf(":")>-1){
                 String name = msg.substring(1,msg.indexOf(":"));
                 String content = msg.substring(msg.indexOf(":")+1);
                 for(Mychannel temp:list){
                    if(temp.name.equals(name)){
                         temp.Send("私聊:"+content);
                    }
                 }
             }else{
                for(Mychannel temp:list){
                     temp.Send(msg);
                }
             }
        }
     }
}






