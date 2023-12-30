import java.io.*;
import java.util.*;

public class Main{
    static int N, M, K;
    static int[] candy, parents;
    static int[][] groupInfo, dp;
    static ArrayList<Integer> groupList;
    static void make(){
        for(int i = 0; i < N + 1; i++){
            parents[i] = i;
        }
    }
    static int find(int a){
        if(parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }
    static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot == bRoot) return false;

        if(bRoot < aRoot) parents[aRoot] = bRoot;
        else parents[bRoot] = aRoot;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        candy = new int[N + 1];
        parents = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N + 1; i++) {
            candy[i] = Integer.parseInt(st.nextToken());
        }

        make();

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            union(num1, num2);
        }

        groupList = new ArrayList<>();
        for(int i = 1; i < N + 1; i++){
            parents[i] = find(i);
            if(parents[i] == i) groupList.add(i);
        }

        groupInfo = new int[2][N + 1];      // [0]아이 수, [1]사탕 수
        for(int i = 1; i < N + 1; i++){
            groupInfo[0][parents[i]]++;
            groupInfo[1][parents[i]] += candy[i];
        }

        // dp
        int len = groupList.size();
        dp = new int[len + 1][K];

        for(int i = 1; i < len + 1; i++){
            int group = groupList.get(i - 1);
            int children = groupInfo[0][group];
            int candies = groupInfo[1][group];

            for(int j = 0; j < K; j++){
                if(children <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - children] + candies);
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[len][K - 1]);

    }
}