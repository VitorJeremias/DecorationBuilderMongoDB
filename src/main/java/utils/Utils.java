package utils;

public class Utils {

	public static void wait(int d) {
			try {
				Thread.sleep(d);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
}
