import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class ProbabilityKnightRemainChessboard {
    static double[][][] dp;
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        int x = in.nextInt(), y = in.nextInt(), k = in.nextInt();
        dp = new double[8][8][k+1];
        System.out.println(chessWays(x,y,k));
    }

    static double chessWays(int x, int y, int k) {
        if (x < 0 || y < 0 || x >= 8 || y >= 8)
            return 0;
        if (k == 0)
            return 0;
        if (dp[x][y][k] != 0)
            return dp[x][y][k];
        int[] xSteps = {1, -1, 1, -1, 2, 2, -2, -2};
        int[] ySteps = {2, 2, -2, -2, 1, -1, 1, -1};
        double toRet = 0;
        if(k==1){
            for (int i = 0;i<xSteps.length;i++){
                if (!(x+xSteps[i] < 0 || y+ySteps[i] < 0 || x+xSteps[i] >= 8 || y+ySteps[i] >= 8))
                    toRet++;
            }
            toRet/=8.0;
            return dp[x][y][k]=toRet;
        }
        for (int i = 0;i<xSteps.length;i++){
            toRet+=chessWays(x+xSteps[i], y+ySteps[i],k-1);
        }
        dp[x][y][k]=toRet/8.0;
        return toRet/8.0;
    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1)
                throw new InputMismatchException();

            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }

                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public String nextLine() {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        public int nextInt() {
            int c = read();

            while (isSpaceChar(c))
                c = read();

            int sgn = 1;

            if (c == '-') {
                sgn = -1;
                c = read();
            }

            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));

            return res * sgn;
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;

            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));
            return res * sgn;
        }

        public double nextDouble() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E')
                    return res * Math.pow(10, nextInt());
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E')
                        return res * Math.pow(10, nextInt());
                    if (c < '0' || c > '9')
                        throw new InputMismatchException();
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            }
            while (!isSpaceChar(c));

            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }
}