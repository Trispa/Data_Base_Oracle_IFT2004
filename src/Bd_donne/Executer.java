package Bd_donne;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Executer {
	
	private static Statement m_executeur;
	public  Executer(Statement executeur)
	{
		m_executeur = executeur;

	}
	
	public ResultSet executeQuery(String requete) throws SQLException
	{
		return m_executeur.executeQuery (requete);
	}
	public ResultSet reqPersonnes(String p_numero, String p_prenom, String p_nom) throws SQLException
	{
		String condition = "where";
		if(!p_numero.equals(""))
		{
			condition += condition != "where" ? " and":"";
			condition += " NO_PERSONNE = "+ p_numero;
		}
		else
		{
			if(!p_prenom.equals(""))
			{	condition += condition != "where" ? " and":"";
				condition += " PRENOM_PER like "+ "'%" + p_prenom + "%'";
			}
			if(!p_nom.equals(""))
			{
				condition += condition != "where" ? " and":"";
				condition += " NOM_PER like "+ "'%" + p_nom + "%'";
			}
		}
		
		String requete_sql="Select NO_PERSONNE, NOM_PER, PRENOM_PER, to_char(DATE_NAISSANCE_PER, 'yyyy/mm/dd') from PERSONNE " + condition;
		return executeQuery(requete_sql);
	}
	public ResultSet reqEvenement(String p_numero) throws SQLException
	{
		return executeQuery("");
	}
	public Resultat recherche(String p_numero, String p_prenom, String p_nom)
	{
		return new Resultat();
	}

	public ResultSet recherchePrNumero(int parseInt) {
		// TODO Auto-generated method stub
		return null;
	}
}
