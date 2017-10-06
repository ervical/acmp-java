import java.io.*; 
import java.util.*;

public class Main {
 
    Scanner in;
    PrintWriter out;
 
    // max(a, b, c) = max(a, max(b, c))
    void solve() {
    	out.write(in.nextBigInteger().max(in.nextBigInteger().max(in.nextBigInteger())).toString());
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