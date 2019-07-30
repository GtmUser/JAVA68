package model;


import java.sql.*;

import model.MySql;


public class MySql {

	private String user;
	private String pwd;
	private String adresse;
	private String driver = "com.mysql.jdbc.Driver";
	private Connection cn;
	private Statement stmt;
	private String modif;
	private String creature;
	private int chiffre;
	private ResultSet rs = null;
	ResultSetMetaData rsmd = null;
	PreparedStatement pst = null;

	

	
	
	public MySql(){}
	
	public MySql(String user, String pwd, String adresse){
		this.user=user;
		this.pwd=pwd;
		this.adresse=adresse;
		
	}
	
	
	public Connection connecte(){
		try{
			Class.forName("com.mysql.jdbc.Driver");//charger driver
			cn= DriverManager.getConnection(adresse, user, pwd);
			stmt=cn.createStatement();
			

			System.out.println ("coucou!!!!");
				
		}
		catch (SQLException e){
			System.out.println ("j'ai fait un try catch qui marche:!!!!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
			System.out.println ("j'ai fait un truc!!!!");
		}
		return cn;
	}
	
	public void deconnecte(){
		if (this.cn!= null){
			try{ this.cn.close();
			
			}catch(SQLException e){}
		}		
		
	}
	
	public void modification(int chiffre, String creature){
		// mise à jour dans la base par executeUpdate(requete sql)
		this.creature=creature;
		this.chiffre=chiffre;
		System.out.println(creature);
					try {
						stmt.executeUpdate("insert into auditeurs values ("+chiffre+",'"+creature+"','Patrick','UNIGE')");
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		
	}
	
	public void lire(){
		try {
			String demande=("select * from auditeurs");
			ResultSet resultat = execSelect(demande);
			
			while (resultat.next()){
				System.out.println("nom: "+ resultat.getString(2));
			
			//rs = stmt.executeQuery("select * from auditeurs");
			//rsmd = rs.getMetaData();
			//while (rs.next()){   // balayage du ResultSet
				//for (int xx=1;xx<= rsmd.getColumnCount();xx++){					
				//System.out.println("type : "+rsmd.getColumnTypeName(xx)+"("+rsmd.getColumnDisplaySize(xx)+")"+" nom de colonne = "+ rsmd.getColumnLabel(xx)+" valeur : "+ rs.getString(xx));  // recup d'une colonne du ResultSet
			}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		public void delete(){
			try {
			String demand = ("delete from auditeurs where id=99");
			stmt.executeUpdate (demand);
			} catch (SQLException e) {
				System.out.println("pas delete");
			}
			
		}
	
	public boolean execMAJ(String requete){
		boolean reussite = false;
		try {
			this.stmt.executeUpdate(requete);
			reussite = true;
		} catch (SQLException e) {
			reussite = false;
		}
		return reussite;
	}
	
	public ResultSet execSelect(String requete){
		ResultSet rs = null;
		try {
			rs = this.stmt.executeQuery(requete);
		} catch (SQLException e) {
			System.out.println("bof");
		}
		return rs;
	}
}
