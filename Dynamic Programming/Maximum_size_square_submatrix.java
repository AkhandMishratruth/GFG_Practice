import java.util.*;
import java.io.*;

public class  Maximum_size_square_submatrix {
    public static void main(String args[]) throws Exception {
        InputReader in = new InputReader(System.in);
        PrintWriter p = new PrintWriter(System.out);
        int n = in.nextInt(), m =in.nextInt();
        int[][] ar = new int[n][m];
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                ar[i][j]=in.nextInt();
        int[][] sub = new int[n][m];
        for(int i=0;i<n;i++)
            sub[i][0]=ar[i][0];
        for(int i=0;i<m;i++)
            sub[0][i]=ar[0][i];
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(ar[i][j]==1)
                    sub[i][j]=Math.min(sub[i][j-1],Math.min(sub[i-1][j],sub[i-1][j-1]))+1;
            }
        }
        int max = -1,mi=0,mj=0;
        for(int i=0;i<n;i++) {
            for (int j = 0; j < m; j++) {
                if (max < sub[i][j]) {
                    max = sub[i][j];
                    mi = i;
                    mj = j;
                }
            }
        }
        String from1 = Integer.toString(mi-max), from2 = Integer.toString(mj-max), to1=Integer.toString(mi),to2=Integer.toString(mj);
        p.println("from : ("+from1+", "+from2+") to "+"( "+to1+", "+to2+") ");
        p.flush();
        p.close();
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