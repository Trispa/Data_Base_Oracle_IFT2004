package Bd_donne;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Bd_donne.Resultat.Document;
import Bd_donne.Resultat.Personne;

public class Executer {

	private static Statement m_executeur;

	public Executer(Statement executeur) {
		m_executeur = executeur;

	}

	public ResultSet executeQuery(String requete) throws SQLException {
		return m_executeur.executeQuery(requete);
	}

	public ResultSet reqPersonnes(String p_numero, String p_prenom, String p_nom)
			throws SQLException {
		String condition = "where";
		if (!p_numero.equals("")) {
			condition += condition != "where" ? " and" : "";
			condition += " NO_PERSONNE = " + p_numero;
		} else {
			if (!p_prenom.equals("")) {
				condition += condition != "where" ? " and" : "";
				condition += " PRENOM_PER like " + "'%" + p_prenom + "%'";
			}
			if (!p_nom.equals("")) {
				condition += condition != "where" ? " and" : "";
				condition += " NOM_PER like " + "'%" + p_nom + "%'";
			}
		}

		String requete_sql = "Select NO_PERSONNE, NOM_PER, PRENOM_PER, to_char(DATE_NAISSANCE_PER, 'yyyy/mm/dd') from PERSONNE "
				+ condition;
		System.out.println(requete_sql);
		return executeQuery(requete_sql);
	}

	public ResultSet reqEvenement(String p_numero) throws SQLException {
		return executeQuery("Select TYPE_EVENEMENT_GEN, LIEU_EVENEMENT_GEN, to_char(DATE_EVENEMENT_GEN, 'yyyy/mm/dd') from GENEALOGIE, GENEALOGIE_ACTEURS "
				+ "where GENEALOGIE.NO_PERSONNE ='"
				+ p_numero
				+ "' or (GENEALOGIE.NO_GENEALOGIE = GENEALOGIE_ACTEURS.NO_GENEALOGIE and GENEALOGIE_ACTEURS.NO_PERSONNE='"
				+ p_numero + "')");
	}

	public ResultSet reqDocuments(String p_numero) throws SQLException {
		return executeQuery("Select DOCUMENTS.NO_DOC,TYPE_DOC,TITRE_DOC, to_char(DATE_PUBLICATION_DOC, 'yyyy/mm/dd'), AUTEUR_DOC from DOCUMENTS, DOCUMENT_ACTEURS "
				+ "where DOCUMENTS.NO_DOC = DOCUMENT_ACTEURS.NO_DOC and DOCUMENT_ACTEURS.NO_PERSONNE = '"
				+ p_numero + "'");
	}

	public ResultSet reqPersonneDansDocuments(String p_numero)
			throws SQLException {
		
		return executeQuery("Select POSITION_DOC_AC, PRENOM_PER, NOM_PER from PERSONNE, DOCUMENT_ACTEURS "
				+ "where DOCUMENT_ACTEURS.NO_PERSONNE = PERSONNE.NO_PERSONNE and DOCUMENT_ACTEURS.NO_DOC = '"
				+ p_numero + "'");
	}

	public Resultat recherche(String p_numero, String p_prenom, String p_nom) {
		Resultat resultats = new Resultat();
		boolean more;
		try {
			int i = 0;
			java.sql.ResultSet rs = reqPersonnes(p_numero, p_prenom, p_nom);
			System.out.println("Execute reqPersonnes");
			more = rs.next();
			
			while (more) {
				System.out.println("Personne numero: "+ Integer.toString(++i));
				Resultat.Personne unePersonne = new Resultat.Personne(
						rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4));
				resultats.listeDesPersonnes.add(unePersonne);
				more = rs.next();
			}
			
			for(Personne unePersonne: resultats.listeDesPersonnes)
			{
				rs = reqEvenement(unePersonne.m_numero);
				more = rs.next();
				while (more) {
					Resultat.Evenement unEvent = new Resultat.Evenement(
							rs.getString(1), rs.getString(2),
							rs.getString(3));
					unePersonne.m_listeEvenements.add(unEvent);
					more = rs.next();
				}
				
				rs = reqDocuments(unePersonne.m_numero);
				more = rs.next();
				while (more) {
					
					Resultat.Document unDocument = new Resultat.Document(
							rs.getString(1), rs.getString(2),
							rs.getString(3), rs.getString(4),
							rs.getString(5));
					unePersonne.m_listeDocuments.add(unDocument);
					more = rs.next();
				}
				for(Document unDocument: unePersonne.m_listeDocuments)
				{
					rs = reqPersonneDansDocuments(unDocument.m_numeroDoc);
					more = rs.next();
					while (more) {
						unDocument.m_mapPositionPersonne.put(rs.getString(1),
								rs.getString(2) + " " + rs.getString(3));
						more = rs.next();
					}
					
				}
			
			}

			return resultats;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new Resultat();
		}

	}

	public ResultSet recherchePrNumero(int parseInt) {
		// TODO Auto-generated method stub
		return null;
	}
}
