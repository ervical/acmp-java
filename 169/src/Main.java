import java.io.*;
import java.util.*;

public class Main {

	Scanner in;
	PrintWriter out;

	int waysNumber(int[][] a, int n, int k) {
		if (a[n][k] == -1) {
			if (n > k || n == 0 && k > 0) {
				a[n][k] = 0;
			} else if (n == k) {
				a[n][k] = 1;
			} else {
				a[n][k] = waysNumber(a, n - 1, k - 1)
						+ waysNumber(a, n + 1, k - 1);
			}
		}
		return a[n][k];
	}

	void solve() {
		int n = in.nextInt();
		int k = in.nextInt();
		int[][] a = new int[n + k + 1][k + 1];
		for (int i = 0; i < a.length; i++) {
			Arrays.fill(a[i], -1);
		}
		out.println(waysNumber(a, n, k));
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