package controller;

import java.sql.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.MySql;


public class Traitement{


public Traitement(){
	
	MySql bdd = new MySql("root","nicolas","jdbc:mysql://localhost:3306/test");
	bdd.connecte();
	bdd.modification(51,"cyril");
	bdd.lire();
	bdd.delete();
	//bdd.lire();
	
}


}