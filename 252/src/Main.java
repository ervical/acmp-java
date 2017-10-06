import java.io.*;
import java.util.*;

public class Main {
	
	Scanner in;
	PrintWriter out;

	static class Neft {
		double x;
		String y;

		Neft(Scanner in) {
			this.x = in.nextLong()*1.0;
			this.y = in.next();
		}

		static class MassaComparator implements Comparator<Neft> {
			public int compare(Neft left, Neft right) {
				return (int) Math.signum (left.x - right.x);
			}
		}
	}

	double  Prist(Neft a) {
		if (a.y.charAt(0) == 'm') {
			return a.x * Math.pow(10, -3);
		} else if (a.y.charAt(0) == 'M') {
			return a.x * Math.pow(10, 6);
		} else if (a.y.charAt(0) == 'k') {
			return a.x * Math.pow(10, 3);
		} else if (a.y.charAt(0) == 'G') {
			return a.x * Math.pow(10, 9);
		} else {
			return a.x;
		}
	}

	double Oprist(Neft a) {
		if (a.y.charAt(0) == 'm') {
			return a.x / Math.pow(10, -3);
		} else if (a.y.charAt(0) == 'M') {
			return a.x / Math.pow(10, 6);
		} else if (a.y.charAt(0) == 'k') {
			return a.x / Math.pow(10, 3);
		} else if (a.y.charAt(0) == 'G') {
			return a.x / Math.pow(10, 9);
		} else {
			return a.x;
		}
	}

	double Znach(Neft a) {
		if (a.y.charAt(a.y.length()-1) == 'p') {
			return a.x * 16380;
		} else if (a.y.charAt(a.y.length()-1) == 't') {
			return a.x * Math.pow(10, 6);
		} else {
			return a.x;
		}
	}

	double Oznach(Neft a) {
		if (a.y.charAt(a.y.length()-1) == 'p') {
			return a.x / 16380;
		} else if (a.y.charAt(a.y.length()-1) == 't') {
			return a.x / Math.pow(10, 6);
		} else {
			return a.x;
		}
	}

	void solve() {
		int n = in.nextInt();
		Neft a[] = new Neft[n];
		for (int i = 0; i < n; i++) {
			a[i] = new Neft(in);
			if (a[i].y.length() == 2) {
				a[i].x = Prist(a[i]);
			}
			a[i].x = Znach(a[i]);
		}
		Arrays.sort(a, new Neft.MassaComparator());
		for (int i = 0; i < n; i++) {
			if (a[i].y.length() == 2) {
				a[i].x = Oprist(a[i]);
			}
			 a[i].x = Oznach(a[i]);
		}
		for (int j = 0; j < n; j++) {
			out.println((long)(Math.round(a[j].x)) + " " + a[j].y);
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
