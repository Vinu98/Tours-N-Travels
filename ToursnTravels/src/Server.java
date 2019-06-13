import java.io.*;  
import java.net.*;  
import java.sql.*;
import java.util.*;

public class Server {      
    public static void main(String[] args){         
        Connection con = null;
        Statement stat = null;
        ResultSet res = null;
        try{  
            ServerSocket ss = new ServerSocket(66);  
            Socket s = ss.accept();//establishes connection   
            DataInputStream dis = new DataInputStream(s.getInputStream());  
            String nam = (String)dis.readUTF();
            String ag = (String)dis.readUTF();
            String ui = (String)dis.readUTF();
            String sea = (String)dis.readUTF();
            String from = (String)dis.readUTF();;
            String to = (String)dis.readUTF();
        System.out.println("message= " + from + to);  
            //election();
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/BookingInfo", "Phantom", "Phantom");
            stat = con.createStatement();
            String id = getID();
            PreparedStatement add = con.prepareStatement("insert into Phantom.TABLE1 values (?,?,?,?,?,?,?)");
            add.setString(1, id);
            add.setString(2, nam);
            add.setString(3, ag);
            add.setString(4, ui);
            add.setString(5, sea);
            add.setString(6, from);
            add.setString(7, to);
            int row = add.executeUpdate();
            ss.close();  
        }
        catch(Exception e){System.out.println(e);}  
        
    }  
    public static String getID() {
    // It will generate 6 digit random Number.
    // from 0 to 999999
    Random rnd = new Random();
    int number = rnd.nextInt(999999);

    // this will convert any number sequence into 6 character.
    return String.format("%06d", number);
}
}  
