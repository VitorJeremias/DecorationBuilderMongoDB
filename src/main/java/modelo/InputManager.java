package modelo;

import java.awt.AWTException;
import java.awt.Robot;

import utils.Utils;

public class InputManager {

	private static Robot robot;

	public static void apertarTecla(int keycode) {
		try {
			robot = new Robot();
			robot.keyPress(keycode);
		} catch (AWTException e) {
			e.printStackTrace();
		}

		Utils.wait(980 / Acoes.SPEED_MULTIPLIER);
	}

	public static void digitar(int keycode) {
		try {
			robot = new Robot();
			robot.keyPress(keycode);
			Wait.milliseconds(50);
			robot.keyRelease(keycode);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		Utils.wait(980 / Acoes.SPEED_MULTIPLIER);
	}

	public static void soltarTecla(int keycode) {
		try {
			robot = new Robot();
			robot.keyRelease(keycode);
		} catch (AWTException e) {
			e.printStackTrace();
		}

		// Utils.wait(1400 / Acoes.SPEED_MULTIPLIER);

	}

	public static void digitarRapido(int keycode) {
		try {
			robot = new Robot();
			robot.keyPress(keycode);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public static void zoomIn() {
		try {
			robot = new Robot();
			robot.mouseWheel(-1);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public static void zoomOut() {
		try {
			robot = new Robot();
			robot.mouseWheel(1);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
}
