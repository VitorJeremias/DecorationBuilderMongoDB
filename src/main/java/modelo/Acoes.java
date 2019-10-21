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
	Images images = new Images();

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
	public static int totalRewards = 0;
	public static String plantaRewardRatio;
	public static String pfRewardRatio;
	public static String aiDataRewardRatio;
	public static String bioplasticoRewardRatio;
	public static String nanofioRewardRatio;
	public static String bateriaRewardRatio;
	public static String gasolinaRewardRatio;
	public static String medalRewardRatio;
	public static String coinRewardRatio;
	public static String supplyRewardRatio;
	public static boolean questDone = false;

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
		totalRewards = plantaReward + pfReward + aiDataReward + bioplasticoReward + nanofioReward + bateriaReward
				+ gasolinaReward + medalReward + coinReward + supplyReward;
		// for (int i = 0; i < quantidades.size(); i++) {
		// totalRewards = totalRewards + quantidades.get(i);
		// }
		plantaRewardRatio = String.format("%.02f", 100 * (double) plantaReward / (double) totalRewards);
		pfRewardRatio = String.format("%.02f", 100 * (double) pfReward / (double) totalRewards);
		aiDataRewardRatio = String.format("%.02f", 100 * (double) aiDataReward / (double) totalRewards);
		bioplasticoRewardRatio = String.format("%.02f", 100 * (double) bioplasticoReward / (double) totalRewards);
		nanofioRewardRatio = String.format("%.02f", 100 * (double) nanofioReward / (double) totalRewards);
		bateriaRewardRatio = String.format("%.02f", 100 * (double) bateriaReward / (double) totalRewards);
		gasolinaRewardRatio = String.format("%.02f", 100 * (double) gasolinaReward / (double) totalRewards);
		medalRewardRatio = String.format("%.02f", 100 * (double) medalReward / (double) totalRewards);
		coinRewardRatio = String.format("%.02f", 100 * (double) coinReward / (double) totalRewards);
		supplyRewardRatio = String.format("%.02f", 100 * (double) supplyReward / (double) totalRewards);

	}

	public void iniciarPrograma() throws AWTException, UnknownHostException {
		for (int i = 0; i < REPETICOES; i++) {
			questDone = false;
			System.out.println("######################## ITERAÇÃO " + (i + 1) + " ########################");
			deletarDecoracoes();
			colocarDecoracoes();
			while (!questDone) {
				questDone = verificaSeQuestDone();
			}
			menuQuests();
			Utils.wait(100);
			checkReward();
			coletarRecompensa();
			dbm.updateData();
			verificaSeQuestDone();
			verificaSeQuestEhDecoracoes();
			menuQuests();
		}
	}

	public boolean verificaSeQuestDone() {
		ImageManager im = new ImageManager();
		boolean foundQuestDone = im
				.isOnScreen("C:\\Users\\Vitor\\eclipse-workspace\\DecorationBuilderMongoDB\\resources\\questDone.png");
		return foundQuestDone;
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
		boolean questCerta = im
				.isOnScreen("C:\\Users\\Vitor\\eclipse-workspace\\DecorationBuilderMongoDB\\resources\\quest.png");
		int jumps = 0;
		int iterations = 0;
		while (!questCerta) {
			Utils.wait(4500 / (SPEED_MULTIPLIER));
			questCerta = im
					.isOnScreen("C:\\Users\\Vitor\\eclipse-workspace\\DecorationBuilderMongoDB\\resources\\quest.png");
			if (!questCerta) {
				BasicKeys.dois();
				BasicKeys.tres();
				jumps++;
				System.out.println("Pulou " + jumps);
				if (jumps > 90) {
					resetQuestCheck();
					jumps = 0;
					checkReward();
					if (iterations > 2) {
						deletarDecoracoes();
						colocarDecoracoes();
						Utils.wait(2000);
						iterations = 0;
						for (int i = 0; i < 4; i++) {
							InputManager.zoomOut();
						}
					}
				}
			}
			iterations++;
		}
		Utils.wait(2000);
	}

	public void resetQuestCheck() {
		System.err.println(new Object() {
		}.getClass().getEnclosingMethod().getName());
		menuQuests();
		Utils.wait(2000);
		menuQuests();
		Utils.wait(2000);
		coletarRecompensa();
	}

	public void checkRewardAIData() {
		if (images.hasImage("AIData")) {
			aiDataReward++;
			System.err.println("REWARD: AI DATA");
		}
	}

	public void checkRewardMedal() {
		if (images.hasImage("medal")) {
			medalReward++;
			System.err.println("REWARD: MEDAL");
		}
	}

	public void checkRewardPlanta() {
		if (images.hasImage("planta")) {
			plantaReward++;
			System.err.println("REWARD: PLANTA");
		}
	}

	public void checkRewardNanofio() {
		if (images.hasImage("nanofio")) {
			nanofioReward++;
			System.err.println("REWARD: NANOFIO");
		}
	}

	public void checkRewardCoin() {
		if (images.hasImage("coin")) {
			coinReward++;
			System.err.println("REWARD: COIN");
		}
	}

	public void checkRewardBateria() {
		if (images.hasImage("bateria")) {
			bateriaReward++;
			System.err.println("REWARD: BATERIA");
		}
	}

	public void checkRewardSupply() {
		if (images.hasImage("supply")) {
			supplyReward++;
			System.err.println("REWARD: SUPPLY");
		}
	}

	public void checkRewardBioplastico() {
		if (images.hasImage("bioplastico")) {
			bioplasticoReward++;
			System.err.println("REWARD: BIOPLÁSTICO");
		}
	}

	public void checkRewardPF() {
		if (images.hasImage("pf")) {
			pfReward++;
			System.err.println("REWARD: PF");
		}
	}

	public void checkRewardGasolina() {
		if (images.hasImage("gasolina")) {
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
		System.out.println("Planta: " + plantaReward + " (" + plantaRewardRatio + "%)");
		System.out.println("PF: " + pfReward + " (" + pfRewardRatio + "%)");
		System.out.println("AIData: " + aiDataReward + " (" + aiDataRewardRatio + "%)");
		System.out.println("Bioplastico: " + bioplasticoReward + " (" + bioplasticoRewardRatio + "%)");
		System.out.println("Nanofio: " + nanofioReward + " (" + nanofioRewardRatio + "%)");
		System.out.println("Bateria: " + bateriaReward + " (" + bateriaRewardRatio + "%)");
		System.out.println("Gasolina: " + gasolinaReward + " (" + gasolinaRewardRatio + "%)");
		System.out.println("Medal: " + medalReward + " (" + medalRewardRatio + "%)");
		System.out.println("Coin: " + coinReward + " (" + coinRewardRatio + "%)");
		System.out.println("Suppy: " + supplyReward + " (" + supplyRewardRatio + "%)");
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
