import java.io.*;
import java.util.*;

public class FindingNumber {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        int t = in.nextInt();
        while (t-->0){
            int n = in.nextInt(), m = in.nextInt();
            int[] ar = new int[n];
            for(int i=0;i<n;i++)
                ar[i]=in.nextInt();
            int pivot = findPivot(ar,0,ar.length-1);
            //System.out.println(pivot);
            int toRet = forwardBinary(ar, 0, pivot-1, m);
            if(toRet==-1)
                toRet=backwardBinary(ar, pivot, ar.length-1, m);
            //System.out.println(toRet);
            if(toRet==-1)
                System.out.println("OOPS! NOT FOUND");
            else
                System.out.println(toRet);
        }
    }
    static int backwardBinary(int[] ar, int l, int r, int k){

        if(l>r)
            return -1;
        if(l==r && ar[l]==k)
            return l;
        int mid = (l+r)/2;
        //System.out.println(l+" "+r);
        if(k==ar[mid])
            return mid;
        if(k>ar[mid])
            return backwardBinary(ar, l, mid-1, k);
        else
            return backwardBinary(ar, mid+1, r, k);
    }
    static int forwardBinary(int[] ar, int l, int r, int k){
        if(l>r)
            return -1;
        if(l==r && ar[l]==k)
            return l;
        int mid = (l+r)/2;
        if(k==ar[mid])
            return mid;
        if(k<ar[mid])
            return forwardBinary(ar, l, mid-1, k);
        else
            return forwardBinary(ar, mid+1, r, k);
    }
    static int findPivot(int[] ar, int l, int r){
        if(l>r)
            return -1;
        if(l==r)
            return l;
        int mid = (l+r)/2;
        if(mid>l && ar[mid]<ar[mid-1])
            return findPivot(ar, l, mid-1);
        return findPivot(ar, mid+1, r);
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