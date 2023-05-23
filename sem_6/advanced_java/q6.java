package studentinfo;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import oracle.jdbc.driver.OracleTypes;

public class studentinfo {

	public static void main(String[] args) {
		int st_id=0;
		String name;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","scott","tiger");
			Statement stmt=con.createStatement();
			CallableStatement cs=con.prepareCall("{call selection(?)}");
			cs.registerOutParameter(1, OracleTypes.CURSOR);
			cs.execute();
			ResultSet rs=(ResultSet)cs.getObject(1);
		    rs=stmt.executeQuery("select * from student_tbl");
			System.out.println("Student Details");
			System.out.println("StudentID"+"\t"+"NAME");
			while(rs.next()) {
				st_id=rs.getInt(1);
				name=rs.getString(2);
				System.out.println(st_id+"\t"+name);
				
			}
		con.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
		
		
		
	}

}
