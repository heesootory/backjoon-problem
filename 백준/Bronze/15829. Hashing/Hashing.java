import java.io.*;
import java.util.*;

public class Main{
    static int L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        L = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int ans = 0;
        int mod = 1234567891;
        for(int i = 0; i < L; i++){
            int a = str.charAt(i) - 'a' + 1;
            int r = (int)((long)Math.pow(31, i) % mod);
            int ar = a * r % mod;
            ans = (int)((ans + ar) % mod);
        }

        System.out.println(ans % mod);

    }
}