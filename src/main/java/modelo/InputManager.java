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
		
		Utils.wait(1500/Acoes.SPEED_MULTIPLIER);
		
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
