import java.io.*;
import java.util.*;


public class Main {
    static long a, b, c;
    static long pow(long a, long n){
        if(n == 1) return a % c;

        long tmp = pow(a, n/2) % c;

        if(n % 2 == 0) return tmp * tmp % c;
        else return ((tmp * tmp) % c * a) % c;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        System.out.println(pow(a, b));

    }
}