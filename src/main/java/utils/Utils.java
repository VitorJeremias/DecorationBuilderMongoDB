package utils;

import java.util.concurrent.TimeUnit;

import org.joda.time.DateTime;

import modelo.Acoes;

public class Utils {

	static long startTime = System.nanoTime();
	static int MEDALS_PER_QUEST = 7425;

	public static void wait(int d) {
		try {
			Thread.sleep(d);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static int getRunningTime() {
		long currentTime = System.nanoTime() - startTime;
		long runTime = TimeUnit.SECONDS.convert(currentTime, TimeUnit.NANOSECONDS);
		return (int) runTime;
	}

	public static void printRunningTime() {
		int runTime = getRunningTime();
		int seconds = (int) Math.floor(runTime % 60);
		int minutes = 0;
		int hours = 0;
		minutes = (int) Math.floor(runTime % 60);
		hours = (int) Math.floor(minutes / 60);
		String sSeconds = "" + seconds;
		String sMinutes = "" + minutes;
		String sHours = "" + hours;
		if (minutes >= 60) {
			minutes = 0;
			hours++;
		}
		if (seconds < 10) {
			sSeconds = "0" + seconds;
		}
		if (minutes < 10) {
			sMinutes = "0" + minutes;
		}
		if (hours < 10) {
			sHours = "0" + hours;
		}

		System.out.println(sHours + ":" + sMinutes + ":" + sSeconds);
	}

	public static boolean isMidNight() {
		DateTime dt = new DateTime();

		int hour = dt.getHourOfDay();
		int minute = dt.getMinuteOfHour();
		boolean isZeroHour;
		boolean isZeroMinute;
		if (hour == 0) {
			isZeroHour = true;
		} else {
			isZeroHour = false;
		}
		if (minute > 0 && minute < 5) {
			isZeroMinute = true;
		} else {
			isZeroMinute = false;
		}

		return isZeroHour && isZeroMinute;

	}

	public static int getAverageTime(int i) {
		if (i == 0) {
			i = 1;
		}
		int averageTime = getRunningTime() / i;
		return averageTime;
	}

	public static void printAverageTime(int i) {
		System.out.println("Average time: " + getAverageTime(i) + "s (" + getRunningTime() + " / " + i + ")");
	}

	public static double getIterationsPerHour(int i) {
		if (getAverageTime(i) == 0) {
			return 0;
		}
		return 3600 / getAverageTime(i);
	}

	public static double getMedalPercentage() {
		return ((double) Acoes.getMedalReward() / (double) Acoes.getTotalRewards());
	}

	public static double getMedalsPerHour(int i) {
		double medalsPerHour = getIterationsPerHour(i) * getMedalPercentage() * MEDALS_PER_QUEST;
		return medalsPerHour;
	}

	public static void printMedalsPerHour(int i) {
		// System.out.println("Medals/H: " + getMedalsPerHour(i));
		System.out.println(String.format("Medals/h: " + "%.02f", getMedalsPerHour(i)));
	}
}
