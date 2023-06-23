import java.util.*;
import java.io.*;

class Coin{
    int price;
    public Coin(int price){
        this.price = price;
    }
}

public class Main{
    static int T, K;
    static int[][] dp;
    static Coin[] coin;
    static HashMap<Coin, Integer> map;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        coin = new Coin[K+1];
        dp = new int[K+1][T+1];

        for(int i = 1; i < K+1; i++) {
            st = new StringTokenizer(br.readLine());
            coin[i] = new Coin(Integer.parseInt(st.nextToken()));
            int count = Integer.parseInt(st.nextToken());
            map.put(coin[i], count);
        }

//        Arrays.sort(coin);

        for(int i = 1; i < K + 1; i++){
            for(int j = coin[i].price; j < T + 1 && j <= coin[i].price * map.get(coin[i]); j+=coin[i].price){
                dp[i][j] = 1;
            }
        }

        for(int i = 1; i < K + 1; i++){
            for(int j = 1; j < T + 1; j++){
                int sum = dp[i][j];
                int cnt = map.get(coin[i]);
                for(int k = j; k >= 0; k -= coin[i].price){
                    sum += dp[i-1][k];
                    cnt--;
                    if(cnt < 0) break;
                }
                dp[i][j] = sum;
            }
        }

//        for(int i = 0; i < K + 1; i++){
//            for(int j = 0; j < T + 1; j ++){
//                System.out.print(dp[i][j]);
//            }
//            System.out.println();
//        }
        System.out.println(dp[K][T]);
    }
}