import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginPage {
	public static boolean validate(String email, String pass) {
		boolean status = false;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loginpage", "root", "3zs63kg5");
			PreparedStatement ps = con.prepareStatement("select * from register where email=? and pass=?");
			ps.setString(1, email);
			ps.setString(2, pass);
			
			ResultSet rs = ps.executeQuery();
			status = rs.next();
			
			}catch(Exception e) {
			
			}
		return status;
	}
}
