package InterfaceGraphique;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

import Bd_donne.Connexion;
import Bd_donne.Executer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Interface extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Connexion m_connexion;
	private Executer m_execution ;
	private JTextField m_personne;
	private JTextField m_nom;
	private JTextField m_numero;
	private JTextField m_position;
	private JTextField m_noPersonne;

	private static String CHERCHER = "rechercher une Personne";
	private static String CHARGER = "Charger";
	private static String AJOUTER = "Ajouter";
	private static String OK = "Valider";
	private static String QUITTER = "Quitter l'application";

	private JButton btnChercher;
	private JButton btnCharger;
	private JButton btnAjouter;
	private JButton btnOk;
	private JButton btnQuitter;

	public Interface() throws SQLException {
		
		m_connexion = new Connexion();
		setTitle("User Interface");
		setBounds(100, 100, 800, 550);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JLabel lblPersonne = new JLabel("Personne");
		lblPersonne.setBounds(12, 13, 56, 16);
		getContentPane().add(lblPersonne);

		JLabel lblPrnom = new JLabel("Pr\u00E9nom");
		lblPrnom.setBounds(12, 37, 56, 16);
		getContentPane().add(lblPrnom);

		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(12, 66, 56, 16);
		getContentPane().add(lblNom);

		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setBounds(12, 104, 56, 16);
		getContentPane().add(lblNumero);

		JLabel lblDateDeNaissance = new JLabel("Date de Naissance");
		lblDateDeNaissance.setBounds(12, 147, 132, 16);
		getContentPane().add(lblDateDeNaissance);

		m_personne = new JTextField();
		m_personne.setBounds(80, 34, 116, 22);
		getContentPane().add(m_personne);
		m_personne.setColumns(10);

		m_nom = new JTextField();
		m_nom.setBounds(80, 63, 116, 22);
		getContentPane().add(m_nom);
		m_nom.setColumns(10);

		m_numero = new JTextField();
		m_numero.setColumns(10);
		m_numero.setBounds(80, 101, 116, 22);
		getContentPane().add(m_numero);

		JTextArea p_ducments = new JTextArea();
		p_ducments.setBounds(12, 246, 201, 209);
		getContentPane().add(p_ducments);

		JTextArea p_doc = new JTextArea();
		p_doc.setBounds(272, 246, 176, 209);
		getContentPane().add(p_doc);

		JLabel lblDocuments = new JLabel("Documents");
		lblDocuments.setBounds(12, 231, 79, 16);
		getContentPane().add(lblDocuments);

		JLabel lblDocument = new JLabel("Document");
		lblDocument.setBounds(272, 231, 69, 16);
		getContentPane().add(lblDocument);

		JTextArea txtrEvenement = new JTextArea();
		txtrEvenement.setBounds(258, 31, 310, 123);
		getContentPane().add(txtrEvenement);

		JLabel lblEvenements = new JLabel("Evenements");
		lblEvenements.setBounds(258, 13, 83, 16);
		getContentPane().add(lblEvenements);

		// bouton Chercher
		btnChercher = new JButton("Chercher");
		btnChercher.setActionCommand(CHERCHER);
		btnChercher.addActionListener(this);
		btnChercher.setBounds(659, 33, 97, 25);
		getContentPane().add(btnChercher);

		// bouton Charger
		btnCharger = new JButton("Charger");
		btnCharger.setBounds(659, 210, 97, 25);
		btnCharger.addActionListener(this);
		btnCharger.setActionCommand(CHARGER);
		getContentPane().add(btnCharger);

		// bouton Ajouter
		btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(659, 276, 97, 25);
		btnAjouter.addActionListener(this);
		btnAjouter.setActionCommand(AJOUTER);
		getContentPane().add(btnAjouter);

		// Bouton OK
		btnOk = new JButton("OK");
		btnOk.setBounds(659, 333, 97, 25);
		btnOk.addActionListener(this);
		btnOk.setActionCommand(OK);
		getContentPane().add(btnOk);

		// bouton Quitter
		btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(659, 407, 97, 25);
		btnQuitter.addActionListener(this);
		btnQuitter.setActionCommand(QUITTER);
		getContentPane().add(btnQuitter);

		// position de la personne
		JLabel lblPosition = new JLabel("Position");
		lblPosition.setBounds(460, 305, 56, 16);
		getContentPane().add(lblPosition);

		m_position = new JTextField();
		m_position.setBounds(460, 334, 116, 22);
		getContentPane().add(m_position);
		m_position.setColumns(10);

		// numero de la personne
		JLabel lblNoDePersonne = new JLabel("No de personne");
		lblNoDePersonne.setBounds(460, 369, 116, 16);
		getContentPane().add(lblNoDePersonne);

		m_noPersonne = new JTextField();
		m_noPersonne.setBounds(460, 408, 116, 22);
		getContentPane().add(m_noPersonne);
		m_noPersonne.setColumns(10);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

		if (command.equals(CHERCHER)) {
			// TODO
		} else if (command.equals(CHARGER)) {
			// TODO
		} else if (command.equals(AJOUTER)) {
			// TODO
		} else if (command.equals(OK)) {
			// TODO
		} else if (command.equals(QUITTER)) {

		}

	}

}
