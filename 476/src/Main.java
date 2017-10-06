import java.io.*;
import java.util.*;

public class Main {

	Scanner in;
	PrintWriter out;

	void solve() {
		int startX = in.nextInt();
		int startY = in.nextInt();
		if (startX == startY) {
			out.print(1);
			return;
		}
		if (startY > startX) {
			int buf = startX;
			startX = startY;
			startY = buf;
		}
		int count1 = 1;
		int count2 = 1;
		ArrayList<Integer> coordY = new ArrayList<Integer>();
		coordY.add(-1);
		coordY.add(1);
		for (int x = 2; x <= startX; x++) {
			if (coordY.contains(x)) {
				coordY.add(x - count2);
				count2++;
			} else {
				coordY.add(x + count1);
				count1++;
			}
		}
		if (startY == coordY.get(startX)) {
			out.print(2);
			return;
		}
		out.print(1);
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
