import java.io.*;
import java.util.*;

public class Main {

	Scanner in;
	PrintWriter out;

	int sum(StringBuilder s) {
		while (true) {
			int sum = 0;
			for (int i = 0; i < s.length(); i++) {
				sum += s.charAt(i) - '0';
			}
			if (sum < 10) {
				return sum;
			}
			s = new StringBuilder("" + sum);
		}
	}

	void solve() {
		StringBuilder s1 = new StringBuilder(in.next());
		StringBuilder s2 = new StringBuilder();
		int len = s1.length();
		boolean good = false;
		for (int i = 0; i < len - 1; i++) {
			s2.append(s1.charAt(0));
			s1.deleteCharAt(0);
			if (sum(s1) == sum(s2)) {
				good = true;
				break;
			}
		}
		if (good) {
			out.print("YES");
		} else {
			out.print("NO");
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