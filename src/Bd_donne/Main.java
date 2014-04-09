package Bd_donne;



import InterfaceGraphique.Interface;


public class Main {
	/**
	 * @param args
	 */

	public static void main(String[] args)  {
	try{ 
		Interface mon_Interface = new Interface();
		mon_Interface.setVisible(true);
	}catch (Exception e) {
				e.printStackTrace();
			}
		
	}

}
