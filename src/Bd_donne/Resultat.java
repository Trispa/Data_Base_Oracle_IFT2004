package Bd_donne;

import java.util.ArrayList;
import java.util.HashMap;

public class Resultat {
	public ArrayList<Personne> listeDesPersonnes = new ArrayList<Personne>();
	public Resultat()
	{
		
	}
	public class Personne{
		
		public String m_numero;
		public String m_nom;
		public String m_prenom;
		public ArrayList<Evenement> m_listeEvenements;
		public ArrayList<Document> m_listeDocuments;
	
		public Personne(String numero, String nom, String prenom)
		{
			m_numero = numero;
			m_nom = nom;
			m_prenom = prenom;
		}
	
	}
	
	public class Evenement{
		public String m_date;
		public String m_type;
		public String m_lieu;
		
		public Evenement(String type, String lieu, String date)
		{
			m_date = date;
			m_type = type;
			m_lieu = lieu;
		}
		
	}
	
	public class Document{
		public String m_type;
		public String m_titre;
		public String m_date;
		public String m_auteur;
		public HashMap<String, Personne> m_mapPositionPersonne;
	}
	
	
}
