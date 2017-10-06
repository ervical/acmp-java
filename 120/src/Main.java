import java.io.*;
import java.util.*;
 
public class Main {
 
    Scanner in;
    PrintWriter out;
 
    void solve() {
        int n = in.nextInt();
        int m = in.nextInt();
        int a[][] = new int[n][m];
        int b[][] = new int[n][m];
 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = in.nextInt();
            }
        }
 
        b[0][0] = a[0][0];
 
        for (int i = 1; i < n; i++) {
            b[i][0] = a[i][0] + b[i - 1][0];
        }
         
        for (int i = 1; i < m; i++) {
            b[0][i] = a[0][i] + b[0][i - 1];
        }
 
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                b[i][j] = a[i][j] + Math.min(b[i - 1][j], b[i][j - 1]);
            }
        }
        out.print(b[n-1][m-1]);
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