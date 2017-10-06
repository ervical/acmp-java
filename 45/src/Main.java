import java.io.*;
import java.util.*;
 
public class Main {
 
    Scanner in;
    PrintWriter out;
 
    void solve() {
        int n = in.nextInt();
        if (n == 0) {
            out.print(10);
            return;
        } else if (n == 1) {
            out.print(1);
            return;
        }
        int[] count = new int[10];
        for (int i = 9; i >= 2; i--) {
            while (n % i == 0) {
                count[i]++;
                n /= i;
            }
        }
        if (n != 1) {
            out.print(-1);
        } else {
            for (int i = 2; i <= 9; i++) {
                for (int j = 0; j < count[i]; j++) {
                    out.print(i);
                }
            }
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