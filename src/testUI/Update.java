package testUI;
import java.sql.*;
public class Update {
	public static void majour(int id,dao.etudiant et) {
		try {
			   DbConn.connecter();
			   String requete =String.format("UPDATE etudiant set NOM='%s',PRENOM='%s' WHERE id_etudiant=%d ",et.getNom(),et.getPrenom(),id); 
			   Statement stmt = DbConn.con.createStatement();
			   int resultats = stmt.executeUpdate(requete);
			   DbConn.con.close();
			} catch (SQLException e) {
				System.out.println("nn");
		}
	}
}
