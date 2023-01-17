package testUI;
import java.sql.*;
public class DbConn{
	public static Connection con;
	public static void connecter() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("Driver O.K");
			String url="jdbc:mysql://localhost:3306/ecole";
			String user="root";
			String passwd="";
			con = DriverManager.getConnection(url,user,passwd);
			//System.out.println("cnx effective!");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void fermer() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}