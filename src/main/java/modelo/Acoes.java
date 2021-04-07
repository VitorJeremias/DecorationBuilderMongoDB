package modelo;

import utils.Utils;

public class Acoes {
	private final Integer REPETICOES = 10000;
	public static final Integer SPEED_MULTIPLIER = 4;
	// DBManager dbm = new DBManager();
	private Images images = new Images();

	private static int plantaReward = 0;
	private static int pfReward = 0;
	private static int aiDataReward = 0;
	private static int bioplasticoReward = 0;
	private static int nanofioReward = 0;
	private static int bateriaReward = 0;
	private static int gasolinaReward = 0;
	private static int medalReward = 0;
	private static int coinReward = 0;
	private static int supplyReward = 0;
	private static int totalRewards = 0;
	private static String plantaRewardRatio;
	private static String pfRewardRatio;
	private static String aiDataRewardRatio;
	private static String bioplasticoRewardRatio;
	private static String nanofioRewardRatio;
	private static String bateriaRewardRatio;
	private static String gasolinaRewardRatio;
	private static String medalRewardRatio;
	private static String coinRewardRatio;
	private static String supplyRewardRatio;
	private static boolean questDone = false;

	public Acoes() {
		// List<Integer> quantidades = dbm.getQuantidades();
		// plantaReward = quantidades.get(0);
		// pfReward = quantidades.get(1);
		// aiDataReward = quantidades.get(2);
		// bioplasticoReward = quantidades.get(3);
		// nanofioReward = quantidades.get(4);
		// bateriaReward = quantidades.get(5);
		// gasolinaReward = quantidades.get(6);
		// medalReward = quantidades.get(7);
		// coinReward = quantidades.get(8);
		// supplyReward = quantidades.get(9);
		// totalRewards = plantaReward + pfReward + aiDataReward + bioplasticoReward + nanofioReward + bateriaReward
		// + gasolinaReward + medalReward + coinReward + supplyReward;
		// plantaRewardRatio = String.format("%.02f", 100 * (double) plantaReward / (double) totalRewards);
		// pfRewardRatio = String.format("%.02f", 100 * (double) pfReward / (double) totalRewards);
		// aiDataRewardRatio = String.format("%.02f", 100 * (double) aiDataReward / (double) totalRewards);
		// bioplasticoRewardRatio = String.format("%.02f", 100 * (double) bioplasticoReward / (double) totalRewards);
		// nanofioRewardRatio = String.format("%.02f", 100 * (double) nanofioReward / (double) totalRewards);
		// bateriaRewardRatio = String.format("%.02f", 100 * (double) bateriaReward / (double) totalRewards);
		// gasolinaRewardRatio = String.format("%.02f", 100 * (double) gasolinaReward / (double) totalRewards);
		// medalRewardRatio = String.format("%.02f", 100 * (double) medalReward / (double) totalRewards);
		// coinRewardRatio = String.format("%.02f", 100 * (double) coinReward / (double) totalRewards);
		// supplyRewardRatio = String.format("%.02f", 100 * (double) supplyReward / (double) totalRewards);

	}

	public void iniciarPrograma() {
		for (int i = 0; i < REPETICOES; i++) {
			Utils.printRunningTime();
			Utils.printAverageTime(i);
			// Utils.printMedalsPerHour(i);
			int questChecks = 0;
			int questChecks2 = 0;
			int questChecks3 = 0;
			questDone = false;
			System.out.println("############################# ITERAÇÃO " + (i + 1) + " #############################");
			deletarDecoracoes();
			colocarDecoracoes();
			if (Utils.isMidNight()) {
				coletarMissaoEspecialMeiaNoite();
			}
			while (!questDone) {
				Utils.wait(500);
				questDone = verificaSeQuestDone();
				questChecks++;
				questChecks2++;
				questChecks3++;

				if (questChecks % 10 == 0) {
					System.out.println("verificando quest: " + questChecks + "%");
				}
				if (questChecks3 > 10) {
					deletarDecoracoes();
					colocarDecoracoes();
					questChecks3 = 0;
				}
				if (questChecks > 50) {
					if (questChecks2 > 150) {
						abrirMenuQuests();
						Utils.wait(300);
						coletarRecompensa();
						questChecks2 = 0;
						break;
					}
					refreshPage();
					questChecks = 0;
					break;
				}
			}
			abrirMenuQuests();
			Utils.wait(100);
			checkReward();
			coletarRecompensa();
			for (int j = 0; j < 10; j++) {
				InputManager.zoomOut();
				Utils.wait(100);
			}
			// if (i % 10 == 0) {
			// dbm.updateData();
			// }
			verificaSeQuestDone();
			verificaSeQuestEhDecoracoes();
			fecharMenuQuests();
		}
	}

	public void coletarMissaoEspecialMeiaNoite() {
		printMethodName();
		refreshPage();
		BasicKeys.oito();
		Wait.milliseconds(1500);
		BasicKeys.nove();
		Wait.milliseconds(1500);
		BasicKeys.q();
		Wait.milliseconds(1500);
		BasicKeys.zero();
		Wait.milliseconds(1500);
		BasicKeys.sete();
		Wait.milliseconds(1500);
	}

	public boolean verificaSeQuestDone() {
		boolean foundQuestDone = images.hasImage("questDone");
		return foundQuestDone;
	}

	public void coletarRecompensa() {
		printMethodName();
		BasicKeys.um();
	}

	private static void printMethodName() {
		System.err.println(new Exception().getStackTrace()[1].getMethodName());
	}

	public void fecharMenuQuests() {
		printMethodName();
		BasicKeys.q();
	}

	public void abrirMenuQuests() {
		printMethodName();
		BasicKeys.esc();
		BasicKeys.q();
		for (int i = 0; i < 5; i++) {
			Wait.milliseconds(800);
			if (!images.hasImage("opennedQuestMenu")) {
				System.err.println("Opening Menu Again");
				BasicKeys.esc();
				Wait.milliseconds(200);
				BasicKeys.q();
			} else {
				break;
			}
		}
	}

	public void colocarDecoracoes() {
		printMethodName();
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
		printMethodName();
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
		boolean questCerta = images.hasImage("quest");
		int jumps = 0;
		while (!questCerta) {
			Utils.wait(6200 / (SPEED_MULTIPLIER));
			questCerta = images.hasImage("quest");
			if (!questCerta) {
				BasicKeys.dois();
				BasicKeys.tres();
				jumps++;
				System.out.println("Pulou " + jumps);
				if (jumps > 90) {
					refreshPage();
					jumps = 0;
				}
			}
		}
		Utils.wait(2000);
	}

	public void refreshPage() {
		BasicKeys.seis();
		Utils.wait(15000);
		BasicKeys.esc();
		Utils.wait(300);
		BasicKeys.apertarBaixo();
		BasicKeys.apertarDireita();
		Utils.wait(4000);
		BasicKeys.apertarBaixo();
		BasicKeys.apertarDireita();
		Utils.wait(100);
		BasicKeys.soltarBaixo(); // termina o posicionamento da tela
		Utils.wait(100);
		BasicKeys.soltarDireita();
		Utils.wait(200);
		BasicKeys.sete();
		Utils.wait(200);
		InputManager.zoomIn();
		Utils.wait(1000);
		InputManager.zoomIn();
		Utils.wait(1000);
		InputManager.zoomOut();
		Utils.wait(1000);
		BasicKeys.b(); // abre menu de construcao
		Utils.wait(1000);
		BasicKeys.cinco(); // decoracoes
		Utils.wait(200);
		deletarDecoracoes();
		colocarDecoracoes();
	}

	private void checkGenericReward(String imageName, int reward) {
		if (images.hasImage(imageName)) {
			reward++;
			System.err.println("REWARD: " + imageName.toUpperCase());
		}
	}

	public void checkReward() {
		checkGenericReward("planta", plantaReward);
		checkGenericReward("pf", pfReward);
		checkGenericReward("AIData", aiDataReward);
		checkGenericReward("bioplastico", bioplasticoReward);
		checkGenericReward("nanofio", nanofioReward);
		checkGenericReward("bateria", bateriaReward);
		checkGenericReward("gasolina", gasolinaReward);
		checkGenericReward("medal", medalReward);
		checkGenericReward("coin", coinReward);
		checkGenericReward("supply", supplyReward);
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

	public static int getTotalRewards() {
		return totalRewards;
	}
}
