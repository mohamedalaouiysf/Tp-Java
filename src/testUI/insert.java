package testUI;
import java.sql.*;
import dao.etudiant;
public class insert {
	public static void inserer(dao.etudiant et) {
		try {
			   DbConn.connecter();
			   String requete =String.format("INSERT INTO etudiant (NOM,PRENOM) VALUES ('%s','%s')",et.getNom(),et.getPrenom()); 
			   Statement stmt = DbConn.con.createStatement();
			   int resultats = stmt.executeUpdate(requete);
			   DbConn.con.close();
			} catch (SQLException e) {
				System.out.println("nn");
		}
	}
}
