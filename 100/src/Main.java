import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	Scanner in;
	PrintWriter out;

	void solve() {
		int n = in.nextInt() / 2;
		BigInteger sum[][] = new BigInteger[1 + n][1 + n * 9];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j < 1 + n * 9; j++) {
				sum[i][j] = BigInteger.ZERO;
			}
		}
		for (int i = 0; i <= 9; i++) {
			sum[1][i] = BigInteger.ONE;
		}
		for (int len = 2; len <= n; len++) {
			for (int needSum = 0; needSum < 1 + len * 9; needSum++) {
				for (int num = 0; num <= 9; num++) {
					if (needSum >= num) {
						sum[len][needSum] = sum[len][needSum]
								.add(sum[len - 1][needSum - num]);
					}
				}
			}
		}
		BigInteger ans = BigInteger.ZERO;
		for (int i = 0; i < 1 + n * 9; i++) {
			ans = ans.add(sum[n][i].multiply(sum[n][i]));
		}
		out.println(ans);
	}

	void run() {
		in = new Scanner(System.in);
		out = new PrintWriter(System.out);

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