import java.io.*;
import java.util.*;



public class Main{
    static int N, M;
    static int[] prices;
    static int binerySearch(int num){
        int idx = -1;
        int low = 0;
        int high = N - 1;

        while(low <= high){
            int mid = (low + high) / 2;

            if(prices[mid] > num) high = mid - 1;
            else if(prices[mid] == num) {
                idx = mid;
                return idx;
            }
            else low = mid + 1;
        }

        return idx;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        prices = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            prices[i] = Integer.parseInt(st.nextToken());
            if(prices[i] == M) {
                System.out.println(1); return;
            }
        }

        Arrays.sort(prices);

        for(int i = 0; i < N; i++){
            int find = binerySearch(M - prices[i]);
            if(find > -1 && find != i) {
                System.out.println(1);
                return;
            }
        }

        for(int i = 0; i < N - 1; i++){
            for(int j = i + 1; j < N; j++){
                int sum = prices[i] + prices[j];
                int find = binerySearch(M - sum);
                if(find > -1 && find != i && find != j) {
                    System.out.println(1);
                    return;
                }
            }
        }

        System.out.println(0);

    }
}