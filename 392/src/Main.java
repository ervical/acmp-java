import java.util.*;
import java.io.*;

class Main {
	
	static class Assert {
		static void check(boolean e){
			if(!e){
				throw new Error();
			}
		}
	}
	
	static class Scanner{
		StreamTokenizer in;
		
		Scanner(Reader r) {
			in = new StreamTokenizer(new BufferedReader(r));
			in.resetSyntax();
			in.whitespaceChars(0, 32);
			in.wordChars(33,255);
		}
		
		Scanner(InputStream is) {
			this(new InputStreamReader(is));
		}
		
		String next(){
			try{
				in.nextToken();
				Assert.check(in.ttype == in.TT_WORD);
				return in.sval;
			} catch (IOException e) {
				throw new Error(e);
			}
		}
		int nextInt(){
			return Integer.parseInt(next());
		}
	}
	
	Scanner in;
	PrintWriter out;
	
	void solve(){
		int n = in.nextInt();
		int a[] = new int[n];
		int ind = -1;
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
			if (a[i] == 1) {
				ind = i;
			}
		}
		for (int i = ind; i < n; i++) {
			out.print(a[i] + " ");
		}
		for (int i = 0; i < ind; i++) {
			out.print(a[i] + " ");
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
