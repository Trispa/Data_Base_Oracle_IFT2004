package Bd_donne;

import javax.swing.JOptionPane;

import InterfaceGraphique.Interface;

public class Main {
	/**
	 * @param args
	 */

	public static void main(String[] args) {
		try {
			int i = 0;

			do {
				Connexion m_connexion = new Connexion();
				if (m_connexion.getAcceOK() == true)
					break;
				else
					i++;
			} while (i < 3);

			if (i == 3)

			{
				JOptionPane
						.showMessageDialog(null,
								"Vous avez fait 3 tentatives de connexion erronées... :( bye");
			} else {
				Interface mon_Interface = new Interface();
				mon_Interface.setVisible(true);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
