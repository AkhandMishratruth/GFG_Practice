import java.util.*;
import java.io.*;

public class  Box_Stacking {
    public static void main(String args[]) throws Exception {
        InputReader in = new InputReader(System.in);
        PrintWriter p = new PrintWriter(System.out);
        int n = in.nextInt();
        Box[] bo = new Box[3*n];
        int a,b,c;
        for(int i = 0;i<3*n;i+=3) {
            a=in.nextInt();b=in.nextInt();c=in.nextInt();
            bo[i] = new Box(Math.max(a,b),Math.min(a,b),c);
            bo[i+1] = new Box(Math.max(b,c),Math.min(b,c),a);
            bo[i+2] = new Box(Math.max(c,a),Math.min(c,a),b);
        }
        int[] ref = new int[3*n];
        Arrays.sort(bo, Box.com);
        int[] sol = new int[3*n];
        for(int i =0;i<3*n;i++)
            sol[i]=bo[i].h;
        //sol[0]=bo[0].h;
        for(int i = 1;i<3*n;i++){
            for(int j=0;j<i;j++){
                if(bo[i].l>bo[j].l && bo[i].w>bo[j].w && sol[i]<sol[j]+bo[i].h) {
                    sol[i] = sol[j] + bo[i].h;
                    ref[i]=j;
                }
            }
        }
        int ind=0,ma = -1;
        for(int i=0;i<sol.length;i++) {
            ma = Math.max(ma, sol[i]);
            ind = i;
        }
        p.println(ma);
        while(ind!=0){
            p.println(bo[ind].w+" "+bo[ind].l+" "+bo[ind].h);
            ind=ref[ind];
        }
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
class Box {
    int l, w, h;

    Box(int le, int wi, int hi) {
        l = le;
        w = wi;
        h = hi;
    }
    static Comparator<Box> com = new Comparator<Box>() {
        @Override
        public int compare(Box o1, Box o2) {
            return -1*(o2.l*o2.w-o1.l*o1.w);
        }
    };
}