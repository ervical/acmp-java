import java.io.*;
import java.util.*;
 
public class Main {
    Scanner in;
    PrintWriter out;
 
    void solve() {
        int n = in.nextInt();
        int score[] = new int[2];
        Deque<Integer> deque = new ArrayDeque<Integer>();
        for (int i = 0; i < n; i++) {
            deque.add(in.nextInt());
        }
        for (int i = 0; i < n; i++) {
            int first = deque.getFirst();
            int last = deque.getLast();
            if (first < last) {
                score[i % 2] += last;
                deque.removeLast();
            } else {
                score[i % 2] += first;
                deque.removeFirst();
            }
        }
        out.print(score[0] + ":" + score[1]);
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