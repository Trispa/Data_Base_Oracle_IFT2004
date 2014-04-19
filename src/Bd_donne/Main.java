package Bd_donne;

import javax.swing.JOptionPane;

import InterfaceGraphique.Interface;

public class Main {
	/**
	 * @param args
	 */

	public static void main(String[] args) {
		try {
				Connexion m_connexion = new Connexion();
				if(m_connexion.makeConnexion())
				{
					Executer executeur = new Executer(m_connexion.stmt, m_connexion.callableStmt, m_connexion.username);
					Interface mon_Interface = new Interface(executeur);
					mon_Interface.setVisible(true);
				}
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
