import java.io.*;
import java.util.*;

public class Main {

	Scanner in;
	PrintWriter out;

	double square(double a, double b, double c) {
		if (a + b > c && a + c > b && b + c > a) {
			double p = (a + b + c) / 2;
			return Math.sqrt(p * (p - a) * (p - b) * (p - c));
		} else {
			return 0;
		}
	}

	void solve() {
		double[] lens = new double[in.nextInt()];
		for (int i = 0; i < lens.length; i++) {
			lens[i] = in.nextInt();
		}
		Arrays.sort(lens);
		double sMax = 0;
		for (int i = 0; i < lens.length; i++) {
			for (int j = i + 1; j < lens.length; j++) {
				double need = Math.sqrt(lens[i] * lens[i] + lens[j] * lens[j]);
				int index = Arrays.binarySearch(lens, need);
				if (index < 0) {
					index = -(index + 1);
				}
				for (int k = index - 1; k <= index + 1; k++) {
					if (j < k && k < lens.length) {
						sMax = Math.max(sMax, square(lens[i], lens[j], lens[k]));
					}
				}
			}
		}
		if (sMax == 0) {
			out.print(0);
		} else {
			out.printf(Locale.US, "%.3f", sMax);
		}
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
