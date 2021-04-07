package main;

import modelo.Acoes;
import modelo.BasicKeys;
import modelo.Wait;
import utils.FileManager;

public class DecorationsBuilderMain {
	public static void main(String[] args) {
		FileManager.runAhkScript();
		Wait.milliseconds(2000);
		new BasicKeys().scrollLock();
		new Acoes().iniciarPrograma();
		// DBManager dbm = new DBManager();
		// dbm.bgetDBCollection();

	}

}
