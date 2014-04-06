package InterfaceGraphique;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;



public class Interface extends JFrame{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	
	public Interface() {
		getContentPane().setLayout(null);
		
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
		
		textField = new JTextField();
		textField.setBounds(80, 34, 116, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(80, 63, 116, 22);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(80, 101, 116, 22);
		getContentPane().add(textField_2);
		
		JTextArea txtrDocument = new JTextArea();
		txtrDocument.setBounds(12, 246, 201, 209);
		getContentPane().add(txtrDocument);
		
		JTextArea txtrDocument_1 = new JTextArea();
		txtrDocument_1.setBounds(272, 246, 176, 209);
		getContentPane().add(txtrDocument_1);
		
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
		
		JButton btnChercher = new JButton("Chercher");
		btnChercher.setBounds(659, 33, 97, 25);
		getContentPane().add(btnChercher);
		
		JButton btnCharger = new JButton("Charger");
		btnCharger.setBounds(659, 210, 97, 25);
		getContentPane().add(btnCharger);
		
		JButton btnOk = new JButton("Ajouter");
		btnOk.setBounds(659, 276, 97, 25);
		getContentPane().add(btnOk);
		
		JButton btnOk_1 = new JButton("OK");
		btnOk_1.setBounds(659, 333, 97, 25);
		getContentPane().add(btnOk_1);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(659, 407, 97, 25);
		getContentPane().add(btnQuitter);
		
		JLabel lblPosition = new JLabel("Position");
		lblPosition.setBounds(460, 305, 56, 16);
		getContentPane().add(lblPosition);
		
		textField_3 = new JTextField();
		textField_3.setBounds(460, 334, 116, 22);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNoDePersonne = new JLabel("No de personne");
		lblNoDePersonne.setBounds(460, 369, 116, 16);
		getContentPane().add(lblNoDePersonne);
		
		textField_4 = new JTextField();
		textField_4.setBounds(460, 408, 116, 22);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
	}

	
	
	}

