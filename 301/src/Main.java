import java.io.*;
import java.util.*;

public class Main {

	Scanner in;
	PrintWriter out;

	void solve() {
		int sum = in.nextInt();
		int[] max = new int[in.nextInt()];
		int[] min = new int[max.length];
		int buf = sum;
		for (int i = 0; i < max.length; i++) {
			max[i] = Math.min(9, buf);
			buf -= max[i];
		}
		buf = sum - 1;
		for (int i = min.length - 1; i > 0; i--) {
			min[i] = Math.min(9, buf);
			buf -= min[i];
		}
		min[0] = buf + 1;
		for (int j = 0; j < max.length; j++) {
			out.print(max[j]);
		}
		out.print(' ');
		for (int j = 0; j < min.length; j++) {
			out.print(min[j]);
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