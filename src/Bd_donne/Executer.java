package Bd_donne;

import java.sql.*;

public class Executer {
	
	Statement stmt;

	public ResultSet recherchePrNumero(int  numero) throws SQLException
	{
		String requete_sql="Select * from bidon ";//vous devez créer une table bidon dans votr compte
		
	   //les requêtes SQL DML qui retournent des données
	  ResultSet rs = stmt.executeQuery (requete_sql);
	  //Obtention des méta-données de la table
	  //Soit nom et type des colonnes
	  //Le nombre de colonnes
	return rs;
  		
	}
	
}
