import java.io.*;
import java.util.*;

public class Main {

	Scanner in;
	PrintWriter out;

	int[][] getPascalTriangle(int n) {
		int[][] c = new int[n + 1][n + 1];
		c[0][0] = 1;
		for (int i = 1; i <= n; i++) {
			c[i][0] = 1;
			for (int j = 1; j < i; j++) {
				c[i][j] = c[i - 1][j] + c[i - 1][j - 1];
			}
			c[i][i] = 1;
		}
		return c;
	}

	void solve() {
		int n = in.nextInt();
		int k = in.nextInt();
		int[][] c = getPascalTriangle(n);
		int result = 0;
		for (int i = k; i <= n; i++) {
			result += c[n][i];
		}
		out.println(result);

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
