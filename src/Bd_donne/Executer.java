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
}
