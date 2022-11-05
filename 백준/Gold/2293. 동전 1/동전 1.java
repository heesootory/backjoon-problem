import java.io.*;
import java.util.*;


public class Main {
    static int n, money;
    static int[] coins;
    static int[][] arr;

    static void print(){
        for(int[] i : arr){
            for(int j : i) System.out.print(j + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        money = Integer.parseInt(st.nextToken());
        coins = new int[n];
        arr = new int[n][money + 1];

        for(int i = 0; i < n; i++) coins[i] = Integer.parseInt(br.readLine());

        // 초기화
        arr[0][0] = 1;

        for(int j = 1; j < money + 1; j++){
            for(int i = 0; i < n; i++){
                int coin = coins[i];
                if(j - coin < 0) continue;
                int sum = 0;
                for(int k = 0; k <= i; k++) sum += arr[k][j - coin];
                arr[i][j] = sum;
            }
        }

        int ans = 0;
        for(int i = 0; i < n; i++) ans += arr[i][money];
        System.out.println(ans);

    }
}