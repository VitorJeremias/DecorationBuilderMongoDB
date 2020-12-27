package main;

import java.awt.AWTException;
import java.net.UnknownHostException;

import modelo.Acoes;

public class DecorationsBuilderMain {
	public static void main(String[] args) throws UnknownHostException, AWTException, InterruptedException {
		Acoes acoes = new Acoes();
		Thread.sleep(2000);
		acoes.iniciarPrograma();
		// DBManager dbm = new DBManager();
		// dbm.bgetDBCollection();

	}

}
