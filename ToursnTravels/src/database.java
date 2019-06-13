import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class database {
    public static void main(String[] args){
        Connection con = null;
        Statement stat = null;
        ResultSet res = null;
        ResultSetMetaData meta = null;
        String query = "Select * from Phantom.Table1";
        try{
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/BookingInfo", "Phantom", "Phantom");
            stat = con.createStatement();
            res = stat.executeQuery(query);
            meta = res.getMetaData();
            
            int col = meta.getColumnCount();
            //System.out.println(col);
            for(int i = 1; i <= col; i++)
                System.out.print(meta.getColumnName(i) + "\t"); 
            
            System.out.println();
            while(res.next()){
                for(int i = 1; i <= col; i++)
                    System.out.print(res.getObject(i) + "\t");
                System.out.println();
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
}
