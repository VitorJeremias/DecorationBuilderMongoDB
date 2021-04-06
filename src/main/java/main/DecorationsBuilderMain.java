package main;

import modelo.Acoes;
import modelo.BasicKeys;
import modelo.Wait;
import utils.FileManager;

public class DecorationsBuilderMain {
	public static void main(String[] args) {
		FileManager.runAhkScript();
		Acoes acoes = new Acoes();
		Wait.milliseconds(2000);
		BasicKeys.scrollLock();
		acoes.iniciarPrograma();
		// DBManager dbm = new DBManager();
		// dbm.bgetDBCollection();

	}

}
