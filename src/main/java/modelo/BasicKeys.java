package modelo;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;

public class BasicKeys {

	private InputManager inputManager;

	public BasicKeys() {
		inputManager = new InputManager();
	}

	public void q() {
		inputManager.digitar(KeyEvent.VK_Q);
	}

	public void zeroNumerico() {
		inputManager.apertarTecla(KeyEvent.VK_NUMPAD0);
	}

	public void umNumerico() {
		inputManager.digitarRapido(KeyEvent.VK_NUMPAD1);
	}

	public void doisNumerico() {
		inputManager.apertarTecla(KeyEvent.VK_NUMPAD2);
	}

	public void tresNumerico() {
		inputManager.apertarTecla(KeyEvent.VK_NUMPAD3);
	}

	public void quatroNumerico() {
		inputManager.apertarTecla(KeyEvent.VK_NUMPAD4);
	}

	public void cincoNumerico() {
		inputManager.apertarTecla(KeyEvent.VK_NUMPAD5);
	}

	public void seisNumerico() {
		inputManager.apertarTecla(KeyEvent.VK_NUMPAD6);
	}

	public void seteNumerico() {
		inputManager.apertarTecla(KeyEvent.VK_NUMPAD7);
	}

	public void oitoNumerico() {
		inputManager.apertarTecla(KeyEvent.VK_NUMPAD8);
	}

	public void noveNumerico() {
		inputManager.apertarTecla(KeyEvent.VK_NUMPAD9);
	}

	public void zero() {
		inputManager.apertarTecla(KeyEvent.VK_0);
	}

	public void um() {
		inputManager.apertarTecla(KeyEvent.VK_1);
	}

	public void dois() {
		inputManager.digitarRapido(KeyEvent.VK_2);
	}

	public void tres() {
		inputManager.digitarRapido(KeyEvent.VK_3);
	}

	public void quatro() {
		inputManager.digitarRapido(KeyEvent.VK_4);
	}

	public void cinco() {
		inputManager.apertarTecla(KeyEvent.VK_5);
	}

	public void seis() {
		inputManager.digitarRapido(KeyEvent.VK_6);
	}

	public void sete() {
		inputManager.apertarTecla(KeyEvent.VK_7);
	}

	public void oito() {
		inputManager.apertarTecla(KeyEvent.VK_8);
	}

	public void nove() {
		inputManager.apertarTecla(KeyEvent.VK_9);
	}

	public void maisNumerico() {
		inputManager.apertarTecla(KeyEvent.VK_ADD);
	}

	public void esc() {
		inputManager.digitar(KeyEvent.VK_ESCAPE);
		Wait.milliseconds(1);
	}

	public void apertarBaixo() {
		inputManager.apertarTecla(KeyEvent.VK_DOWN);
	}

	public void soltarBaixo() {
		inputManager.soltarTecla(KeyEvent.VK_DOWN);
	}

	public void apertarDireita() {
		inputManager.apertarTecla(KeyEvent.VK_RIGHT);
	}

	public void soltarDireita() {
		inputManager.soltarTecla(KeyEvent.VK_RIGHT);
	}

	public void b() {
		inputManager.apertarTecla(KeyEvent.VK_B);
	}

	public void scrollLock() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		toolkit.setLockingKeyState(KeyEvent.VK_SCROLL_LOCK, Boolean.TRUE);
	}

}
