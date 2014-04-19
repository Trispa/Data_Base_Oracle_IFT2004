package InterfaceGraphique;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


import Bd_donne.Executer;
import Bd_donne.Resultat;
import Bd_donne.Resultat.Document;
import Bd_donne.Resultat.Evenement;
import Bd_donne.Resultat.Personne;

import java.awt.event.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

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
	private JLabel m_dateNaissance;
	private Personne m_selectedPersonne;
	private Document m_selectedDocument;
	private boolean entrainAfficherPersonne = false;
	private JTextArea p_Evenement;
	private JList p_documents;
	private JTextArea p_doc;
	private JLabel lblDocuments;
	private JLabel lblDocument;

	private static String CHERCHER = "rechercher une Personne";
	private static String CHARGER = "Charger";
	private static String AJOUTER = "Ajouter";
	private static String ANNULER = "Annuler";
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
		lblPersonne.setBounds(12, 13, 83, 16);
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

		JLabel lblDateDeNaissance = new JLabel("Date de Naissance:");
		lblDateDeNaissance.setBounds(12, 147, 127, 16);
		getContentPane().add(lblDateDeNaissance);

		m_dateNaissance = new JLabel("");
		m_dateNaissance.setBounds(140, 147, 106, 16);
		getContentPane().add(m_dateNaissance);
		

		p_documents = new JList();
		p_documents.setBounds(12, 246, 234, 262);
		getContentPane().add(p_documents);
	
		
		p_documents.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent evt) {
				afficherSelection(evt);
				
			}
        });

		p_doc = new JTextArea();
		p_doc.setBounds(258, 246, 239, 262);
		getContentPane().add(p_doc);
		p_doc.setEditable(false);

		lblDocuments = new JLabel("Documents");
		lblDocuments.setBounds(16, 218, 79, 16);
		getContentPane().add(lblDocuments);

		lblDocument = new JLabel("Document");
		lblDocument.setBounds(258, 218, 106, 16);
		getContentPane().add(lblDocument);

		p_Evenement = new JTextArea();
		p_Evenement.setBounds(258, 31, 310, 123);
		getContentPane().add(p_Evenement);
		p_Evenement.setEditable(false);

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
		lblPosition.setBounds(520, 279, 56, 16);
		getContentPane().add(lblPosition);

		m_position = new JTextField();
		m_position.setBounds(501, 309, 116, 22);
		m_position.setEditable(false);
		getContentPane().add(m_position);
		m_position.setColumns(10);

		// numero de la personne
		JLabel lblNoDePersonne = new JLabel("No de personne");
		lblNoDePersonne.setBounds(511, 354, 116, 16);
		getContentPane().add(lblNoDePersonne);

		m_noPersonne = new JTextField();
		m_noPersonne.setBounds(501, 383, 116, 22);
		m_noPersonne.setEditable(false);
		getContentPane().add(m_noPersonne);
		m_noPersonne.setColumns(10);

	}
	void afficherNotFind()
	{
		init();
		String[] vide = {"Aucune personne trouvée"};
		p_documents.setListData(vide);
		
		
	}
	void init()
	{
		m_prenom.setText("");
		m_nom.setText("");
		m_numero.setText("");
		m_dateNaissance.setText("");
		p_Evenement.setText("");
		String[] vide = {""};
		p_documents.setListData(vide);
		p_doc.setText("");
		entrainAfficherPersonne = false;
		m_selectedPersonne = null;
		m_selectedDocument = null;
		btnCharger.setEnabled(false);
		btnAjouter.setEnabled(false);
	}
	void afficherSelection(javax.swing.event.ListSelectionEvent evt)
	{
		int index = p_documents.getSelectedIndex();
		if(index < 0)
			return;
		System.out.println("La selection est : " + index);
		System.out.println("Entrain d'afficher une personne: " + Boolean.toString(entrainAfficherPersonne));
		if(entrainAfficherPersonne)
		{
			m_selectedDocument = m_selectedPersonne.m_listeDocuments.get(index);
			btnCharger.setEnabled(true);
			btnAjouter.setEnabled(true);
		}
		else
		{
			m_selectedPersonne = m_resultat.listeDesPersonnes.get(index);
			
		}
		
	}
	void afficherListePersonnes(ArrayList<Personne> listePersonnes)
	{
		String[] vecteursDocuments = new String[listePersonnes.size()];
		for(int i = 0; i<listePersonnes.size(); i++)
		{
			vecteursDocuments[i] = listePersonnes.get(i).m_numero + ": " + listePersonnes.get(i).m_prenom + " " + listePersonnes.get(i).m_nom +
					" - " + listePersonnes.get(i).m_dateNaissance + "\n";
		}
		p_documents.setListData(vecteursDocuments);
	}
	void afficherPersonne(Personne personne)
	{
		m_selectedPersonne = personne;
		entrainAfficherPersonne = true;
		m_prenom.setText(personne.m_prenom);
		m_nom.setText(personne.m_nom);
		m_numero.setText(personne.m_numero);
		m_dateNaissance.setText(personne.m_dateNaissance);
		afficherEvenements(personne.m_listeEvenements);
		afficherListeDocuments(personne.m_listeDocuments);
	}
	void afficherEvenements(ArrayList<Evenement> listeEvenements)
	{
		if(listeEvenements.isEmpty())
		{
			System.out.println("La liste des evenements est vide");
		}
		String texteEvenement = "";
		for(Evenement event:listeEvenements)
		{
			texteEvenement += event.m_date + ": " + event.m_type + " - "+ event.m_lieu + "\n";
		}
		p_Evenement.setText(texteEvenement);
	}
	void afficherListeDocuments(ArrayList<Document> listeDocuments)
	{
		String[] vecteursDocuments = new String[listeDocuments.size()];
		for(int i = 0; i<listeDocuments.size(); i++)
		{
			vecteursDocuments[i] = listeDocuments.get(i).m_numeroDoc + ": " + listeDocuments.get(i).m_titre + "\n";
		}
		p_documents.setListData(vecteursDocuments);
	}
	void afficherDocument(Document document)
	{
		String documentTexte = "";
		documentTexte += document.m_titre + "\n";
		documentTexte += "Date: " + document.m_date + "\n";
		documentTexte += document.m_type.equals("ARTICLE")?"Auteur: " :"Photographe: ";
		documentTexte += document.m_auteur + "\n";
		for(Map.Entry<String, String> entry: document.m_mapPositionPersonne.entrySet())
		{
			documentTexte += "Position " + entry.getKey() + ": " + entry.getValue() + "\n";
		}
		
		p_doc.setText(documentTexte);
	}
	void afficherEvenementPersonne(Resultat resultat) {
		//initialiser
		init();
		
		System.out.println("on a trouvé" + resultat.listeDesPersonnes.size());
		// s'il y a juste une personne trouvÈe
		if (resultat.listeDesPersonnes == null)
			System.out.println("C'Est liste qui est null");
		if (resultat.listeDesPersonnes.isEmpty()) {
			afficherNotFind();
			
			
		} 
		
		else if (resultat.listeDesPersonnes.size() == 1) {
			
			lblDocuments.setText("Documents");
			afficherPersonne(resultat.listeDesPersonnes.get(0));
			btnCharger.setEnabled(false);
		}
		else
		{
			lblDocuments.setText("Personnes");
			afficherListePersonnes(resultat.listeDesPersonnes);
			btnCharger.setEnabled(true);
		}

	}

	void chargerDocumentsPersonne() {
		if(entrainAfficherPersonne)
		{
			afficherDocument(m_selectedDocument);
		}
		else
		{
			afficherPersonne(m_selectedPersonne);
			entrainAfficherPersonne = true;
			btnCharger.setEnabled(false);
		}

	}



	// activer un bouton
	public void activerBouton(JButton bouton) {
		bouton.setEnabled(true);
	}

	public void desactiverBouton(JButton bouton) {
		bouton.setEnabled(false);
	}
	
	public void activerEcritureChamp(JTextField text)
	{
		text.setEditable(true);
	}
	public void desactiverEcritureChamp(JTextField text)
	{
		text.setEditable(false);
	}
//	public void desactiverChamp(JTextField text)
//	{
//		text.setEnabled(false);
//	}

	public void GestionAjout()
	{
		activerBouton(btnOk);
		btnAjouter.setText("Annuler");
		btnAjouter.setActionCommand(ANNULER);
		
		desactiverBouton(btnCharger);
		desactiverBouton(btnChercher);
		desactiverBouton(btnQuitter);
		
		activerEcritureChamp(m_position);
		activerEcritureChamp(m_noPersonne);
		
		desactiverEcritureChamp(m_nom);
		desactiverEcritureChamp(m_prenom);
		desactiverEcritureChamp(m_numero);
		p_Evenement.setEnabled(false);
		p_doc.setEditable(false);
		p_documents.setEnabled(false);
	
	}
	
	public void Annuler()
	{
		desactiverBouton(btnOk);
		btnAjouter.setText("Ajouter");
		btnAjouter.setActionCommand(AJOUTER);
		
		activerBouton(btnCharger);
		activerBouton(btnChercher);
		activerBouton(btnQuitter);
		
		m_position.setText("");
		desactiverEcritureChamp(m_position);
		m_noPersonne.setText("");
		desactiverEcritureChamp(m_noPersonne);
		
		activerEcritureChamp(m_nom);
		activerEcritureChamp(m_prenom);
		activerEcritureChamp(m_numero);
		p_Evenement.setEnabled(true);
		p_doc.setEnabled(true);
		p_documents.setEnabled(true);
		
	}

	public void changed() {
		if (m_prenom.getText().equals("")
				&& (m_nom.getText().equals("") && m_numero.getText().equals("")))
			desactiverBouton(btnChercher);
		else
			activerBouton(btnChercher);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();

		if (command.equals(CHERCHER)) {
			m_resultat = m_execution.recherche(m_numero.getText(),
					m_prenom.getText(), m_nom.getText());
			afficherEvenementPersonne(m_resultat);
			
		} else if (command.equals(CHARGER)) {
			chargerDocumentsPersonne();
		} else if (command.equals(AJOUTER)) {
			GestionAjout();	
		} else if (command.equals(ANNULER)) {
			Annuler();	
		} else if (command.equals(OK)) {
			m_execution.addComentaire(m_selectedDocument.m_numeroDoc, m_selectedDocument.m_titre, m_numero.getText(),m_position.getText());
		} else if (command.equals(QUITTER)) {
			System.exit(0);
		}

	}
}
