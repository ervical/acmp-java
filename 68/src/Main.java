import java.io.*;
import java.util.*;
 
public class Main {
 
    Scanner in;
    PrintWriter out;
 
    void solve() {
        String place = in.next();
        int trips = in.nextInt();
        if ((place.compareTo("School") == 0) && (trips % 2 == 0)) {
            out.print("No");
        } else {
            out.print("Yes");
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