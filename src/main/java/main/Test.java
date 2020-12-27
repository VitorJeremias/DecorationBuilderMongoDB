package main;

import org.joda.time.DateTime;

public class Test {
	public static void main(String[] args) {
		DateTime dt = new DateTime();

		int hour = dt.getHourOfDay();
		int minute = dt.getMinuteOfHour();
		int second = dt.getSecondOfMinute();
		boolean isZeroHour;
		boolean isZeroMinute;
		boolean isEndOfMinute;
		if (hour == 0) {
			isZeroHour = true;
		} else {
			isZeroHour = false;
		}
		if (minute == 0) {
			isZeroMinute = true;
		} else {
			isZeroMinute = false;
		}
		if (second < 50) {
			isEndOfMinute = true;
		} else {
			isEndOfMinute = false;
		}

		System.out.println(hour + ":" + minute + ":" + second);
		System.out.println(isZeroHour && isZeroMinute && isEndOfMinute);
	}

}
