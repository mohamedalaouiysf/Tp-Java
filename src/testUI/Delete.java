package testUI;

import java.sql.SQLException;
import java.sql.Statement;

public class Delete {
	public static void del(int id) {
		try {
			   DbConn.connecter();
			   //DELETE FROM `etudiant` WHERE `etudiant`.`id_etudiant` = 6 »
			   String requete =String.format("DELETE FROM etudiant WHERE id_etudiant='%d'",id); 
			   Statement stmt = DbConn.con.createStatement();
			   int resultats = stmt.executeUpdate(requete);
			   DbConn.con.close();
			} catch (SQLException e) {
				System.out.println("nn");
		}
	}
}
