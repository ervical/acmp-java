import java.io.*;
import java.util.*;

public class Main {

	Scanner in;
	PrintWriter out;

	void solve() {
		String name = in.nextLine();
		StringBuilder newName = new StringBuilder();
		if ('A' <= name.charAt(0) && name.charAt(0) <= 'Z' || name.charAt(0) == '_' || name.charAt(name.length() - 1) == '_') {
			out.print("Error!");
			return;
		}
		boolean wasCapital = false;
		boolean wasUnderscore = false;
		newName.append(name.charAt(0));
		for (int i = 1; i < name.length(); i++) {
			if (name.charAt(i) == '_') {
				wasUnderscore = true;
				if (wasCapital) {
					out.print("Error!");
					return;
				}
				if (name.charAt(i - 1) == '_') {
					out.print("Error!");
					return;
				}
			} else if ('A' <= name.charAt(i) && name.charAt(i) <= 'Z') {
				wasCapital = true;
				if (wasUnderscore) {
					out.print("Error!");
					return;
				} else {
					newName.append('_');
					newName.append((char) (name.charAt(i) - 'A' + 'a'));
				}
			} else if ('a' <= name.charAt(i) && name.charAt(i) <= 'z') {
				if (name.charAt(i - 1) == '_') {
					newName.append((char) (name.charAt(i) - 'a' + 'A'));
				} else {
					newName.append(name.charAt(i));
				}
			} else {
				throw new Error();
			}
		}
		out.print(newName);
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
