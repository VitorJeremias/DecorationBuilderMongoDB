package modelo;

import java.awt.AWTException;
import java.net.UnknownHostException;
import java.util.List;

import database.DBManager;
import utils.Utils;

public class Acoes {
	public final Integer REPETICOES = 1000;
	public static final Integer SPEED_MULTIPLIER = 4;
	DBManager dbm = new DBManager();

	public static int plantaReward = 0;
	public static int pfReward = 0;
	public static int aiDataReward = 0;
	public static int bioplasticoReward = 0;
	public static int nanofioReward = 0;
	public static int bateriaReward = 0;
	public static int gasolinaReward = 0;
	public static int medalReward = 0;
	public static int coinReward = 0;
	public static int supplyReward = 0;

	public Acoes() throws UnknownHostException {
		List<Integer> quantidades = dbm.getQuantidades();
		plantaReward = quantidades.get(0);
		pfReward = quantidades.get(1);
		aiDataReward = quantidades.get(2);
		bioplasticoReward = quantidades.get(3);
		nanofioReward = quantidades.get(4);
		bateriaReward = quantidades.get(5);
		gasolinaReward = quantidades.get(6);
		medalReward = quantidades.get(7);
		coinReward = quantidades.get(8);
		supplyReward = quantidades.get(9);
	}

	public void iniciarPrograma() throws AWTException, UnknownHostException {
		for (int i = 0; i < REPETICOES; i++) {
			System.out.println("######################## ITERAÇÃO " + (i + 1) + " ########################");
			deletarDecoracoes();
			colocarDecoracoes();
			Utils.wait(2000);
			menuQuests();
			Utils.wait(100);
			checkReward();
			Utils.wait(100);
			coletarRecompensa();
			dbm.updateData();
			verificaSeQuestEhDecoracoes();
			menuQuests();
		}
	}

	public void coletarRecompensa() {
		System.err.println(new Object() {
		}.getClass().getEnclosingMethod().getName());
		BasicKeys.um();
	}

	public void menuQuests() {
		System.err.println(new Object() {
		}.getClass().getEnclosingMethod().getName());
		BasicKeys.q();
	}

	public void colocarDecoracoes() {
		System.err.println(new Object() {
		}.getClass().getEnclosingMethod().getName());
		BasicKeys.umNumerico();
		BasicKeys.doisNumerico();
		BasicKeys.umNumerico();
		BasicKeys.tresNumerico();
		BasicKeys.umNumerico();
		BasicKeys.quatroNumerico();
		BasicKeys.umNumerico();
		BasicKeys.cincoNumerico();
		BasicKeys.umNumerico();
		BasicKeys.seisNumerico();
		BasicKeys.umNumerico();
		BasicKeys.seteNumerico();
		BasicKeys.umNumerico();
		BasicKeys.oitoNumerico();
		BasicKeys.umNumerico();
		BasicKeys.noveNumerico();
	}

	public void deletarDecoracoes() {
		System.err.println(new Object() {
		}.getClass().getEnclosingMethod().getName());
		BasicKeys.maisNumerico();
		BasicKeys.doisNumerico();
		BasicKeys.zeroNumerico();
		BasicKeys.tresNumerico();
		BasicKeys.zeroNumerico();
		BasicKeys.quatroNumerico();
		BasicKeys.zeroNumerico();
		BasicKeys.cincoNumerico();
		BasicKeys.zeroNumerico();
		BasicKeys.seisNumerico();
		BasicKeys.zeroNumerico();
		BasicKeys.seteNumerico();
		BasicKeys.zeroNumerico();
		BasicKeys.oitoNumerico();
		BasicKeys.zeroNumerico();
		BasicKeys.noveNumerico();
		BasicKeys.zeroNumerico();
	}

	public void verificaSeQuestEhDecoracoes() {
		ImageManager im = new ImageManager();
		boolean questCerta = im.isOnScreen("C:\\Users\\Vitor\\Downloads\\foe\\quest.png");
		int jumps = 0;
		while (!questCerta) {
			Utils.wait(4500 / (SPEED_MULTIPLIER));
			questCerta = im.isOnScreen("C:\\Users\\Vitor\\Downloads\\foe\\quest.png");
			if (!questCerta) {
				BasicKeys.dois();
				BasicKeys.tres();
				jumps++;
				System.out.println("Pulou " + jumps);
			}
		}
		Utils.wait(2000);
	}

	public void checkRewardAIData() {
		ImageManager im = new ImageManager();
		if (im.isOnScreen("C:\\Users\\Vitor\\Downloads\\foe\\AIData.png")) {
			aiDataReward++;
			System.err.println("REWARD: AI DATA");
		}
	}

	public void checkRewardMedal() {
		ImageManager im = new ImageManager();
		if (im.isOnScreen("C:\\Users\\Vitor\\Downloads\\foe\\medal.png")) {
			medalReward++;
			System.err.println("REWARD: MEDAL");
		}
	}

	public void checkRewardPlanta() {
		ImageManager im = new ImageManager();
		if (im.isOnScreen("C:\\Users\\Vitor\\Downloads\\foe\\planta.png")) {
			plantaReward++;
			System.err.println("REWARD: PLANTA");
		}
	}

	public void checkRewardNanofio() {
		ImageManager im = new ImageManager();
		if (im.isOnScreen("C:\\Users\\Vitor\\Downloads\\foe\\nanofio.png")) {
			nanofioReward++;
			System.err.println("REWARD: NANOFIO");
		}
	}

	public void checkRewardCoin() {
		ImageManager im = new ImageManager();
		if (im.isOnScreen("C:\\Users\\Vitor\\Downloads\\foe\\coin.png")) {
			coinReward++;
			System.err.println("REWARD: COIN");
		}
	}

	public void checkRewardBateria() {
		ImageManager im = new ImageManager();
		if (im.isOnScreen("C:\\Users\\Vitor\\Downloads\\foe\\bateria.png")) {
			bateriaReward++;
			System.err.println("REWARD: BATERIA");
		}
	}

	public void checkRewardSupply() {
		ImageManager im = new ImageManager();
		if (im.isOnScreen("C:\\Users\\Vitor\\Downloads\\foe\\supply.png")) {
			supplyReward++;
			System.err.println("REWARD: SUPPLY");
		}
	}

	public void checkRewardBioplastico() {
		ImageManager im = new ImageManager();
		if (im.isOnScreen("C:\\Users\\Vitor\\Downloads\\foe\\bioplastico.png")) {
			bioplasticoReward++;
			System.err.println("REWARD: BIOPLÁSTICO");
		}
	}

	public void checkRewardPF() {
		ImageManager im = new ImageManager();
		if (im.isOnScreen("C:\\Users\\Vitor\\Downloads\\foe\\pf.png")) {
			pfReward++;
			System.err.println("REWARD: PF");
		}
	}

	public void checkRewardGasolina() {
		ImageManager im = new ImageManager();
		if (im.isOnScreen("C:\\Users\\Vitor\\Downloads\\foe\\gasolina.png")) {
			gasolinaReward++;
			System.err.println("REWARD: GASOLINA");
		}
	}

	public void checkReward() {
		checkRewardPlanta();
		checkRewardPF();
		checkRewardAIData();
		checkRewardBioplastico();
		checkRewardNanofio();
		checkRewardBateria();
		checkRewardGasolina();
		checkRewardMedal();
		checkRewardCoin();
		checkRewardSupply();
		showCurrentRewards();
	}

	public void showCurrentRewards() {
		System.out.println("Planta: " + plantaReward);
		System.out.println("PF: " + pfReward);
		System.out.println("AIData: " + aiDataReward);
		System.out.println("Bioplastico: " + bioplasticoReward);
		System.out.println("Nanofio: " + nanofioReward);
		System.out.println("Bateria: " + bateriaReward);
		System.out.println("Gasolina: " + gasolinaReward);
		System.out.println("Medal: " + medalReward);
		System.out.println("Coin: " + coinReward);
		System.out.println("Suppy: " + supplyReward);
	}

	public static int getPlantaReward() {
		return plantaReward;
	}

	public static void setPlantaReward(int plantaReward) {
		Acoes.plantaReward = plantaReward;
	}

	public static int getPfReward() {
		return pfReward;
	}

	public static void setPfReward(int pfReward) {
		Acoes.pfReward = pfReward;
	}

	public static int getAiDataReward() {
		return aiDataReward;
	}

	public static void setAiDataReward(int aiDataReward) {
		Acoes.aiDataReward = aiDataReward;
	}

	public static int getBioplasticoReward() {
		return bioplasticoReward;
	}

	public static void setBioplasticoReward(int bioplasticoReward) {
		Acoes.bioplasticoReward = bioplasticoReward;
	}

	public static int getNanofioReward() {
		return nanofioReward;
	}

	public static void setNanofioReward(int nanofioReward) {
		Acoes.nanofioReward = nanofioReward;
	}

	public static int getBateriaReward() {
		return bateriaReward;
	}

	public static void setBateriaReward(int bateriaReward) {
		Acoes.bateriaReward = bateriaReward;
	}

	public static int getGasolinaReward() {
		return gasolinaReward;
	}

	public static void setGasolinaReward(int gasolinaReward) {
		Acoes.gasolinaReward = gasolinaReward;
	}

	public static int getMedalReward() {
		return medalReward;
	}

	public static void setMedalReward(int medalReward) {
		Acoes.medalReward = medalReward;
	}

	public static int getCoinReward() {
		return coinReward;
	}

	public static void setCoinReward(int coinReward) {
		Acoes.coinReward = coinReward;
	}

	public static int getSupplyReward() {
		return supplyReward;
	}

	public static void setSupplyReward(int supplyReward) {
		Acoes.supplyReward = supplyReward;
	}
}
