package modelo;

import java.awt.AWTException;
import java.awt.Robot;

import utils.Utils;

public class InputManager {

	public static void digitar(int keycode) {
		try {
			Robot robot = new Robot();
			robot.keyPress(keycode);
		} catch (AWTException e) {
			e.printStackTrace();
		}

		Utils.wait(980 / Acoes.SPEED_MULTIPLIER);

	}

	public static void soltar(int keycode) {
		try {
			Robot robot = new Robot();
			robot.keyRelease(keycode);
		} catch (AWTException e) {
			e.printStackTrace();
		}

		// Utils.wait(1400 / Acoes.SPEED_MULTIPLIER);

	}

	public static void digitarRapido(int keycode) {
		try {
			Robot robot = new Robot();
			robot.keyPress(keycode);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public static void zoomIn() {
		Robot robot;
		try {
			robot = new Robot();
			robot.mouseWheel(-1);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public static void zoomOut() {
		Robot robot;
		try {
			robot = new Robot();
			robot.mouseWheel(1);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	
	public static void main(String[] args) {
		int an = 226400;
		int n = 0;
		int r = 50;
		long soma = an;
		
		while (soma<15000000000L) {
			an = an+r;
			soma = soma + an;
			n++;
		}
		System.out.println(n);
	}
}
