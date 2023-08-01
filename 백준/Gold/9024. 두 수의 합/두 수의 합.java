import java.io.*;
import java.util.*;


class Pair{
    int x, y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main{
    static int T, S, K;
    static int[] arr;
    static int minDiff;
    static int cnt;
    static void binerySearch(int idx){
        int num1 = arr[idx];
        int low = idx + 1;
        int high = S - 1;

        while(low <= high){
            int mid = (low + high) / 2;
            int num2 = arr[mid];
            int sum = num1 + num2;
            int diff = Math.abs(K - sum);

            if(diff == minDiff) cnt++;
            else if(diff < minDiff) {
                minDiff = diff;
                cnt = 1;
            }

            if(sum >= K) high = mid - 1;
            else low = mid + 1;

        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            minDiff = Integer.MAX_VALUE;
            StringTokenizer st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            arr = new int[S];
            for(int i = 0; i < S; i++) arr[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(arr);
            cnt = 0;

            for(int i = 0; i < S; i++){
                binerySearch(i);
            }

//            System.out.println("d : " + minDiff);
//            for(Pair p : list) System.out.print(p.x + " " + p.y + " /");
//            System.out.println();
            System.out.println(cnt);
//            System.out.println();

        }

    }
}