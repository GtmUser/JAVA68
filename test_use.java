import java.io.*;

public class test_use {


	public static void main(String[] args) {
		fenetre maFen = null;
	    try {
	        FileInputStream fichier = new FileInputStream("fenetre.ser");
	        ObjectInputStream ois = new ObjectInputStream(fichier);
	        maFen = (fenetre) ois.readObject();
	        ois.close();
	       // if (maFen.isVisible()){ System.out.println("fenetre visible");}
	        maFen.setVisible(true);
	    } 
	      catch (IOException e) {
	        e.printStackTrace();
	      }
	      catch (ClassNotFoundException e) {
	        e.printStackTrace();
	      }
	}

}
