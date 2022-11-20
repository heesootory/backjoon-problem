import java.io.*;
import java.util.*;


public class Main {
    static int k;
    static int[] s;
    static int[] ans;
    static void comb(int idx, int start){
       if(idx == 6){
           for(int i : ans) System.out.print(i + " ");
           System.out.println();
           return;
       }

       for(int i = start; i < k; i++){
           ans[idx] = s[i];
           comb(idx + 1, i + 1);
       }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if(k == 0) break;

            ans = new int[6];
            s = new int[k];
            for(int i = 0; i < k; i++) s[i] = Integer.parseInt(st.nextToken());

            comb(0, 0);
            System.out.println();
        }
    }
}




