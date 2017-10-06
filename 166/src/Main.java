import java.io.*;
import java.util.*;

public class Main {

	Scanner in;
	PrintWriter out;

	int opt(int n) {
		if (n < 3) {
			return 0;
		}
		if (n == 4) {
			return 5;
		}
		if (n % 5 == 0) {
			return n / 5 * 9;
		}
		if (n % 5 == 1) {
			return (n - 6) / 5 * 9 + 2 * 5;
		}
		if (n % 5 == 2) {
			if (n == 7) {
				return 10;
			} else {
				return (n - 12) / 5 * 9 + 4 * 5;
			}
		}
		if (n % 5 == 3) {
			return (n - 3) / 5 * 9 + 5;
		}
		if (n % 5 == 4) {
			return (n - 9) / 5 * 9 + 3 * 5;
		}
		return 0;
	}

	void solve() {
		int k = in.nextInt();
		int n = in.nextInt();
		int a[] = new int[n + 1];
		a[0] = k;

		for (int i = 1; i < n; i++) {
			a[i] = opt(k);
			if (i >= 3) {
				k += a[i] - a[i - 3];
			} else {
				k += a[i];
			}
		}
		out.print(k);
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
