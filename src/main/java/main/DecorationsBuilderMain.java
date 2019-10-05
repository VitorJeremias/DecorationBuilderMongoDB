package main;

import java.awt.AWTException;
import java.net.UnknownHostException;

import database.DBManager;
import modelo.Acoes;
import utils.Utils;

public class DecorationsBuilderMain {
	public static void main(String[] args) throws UnknownHostException, AWTException {
		Utils.wait(1000);
		Acoes acoes = new Acoes();
		acoes.iniciarPrograma();
		//DBManager dbm = new DBManager();
		//dbm.getDBCollection();
	
	}

}
