import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class q4{
	public static void main(String[] args) {
		int id=0,salary=0;
		String name,dept,s;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from emptable");
			System.out.println("employees");
			System.out.println("id " + "\t" + "name" + "\t" + "department" + "\t" + "salary");
			if(rs!=null){
				while(rs.next()){
					id=rs.getInt(1);
					name=rs.getString(2);
					dept=rs.getString(3);
					salary=rs.getInt(4);
					System.out.println(id + "\t" + name + "\t" + dept + "\t" + salary);
				}
			}
			con.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
