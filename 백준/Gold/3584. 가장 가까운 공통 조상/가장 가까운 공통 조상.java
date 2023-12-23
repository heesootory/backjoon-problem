import java.io.*;
import java.util.*;

public class Main{
    static int T, N;
    static int Ans = -1;
    static int[] parents;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            N = Integer.parseInt(br.readLine());

            parents = new int[N + 1];
            visited = new boolean[N + 1];

            for(int n = 1; n < N; n++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                parents[b] = a;
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            int sun1 = Integer.parseInt(st.nextToken());
            int sun2 = Integer.parseInt(st.nextToken());

            while(sun1 != 0){
                visited[sun1] = true;
                sun1 = parents[sun1];
            }

            while(true) {
                if(visited[sun2]){
                    Ans = sun2;
                    break;
                }

                sun2 = parents[sun2];
            }

            System.out.println(Ans);


        }

    }
}