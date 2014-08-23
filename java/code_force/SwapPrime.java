import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class SwapPrime {

    static StringTokenizer st;
    static BufferedReader br;
    static PrintWriter pw;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = nextInt();
        boolean[] prime = new boolean[n+1];
        Arrays.fill(prime, true);
        prime[1] = false;
        for (int i = 1; i*i <= n; i++) {
            if (prime[i]) {
                for (int j = i*i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }
        int[] indexOfIntegerN = new int[n+1];
        int[] inputArray = new int[n+1];
        for (int i = 1; i <= n; i++) {
            inputArray[i] = nextInt();
            indexOfIntegerN[inputArray[i]] = i;
        }

        int[]x = new int[5*n+1], y = new int[5*n+1];
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (indexOfIntegerN[i]==i)
                continue;
            int indexOfCurrInt = indexOfIntegerN[i];
            while (indexOfCurrInt > i) {
                for (int j = i; j < indexOfCurrInt; j++) {
                    if (prime[indexOfCurrInt-j+1]) {
                        cnt++;
                        x[cnt] = j;
                        y[cnt] = indexOfCurrInt;
                        indexOfIntegerN[inputArray[j]] = indexOfCurrInt;
                        inputArray[indexOfCurrInt] = inputArray[j];
                        indexOfCurrInt = j;
                        break;
                    }
                }
            }
        }
        pw.println(cnt);
        for (int i = 1; i <= cnt; i++) {
            pw.println(x[i]+" "+y[i]);
        }
        pw.close();
    }
    private static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
    private static long nextLong() throws IOException {
        return Long.parseLong(next());
    }
    private static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }
    private static String next() throws IOException {
        while (st==null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }
}