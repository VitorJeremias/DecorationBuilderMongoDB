package modelo;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;

public class BasicKeys {

	public static void q() {
		InputManager.digitar(KeyEvent.VK_Q);
	}

	public static void zeroNumerico() {
		InputManager.apertarTecla(KeyEvent.VK_NUMPAD0);
	}

	public static void umNumerico() {
		InputManager.digitarRapido(KeyEvent.VK_NUMPAD1);
	}

	public static void doisNumerico() {
		InputManager.apertarTecla(KeyEvent.VK_NUMPAD2);
	}

	public static void tresNumerico() {
		InputManager.apertarTecla(KeyEvent.VK_NUMPAD3);
	}

	public static void quatroNumerico() {
		InputManager.apertarTecla(KeyEvent.VK_NUMPAD4);
	}

	public static void cincoNumerico() {
		InputManager.apertarTecla(KeyEvent.VK_NUMPAD5);
	}

	public static void seisNumerico() {
		InputManager.apertarTecla(KeyEvent.VK_NUMPAD6);
	}

	public static void seteNumerico() {
		InputManager.apertarTecla(KeyEvent.VK_NUMPAD7);
	}

	public static void oitoNumerico() {
		InputManager.apertarTecla(KeyEvent.VK_NUMPAD8);
	}

	public static void noveNumerico() {
		InputManager.apertarTecla(KeyEvent.VK_NUMPAD9);
	}

	public static void zero() {
		InputManager.apertarTecla(KeyEvent.VK_0);
	}

	public static void um() {
		InputManager.apertarTecla(KeyEvent.VK_1);
	}

	public static void dois() {
		InputManager.digitarRapido(KeyEvent.VK_2);
	}

	public static void tres() {
		InputManager.digitarRapido(KeyEvent.VK_3);
	}

	public static void quatro() {
		InputManager.digitarRapido(KeyEvent.VK_4);
	}

	public static void cinco() {
		InputManager.apertarTecla(KeyEvent.VK_5);
	}

	public static void seis() {
		InputManager.digitarRapido(KeyEvent.VK_6);
	}

	public static void sete() {
		InputManager.apertarTecla(KeyEvent.VK_7);
	}

	public static void oito() {
		InputManager.apertarTecla(KeyEvent.VK_8);
	}

	public static void nove() {
		InputManager.apertarTecla(KeyEvent.VK_9);
	}

	public static void maisNumerico() {
		InputManager.apertarTecla(KeyEvent.VK_ADD);
	}

	public static void esc() {
		InputManager.digitar(KeyEvent.VK_ESCAPE);
		Wait.milliseconds(1);
	}

	public static void apertarBaixo() {
		InputManager.apertarTecla(KeyEvent.VK_DOWN);
	}

	public static void soltarBaixo() {
		InputManager.soltarTecla(KeyEvent.VK_DOWN);
	}

	public static void apertarDireita() {
		InputManager.apertarTecla(KeyEvent.VK_RIGHT);
	}

	public static void soltarDireita() {
		InputManager.soltarTecla(KeyEvent.VK_RIGHT);
	}

	public static void b() {
		InputManager.apertarTecla(KeyEvent.VK_B);
	}

	public static void scrollLock() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		toolkit.setLockingKeyState(KeyEvent.VK_SCROLL_LOCK, Boolean.TRUE);
	}

}
