package testUI;
import java.sql.*;
public class Select {
public static  String requete = "SELECT * FROM etudiant";
public static ResultSet sel() {
		try {
		   DbConn.connecter();
		   Statement stmt = DbConn.con.createStatement();
		   ResultSet resultats = stmt.executeQuery(requete);
		   return resultats;
		} catch (SQLException e) {
			return null;
		}
	}
public static ResultSet sel(dao.etudiant et) {
	try {
	   DbConn.connecter();
	   Statement stmt = DbConn.con.createStatement();
	   String sql =String.format("SELECT * FROM etudiant WHERE NOM='%s' and PRENOM='%s'",et.getNom(),et.getPrenom());
	   ResultSet resultats = stmt.executeQuery(sql);
	   return resultats;
	} catch (SQLException e) {
		return null;
	}
}
}
