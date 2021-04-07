package modelo;

import java.awt.AWTException;
import java.awt.Robot;

public class InputManager {

	private static Robot robot;

	public InputManager() {
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public void apertarTecla(int keycode) {
		robot.keyPress(keycode);
		Wait.milliseconds(980 / Acoes.SPEED_MULTIPLIER);
	}

	public void digitar(int keycode) {
		robot.keyPress(keycode);
		Wait.milliseconds(50);
		robot.keyRelease(keycode);
		Wait.milliseconds(980 / Acoes.SPEED_MULTIPLIER);
	}

	public void soltarTecla(int keycode) {
		robot.keyRelease(keycode);
	}

	public void digitarRapido(int keycode) {
		try {
			robot = new Robot();
			robot.keyPress(keycode);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public void zoomIn() {
		try {
			robot = new Robot();
			robot.mouseWheel(-1);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public void zoomOut() {
		try {
			robot = new Robot();
			robot.mouseWheel(1);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
}
