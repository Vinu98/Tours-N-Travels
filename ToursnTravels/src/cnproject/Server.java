/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CNProject;

/**
 *
 * @author hp
 */
    import java.net.*;  
    import java.io.*;  
    class MyServer{  
    public static void main(String args[])throws Exception{  
    ServerSocket ss=new ServerSocket(333);  
    Socket s=ss.accept();  
    DataInputStream din=new DataInputStream(s.getInputStream());  
    DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
      
    String str="",str2="";  
    while(!str.equals("stop")){  
    str=din.readUTF();  
    System.out.println("client says: "+str);  
    str2=br.readLine();  
    dout.writeUTF(str2);  
    dout.flush();  
    if(str2=="confirm")
        break;
    }  
    din.close();  
    s.close();  
    ss.close();  
    }
}  