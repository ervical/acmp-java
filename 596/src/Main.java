import java.io.*;
import java.util.*;

public class Main {

	static class Assert {
		static void check(boolean e) {
			if (!e) {
				throw new Error();
			}
		}
	}

	static class Scanner {
		StreamTokenizer in;

		Scanner(Reader r) {
			in = new StreamTokenizer(new BufferedReader(r));
			in.resetSyntax();
			in.whitespaceChars(0, 32);
			in.wordChars(33, 255);
		}

		Scanner(InputStream is) {
			this(new InputStreamReader(is));
		}

		String next() {
			try {
				in.nextToken();
				Assert.check(in.ttype == in.TT_WORD);
				return in.sval;
			} catch (IOException e) {
				throw new Error(e);
			}
		}

		int nextInt() {
			return Integer.parseInt(next());
		}
	}

	Scanner in;
	PrintWriter out;

	static class Point {
		int x;
		int y;

		Point(Scanner in) {
			x = in.nextInt();
			y = in.nextInt();
		}

		double sqrDistanceTo(Point second) {
			int dx = this.x - second.x;
			int dy = this.y - second.y;
			return dx * dx + dy * dy;
		}
	}

	static class Station {
		String name;
		Point pos;
		int radius;

		Station(Scanner in) {
			name = in.next();
			pos = new Point(in);
			radius = in.nextInt();
		}

		boolean isVisibleFrom(Point p) {
			return pos.sqrDistanceTo(p) <= radius * radius;
		}
	}

	void solve() {
		Station stations[] = new Station[in.nextInt()];
		Map<String, Integer> operatorStations = new TreeMap<String, Integer>();
		List<String> operatorOrder = new ArrayList<String>();
		for (int i = 0; i < stations.length; i++) {
			stations[i] = new Station(in);
			String name = stations[i].name;
			if (!operatorStations.containsKey(name)) {
				operatorStations.put(name, 0);
				operatorOrder.add(name);
			}
		}
		Point man = new Point(in);
		for (int i = 0; i < stations.length; i++) {
			if (stations[i].isVisibleFrom(man)) {
				String name = stations[i].name;
				operatorStations.put(name, operatorStations.get(name) + 1);
			}
		}
		out.println(operatorStations.size());
		for (String operator : operatorOrder) {
			out.println(operator + " " + operatorStations.get(operator));
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
