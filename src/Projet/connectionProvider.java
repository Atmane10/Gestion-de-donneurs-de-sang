package Projet;
import java.sql.*;

public class connectionProvider {
	public static Connection getCon() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//créer la connexion
			//nom de la databade: db
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdd","root","");
			return con;
	
		}
		catch(Exception ee){
			return null;
		}
	}


}
