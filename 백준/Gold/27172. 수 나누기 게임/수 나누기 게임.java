import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static final int INF = 1_000_001;
    static boolean[] cards;
    static int[] scores;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        cards = new boolean[INF];
        scores = new int[INF];
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            cards[num] = true;
            arr[i] = num;
        }

        for(int i = 0; i < N; i++){
            int idx = arr[i];

            for(int j = idx * 2; j < INF; j += idx){
                if(cards[j]){
                    scores[idx]++;
                    scores[j]--;
                }
            }
        }

        for(int i : arr) System.out.print(scores[i] + " ");

    }
}