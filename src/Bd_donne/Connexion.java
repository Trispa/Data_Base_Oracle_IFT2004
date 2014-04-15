package Bd_donne;

import java.sql.*;

import javax.swing.JOptionPane;

public class Connexion {

	private boolean acceOK = true;
	Statement stmt;

	public boolean getAcceOK() {
		return this.acceOK;
	}

	public Connexion(){

//		String login = ""; // vous pouvez �crire directement le login ici et ne
//							// pas poser la question juste apr�s
//		String passwd = ""; // vous pouvez �crire directement le mot de passe
//								// ici et ne pas poser la question juste apr�s
//
//		try {
//			/**login = JOptionPane
//					.showInputDialog("Quel est le nom de l'utilisateur?");
//			passwd = JOptionPane.showInputDialog("Quel est le mot de passe?");
//			**/
//			// 1-initialisation de la connexion.
//
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			java.sql.Connection con = DriverManager
//					.getConnection(
//							"jdbc:oracle:thin:@ift-oracle2k3.fsg.ulaval.ca:1521:ora11g",
//							login, passwd);
//			// 2-Cr�ation de la requ�te pour envoie de l'instruction.
//			stmt = con.createStatement();
//		} catch (Exception ex) {
//			// On v�rifie la pr�sence du message anglais de login invalide.
//			if (ex.getMessage().indexOf("invalid username/password") > 0) {
//				JOptionPane
//						.showMessageDialog(null,
//								"La combinaison mot de passe usager est invalide veuillez reessayer");
//				this.acceOK = false;
//			}
//		}

	}
	
	public boolean makeConnexion() throws Exception
	{
		String login;
		String passwd;
		java.sql.Connection con;
		int i = 0;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		while(i < 3)
		{
			login  = JOptionPane.showInputDialog("Quel est le nom de l'utilisateur?");
			passwd = JOptionPane.showInputDialog("Quel est le mot de passe?");
			
			try {
				con = DriverManager
						.getConnection(
								"jdbc:oracle:thin:@ift-oracle2k3.fsg.ulaval.ca:1521:ora11g",
								login, passwd);
				stmt = con.createStatement();
				return true;
			} catch(Exception ex){
				
				if (ex.getMessage().indexOf("invalid username/password") > 0) {
					JOptionPane
							.showMessageDialog(null,
									"La combinaison mot de passe usager est invalide veuillez reessayer");
					i++;
				}
				else
				{
					throw ex;
				}
			}
			
		}
		JOptionPane
		.showMessageDialog(null,
				"Connexion a la base de donn�es impossible!");
		return false;
	}
}
