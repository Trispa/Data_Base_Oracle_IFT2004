package Bd_donne;

import java.sql.*;

public class Executer {
	
	Statement stmt;

	public ResultSet recherchePrNumero(int  numero) throws SQLException
	{
		String requete_sql="Select * from bidon ";//vous devez cr�er une table bidon dans votr compte
		
	   //les requ�tes SQL DML qui retournent des donn�es
	  ResultSet rs = stmt.executeQuery (requete_sql);
	  //Obtention des m�ta-donn�es de la table
	  //Soit nom et type des colonnes
	  //Le nombre de colonnes
	return rs;
  		
	}
	
}
