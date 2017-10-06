import java.io.*;
import java.util.*;

public class Main {

	Scanner in;
	PrintWriter out;

	static class Point {
		long x;
		long y;

		Point(Scanner in) {
			x = in.nextLong();
			y = in.nextLong();
		}

		Point(long x, long y) {
			this.x = x;
			this.y = y;
		}

		Point add(Vector v) {
			return new Point(this.x + v.x, this.y + v.y);
		}

		double distanceTo(Point second) {
			long dx = this.x - second.x;
			long dy = this.y - second.y;
			return Math.sqrt(dx * dx + dy * dy);
		}
	}

	static class Vector {
		long x;
		long y;

		Vector(Scanner in) {
			x = in.nextLong();
			y = in.nextLong();
		}

		Vector(long x, long y) {
			this.x = x;
			this.y = y;
		}

		Vector multiply(long value) {
			return new Vector(x * value, y * value);
		}
	}

	void solve() {
		Point start = new Point(in);
		Vector speed = new Vector(in);
		long vMax = in.nextLong();
		long time = in.nextLong();
		long dist = in.nextLong();
		Point finish = start.add(speed.multiply(time));
		Point zero = new Point(0, 0);

		if (Math.abs(zero.distanceTo(finish) - dist) <= vMax * time) {
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
