package utils;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileManager {

	private static void openFile(File file) {
		try {
			Desktop.getDesktop().open(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static boolean isApplicationRunning(String proccessName) {
		String line;
		String pidInfo = "";

		Process p;
		try {
			p = Runtime.getRuntime().exec(System.getenv("windir") + "\\system32\\" + "tasklist.exe");

			BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));

			while ((line = input.readLine()) != null) {
				pidInfo += line;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		return pidInfo.contains(proccessName);
	}

	public static void runAhkScript() {
		if (!isApplicationRunning("AutoHotkey.exe")) {
			openFile(new File(Constants.decorationsFoeFileAbsolutePath));
		}
	}

}
