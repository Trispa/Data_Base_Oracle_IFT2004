package InterfaceGraphique;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Bd_donne.Connexion;
import Bd_donne.Executer;
import Bd_donne.Resultat;
import Bd_donne.Resultat.Document;
import Bd_donne.Resultat.Evenement;
import Bd_donne.Resultat.Personne;

import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JLayeredPane;

public class Interface extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private Executer m_execution;
	private Resultat m_resultat;
	private JTextField m_prenom;
	private JTextField m_nom;
	private JTextField m_numero;
	private JTextField m_position;
	private JTextField m_noPersonne;

	private JTextArea p_Evenement;
	private JTextArea p_documents;
	private JTextArea p_doc;
	private JLabel lblDocuments;
	private JLabel lblDocument;

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

	public Interface(Executer executeur) throws SQLException {
		
		m_execution = executeur;
		
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

		m_prenom = new JTextField();
		m_prenom.setBounds(80, 34, 116, 22);
		getContentPane().add(m_prenom);
		m_prenom.setColumns(10);

		m_prenom.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				changed();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				changed();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				changed();
			}
		});

		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(12, 66, 56, 16);
		getContentPane().add(lblNom);

		m_nom = new JTextField();
		m_nom.setBounds(80, 63, 116, 22);
		m_nom.addActionListener(this);
		m_nom.setActionCommand("NOM");
		getContentPane().add(m_nom);
		m_nom.setColumns(10);

		m_nom.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				changed();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				changed();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				changed();
			}
		});

		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setBounds(12, 104, 56, 16);
		getContentPane().add(lblNumero);

		m_numero = new JTextField();
		m_numero.setColumns(10);
		m_numero.addActionListener(this);
		m_numero.setActionCommand("NUMERO");
		m_numero.setBounds(80, 101, 116, 22);
		getContentPane().add(m_numero);

		m_numero.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				changed();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				changed();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				changed();
			}
		});

		JLabel lblDateDeNaissance = new JLabel("Date de Naissance");
		lblDateDeNaissance.setBounds(12, 147, 132, 16);
		getContentPane().add(lblDateDeNaissance);
		
		JLabel labelDate = new JLabel("");
		labelDate.setBounds(140, 147, 56, 16);
		getContentPane().add(labelDate);
		labelDate.setText("ma date de naissance");

		p_documents = new JTextArea();
		p_documents.setBounds(12, 246, 201, 209);
		getContentPane().add(p_documents);

		p_doc = new JTextArea();
		p_doc.setBounds(272, 246, 176, 209);
		getContentPane().add(p_doc);

		lblDocuments = new JLabel("Documents");
		lblDocuments.setBounds(12, 231, 79, 16);
		getContentPane().add(lblDocuments);

		lblDocument = new JLabel("Document");
		lblDocument.setBounds(272, 231, 69, 16);
		getContentPane().add(lblDocument);

		p_Evenement = new JTextArea();
		p_Evenement.setBounds(258, 31, 310, 123);
		getContentPane().add(p_Evenement);

		JLabel lblEvenements = new JLabel("Evenements");
		lblEvenements.setBounds(258, 13, 83, 16);
		getContentPane().add(lblEvenements);

		// bouton Chercher
		btnChercher = new JButton("Chercher");
		btnChercher.setActionCommand(CHERCHER);
		btnChercher.setEnabled(false);
		btnChercher.addActionListener(this);
		btnChercher.setBounds(659, 33, 97, 25);
		getContentPane().add(btnChercher);

		// bouton Charger
		btnCharger = new JButton("Charger");
		btnCharger.setBounds(659, 210, 97, 25);
		btnCharger.setEnabled(false);
		btnCharger.addActionListener(this);
		btnCharger.setActionCommand(CHARGER);
		getContentPane().add(btnCharger);

		// bouton Ajouter
		btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(659, 276, 97, 25);
		btnAjouter.setEnabled(false);
		btnAjouter.addActionListener(this);
		btnAjouter.setActionCommand(AJOUTER);
		getContentPane().add(btnAjouter);

		// Bouton OK
		btnOk = new JButton("OK");
		btnOk.setBounds(659, 333, 97, 25);
		btnOk.setEnabled(false);
		btnOk.addActionListener(this);
		btnOk.setActionCommand(OK);
		getContentPane().add(btnOk);

		// bouton Quitter
		btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(659, 407, 97, 25);
		btnQuitter.setEnabled(true);
		btnQuitter.addActionListener(this);
		btnQuitter.setActionCommand(QUITTER);
		getContentPane().add(btnQuitter);

		// position de la personne
		JLabel lblPosition = new JLabel("Position");
		lblPosition.setBounds(460, 305, 56, 16);
		getContentPane().add(lblPosition);

		m_position = new JTextField();
		m_position.setBounds(460, 334, 116, 22);
		m_position.setEditable(false);
		getContentPane().add(m_position);
		m_position.setColumns(10);

		// numero de la personne
		JLabel lblNoDePersonne = new JLabel("No de personne");
		lblNoDePersonne.setBounds(460, 369, 116, 16);
		getContentPane().add(lblNoDePersonne);

		m_noPersonne = new JTextField();
		m_noPersonne.setBounds(460, 408, 116, 22);
		m_noPersonne.setEditable(false);
		getContentPane().add(m_noPersonne);
		m_noPersonne.setColumns(10);
		
		
		
	}

	void afficherEvenementPersonne(Resultat resultat) {

		// s'il y a juste une personne trouvée
		if (resultat == null)
			System.out.println("Resultat est null");
		if (resultat.listeDesPersonnes == null)
			System.out.println("C'Est liste qui est null");
		if(resultat.listeDesPersonnes.isEmpty())
		{
			p_Evenement.setText("Aucune personne trouvées :(");
			 p_documents.setText("Aucune personne trouvées :(");
		}
		else if (resultat.listeDesPersonnes.size() == 1) {
			if(lblDocuments.getText().equalsIgnoreCase("Documents"))
				changerLabelDocument();
			for (Personne personne : resultat.listeDesPersonnes) {
				for (Evenement evenement : personne.m_listeEvenements) {

					p_Evenement.setText(evenement.m_date + ":"
							+ evenement.m_type + ":" + evenement.m_lieu);
					
				}
				for (Document document : personne.m_listeDocuments){
					 p_documents.setText(document.m_numeroDoc +":" + document.m_titre);
				}
			}
			

		}
		else
		{
			//changer le label Document par Personne
			changerLabelDocument();
			//Populer la liste trouvée
			for(Personne personne : resultat.listeDesPersonnes)
			{
				p_documents.setText(personne.m_nom+", "+personne.m_dateNaissance+", "+personne.m_numero);
			}
			
			//activer le bouton Charger
			activerBouton(btnCharger);
		}
	}

	
	void ChagerDocumentsPersonne(Resultat resultat) {

	}
	
	//changer le label de Documents
	void changerLabelDocument()
	{
		lblDocuments.setText("Personnes");
	}
	
	//activer un bouton 
	public void activerBouton(JButton bouton)
	{
		bouton.setEnabled(true);
	}
	
	public void desactierBouton(JButton bouton)
	{
		bouton.setEnabled(false);
	}
	
	public void changed() {
		if (m_prenom.getText().equals("")
				&& (m_nom.getText().equals("") && m_numero.getText().equals("")))
			desactierBouton(btnChercher);
		else
			activerBouton(btnChercher);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equals(CHERCHER)) {
			m_resultat = m_execution.recherche(m_numero.getText(), m_prenom.getText(), m_nom.getText());
			afficherEvenementPersonne(m_resultat);
		} else if (command.equals(CHARGER)) {
			// TODO
		} else if (command.equals(AJOUTER)) {
			// TODO
		} else if (command.equals(OK)) {
			// TODO
		} else if (command.equals(QUITTER)) {
			System.exit(0);
		}

	}
}
