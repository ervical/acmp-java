import java.io.*;
import java.util.*;

public class Main {

	Scanner in;
	PrintWriter out;

	static class Place {
		boolean wasVisited = true;
		String path = "";
	}

	static class Point {
		final int x;
		final int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		Point goN() {
			return new Point(x, y - 1);
		}
		
		Point goS() {
			return new Point(x, y + 1);
		}
		
		Point goE() {
			return new Point(x + 1, y);
		}
		
		Point goW() {
			return new Point(x - 1, y);
		}
		
		Point go(int dx, int dy) {
			return new Point(x + dx, y + dy);
		}
	}

	void solve() {
		String path = in.next();
		Place[][] lab = new Place[801][801];
		Point current = new Point(400, 400);
		lab[current.x][current.y] = new Place();
		for (int i = 0; i < path.length(); i++) {
			if (path.charAt(i) == 'N') {
				current = current.goN();
				lab[current.x][current.y] = new Place();
				current = current.goN();
				lab[current.x][current.y] = new Place();
			} else if (path.charAt(i) == 'S') {
				current = current.goS();
				lab[current.x][current.y] = new Place();
				current = current.goS();
				lab[current.x][current.y] = new Place();
			} else if (path.charAt(i) == 'E') {
				current = current.goE();
				lab[current.x][current.y] = new Place();
				current = current.goE();
				lab[current.x][current.y] = new Place();
			} else if (path.charAt(i) == 'W') {
				current = current.goW();
				lab[current.x][current.y] = new Place();
				current = current.goW();
				lab[current.x][current.y] = new Place();
			} else {
				throw new Error();
			}
		}
		Queue<Point> queue = new ArrayDeque<Point>();
		queue.add(current);
		while (!queue.isEmpty()) {
			current = queue.poll();
			lab[current.x][current.y].wasVisited = false;
			if (current.x == 400 && current.y == 400) {
				out.print(lab[400][400].path);
				return;
			}
			if (lab[current.x][current.y - 1] != null && lab[current.x][current.y - 1].wasVisited) {
				lab[current.x][current.y - 1].wasVisited = false;
				lab[current.x][current.y - 2].path = lab[current.x][current.y].path + "N";
				queue.add(current.go(0, -2));
			}
			if (lab[current.x + 1][current.y] != null && lab[current.x + 1][current.y].wasVisited) {
				lab[current.x + 1][current.y].wasVisited = false;
				lab[current.x + 2][current.y].path = lab[current.x][current.y].path + "E";
				queue.add(current.go(+2, 0));
			}
			if (lab[current.x][current.y + 1] != null && lab[current.x][current.y + 1].wasVisited) {
				lab[current.x][current.y + 1].wasVisited = false;
				lab[current.x][current.y + 2].path = lab[current.x][current.y].path + "S";
				queue.add(current.go(0, +2));
			}
			if (lab[current.x - 1][current.y] != null && lab[current.x - 1][current.y].wasVisited) {
				lab[current.x - 1][current.y].wasVisited = false;
				lab[current.x - 2][current.y].path = lab[current.x][current.y].path + "W";
				queue.add(current.go(-2, 0));
			}
			lab[current.x][current.y] = null;
		}
		throw new Error();
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