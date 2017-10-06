import java.io.*;
import java.util.*;
 
public class Main {
 
    Scanner in;
    PrintWriter out;
 
    void solve() {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = 1;
        }
        b[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i - 1; j++) {
                if (a[j] < a[i] && b[i] < b[j] + 1) {
                    b[i] = b[j] + 1;
                }
            }
 
        }
        Arrays.sort(b);
        out.println(b[n - 1]);
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