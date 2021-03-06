import java.util.*;
import java.io.*;

public class PartitionProblem {
    public static void main(String args[]) throws Exception {
        InputReader in = new InputReader(System.in);
        PrintWriter p = new PrintWriter(System.out);
        int n = in.nextInt();
        int[] ar = new int[n];
        int sum=0;
        for(int i=0;i<n;i++) {
            ar[i] = in.nextInt();
            sum+=ar[i];
        }
        Arrays.sort(ar);
        if(sum%2!=0)
            p.println(false);
        else {
            sum /= 2;
            boolean[][] dp = new boolean[n + 1][sum+1];
            for(int i=0;i<=n;i++)
                dp[i][0]=true;
            for (int j = 1; j <= sum; j++) {
                for (int i = 1; i <= n; i++) {
                    dp[i][j]=dp[i-1][j];
                    if (!dp[i][j] && j >= ar[i-1])
                        dp[i][j] = dp[i][j] || dp[i - 1][j - ar[i-1]];
                }
            }/*
            for(int j=0;j<=n;j++)
                for(int i=0;i<=sum;i++)
                    System.out.print(dp[j][i]+" ");*/
            p.println(dp[n][sum]);
        }
        p.flush();
        p.close();
    }
    static double func(double[][] dp, int n, int m,int k)
    {
        if(m==0){
            if(k==0) return 1;
            return 0;
        }
        if(k==0) return 0;
        if(dp[m][k]!=-1) return dp[m][k];
        double ans=0;
        for(int i=1;i<=n;i++)
        {
            if(k>=i)
                ans+=func(dp, n, m-1,k-i);
        }
        return dp[m][k]=ans;
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