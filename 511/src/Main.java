import java.io.*;
import java.util.*;

public class Main {

	Scanner in;
	PrintWriter out;

	int time(int k) {
		return -5 + k * 5;
	}

	void solve() {
		int k = in.nextInt();
		if (k > ((60 / 5) * 12 + 1)) {
			out.print("NO");
		} else {
			out.print(time(k) / 60 + " " + time(k) % 60);
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
