import java.io.*;
import java.util.*;

public class Main {

	Scanner in;
	PrintWriter out;

	int daysBeforeYear(int year) {
		int a = (year - 1) / 4 - (year - 1) / 100 + (year - 1) / 400;
		return 366 * a + 365 * (year - a - 1);
	}

	boolean isLeap(int year) {
		return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
	}

	int daysSinceNewYear(int day, int month, int year) {
		int ans = 0;
		for (int i = 1; i < month; i++) {
			if (i == 4 || i == 6 || i == 9 || i == 11) {
				ans += 30;
			} else if (i == 2) {
				if (isLeap(year)) {
					ans += 29;
				} else {
					ans += 28;
				}
			} else {
				ans += 31;
			}
		}
		return ans + day;
	}

	int readDate() {
		in.useDelimiter("\\.|\\s+");
		int day = Integer.parseInt(in.next());
		int month = Integer.parseInt(in.next());
		int year = Integer.parseInt(in.next());
		return daysBeforeYear(year) + daysSinceNewYear(day, month, year);
	}

	void solve() {
		int beginDaysCount = readDate();
		int endDaysCount = readDate();
		out.print(endDaysCount - beginDaysCount + 1);
	}

	void run() {
		try {
			in = new Scanner(new FileReader("input.txt"));
			out = new PrintWriter(new FileWriter("output.txt"));
		} catch (IOException e) {
			throw new IOError(e);
		}
		try {
			solve();
		} finally {
			out.close();
		}
	}

	public static void main(String[] args) {
		new Main().run();
	}
}
