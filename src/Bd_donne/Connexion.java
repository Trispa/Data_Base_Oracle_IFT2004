package Bd_donne;

import java.sql.*;

import javax.swing.JOptionPane;

public class Connexion {

	private boolean acceOK = true;
	Statement stmt;
	public CallableStatement callableStmt;
	public String username;
	public boolean getAcceOK() {
		return this.acceOK;
	}

	public Connexion() {

		

	}

	public boolean makeConnexion() throws Exception {
		String login;
		String passwd;
		java.sql.Connection con;
		int i = 0;
		Class.forName("oracle.jdbc.driver.OracleDriver");

		while (i < 3) {
			login = JOptionPane
					.showInputDialog("Quel est le nom de l'utilisateur?");
			passwd = JOptionPane.showInputDialog("Quel est le mot de passe?");

			try {
				con = DriverManager
						.getConnection(
								"jdbc:oracle:thin:@ift-oracle2k3.fsg.ulaval.ca:1521:ora11g",
								login, passwd);
				stmt = con.createStatement();
				callableStmt = con.prepareCall("{? = call FCT_NOUVEAU_NO_COMMENTAIRE ()}");
				callableStmt.registerOutParameter (1, Types.INTEGER);
			    //callableStmt.setString(2,"Didia");   
			    username = login;
				return true;
			} catch (Exception ex) {

				if (ex.getMessage().indexOf("invalid username/password") > 0) {
					JOptionPane
							.showMessageDialog(null,
									"La combinaison mot de passe usager est invalide veuillez reessayer");
					i++;
				} else {
					throw ex;
				}
			}

		}
		JOptionPane.showMessageDialog(null,
				"Connexion a la base de données impossible!");
		return false;
	}
}
