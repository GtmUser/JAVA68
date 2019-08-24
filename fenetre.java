import java.awt.*;
import java.io.*;
import java.awt.event.*;

public class fenetre extends Frame implements Serializable,ActionListener {
	
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource()==btn_ok){
		etiq.setText(zone.getText().toString());		
		} else {
			enregistre();
		}
	}

	Button btn_ok = new Button("ok");
	Button btn_enreg = new Button("enregistre");
	Label etiq = new Label("");
	TextArea zone = new TextArea("");
	Button autre = new Button("autre");
	
	
	public fenetre(String titre){
		super(titre);
		System.out.println("je suis dans le constructeur");
		//this.setTitle("fenetre enregistrable");
		this.setTitle(titre);
		this.setBounds(10,10,400,350);
		this.addWindowListener(new ttt());
		this.setLayout(null);
		btn_ok.setBounds(10,40,80,40);
		this.add(btn_ok);
		etiq.setBounds(10,140,80,40);
		etiq.setBackground(Color.YELLOW);
		this.add(etiq);
		zone.setBounds(140,40,100,50);
		this.add(zone);
		btn_ok.addActionListener(this);
		btn_enreg.setBounds(140,300,100,40);
		btn_enreg.addActionListener(this);
		this.add(btn_enreg);
		autre.setBounds(140,140, 100,32);
		this.add(autre);
		autre.addActionListener(new tttevt());
		this.setVisible(true);
	}
	
	private void enregistre(){
		  try {
		      FileOutputStream fichier = new FileOutputStream("fenetre.ser");
		      ObjectOutputStream oos = new ObjectOutputStream(fichier);
		      oos.writeObject(this);
		      oos.flush(); // obligatoire sinon il n'écrit pas de suite l'objet dans le fichier
		      oos.close(); // idem
		    }
		    catch (IOException e) {
		      e.printStackTrace();
		    }

	}
}
