import java.io.*;
import java.util.*;
 
public class Main {
 
    Scanner in;
    PrintWriter out;
 
    void solve() {
        int sizeY = in.nextInt();
        int sizeX = in.nextInt();
        in.nextLine();
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        char field[][] = new char[sizeY][];
        for (int y = 0; y < sizeY; y++) {
            field[y] = in.nextLine().toCharArray();
        }
        for (int y = 0; y < sizeY; y++) {
            for (int x = 0; x < sizeX; x++) {
                if (field[y][x] == '*') {
                    maxX = Math.max(maxX, x);
                    minX = Math.min(minX, x);
                    maxY = Math.max(maxY, y);
                    minY = Math.min(minY, y);
                }
            }
        }
 
        for (int y = minY; y <= maxY; y++) {
            for (int x = minX; x <= maxX; x++) {
                if (field[y][x] == '.') {
                    field[y][x] = '*';
                }
            }
        }
 
        for (int y = 0; y < sizeY; y++) {
            for (int x = 0; x < sizeX; x++) {
                out.print(field[y][x]);
            }
            out.println();
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