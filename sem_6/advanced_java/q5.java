import java.sql.Connection; 
import java.sql.*; 
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.Statement; 
public class q5{ 
    public static void main(String args[]) { 
        int id = 0,price =0; 
        String name; 
        try { 
            Class.forName("oracle.jdbc.driver.OracleDriver"); 
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger"); 
            Statement stmt = con.createStatement(); 
            PreparedStatement stmt1=con.prepareStatement("update product set name=? where productid=?"); 
            stmt1.setString(1,"choco"); 
            stmt1.setInt(2,113); 
            int i=stmt1.executeUpdate(); 
            System.out.println(i+" records updated"); 
            ResultSet rs = stmt.executeQuery("select * from product"); 
            System.out.println("PrductID" + "\t" + "Name"+ "\t" + "Price"); 
            while (rs.next()) { 
                id = rs.getInt(1); 
                name = rs.getString(2); 
                price = rs.getInt(3); 
                System.out.println( id + "\t" + name + "\t"+ price); 
            } 
            con.close(); 
        } 
        catch (Exception e) { 
            System.out.println(e); 
        } 
    } 
}
