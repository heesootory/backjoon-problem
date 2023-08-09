import java.io.*;
import java.util.*;

public class Main{
    static int N, M;
    static int[][] arr;
    static int[][] dp;
    static int[][] dir = {{-1, 0}, {0, -1}, {-1, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        dp = new int[N][M];

        for(int i = 0 ; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        int ans  =0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(arr[i][j] == 1){
                    boolean flag = true;
                    int min = 987654321;
                    for(int d = 0; d < 3; d++){
                        int next_x = i + dir[d][0];
                        int next_y = j + dir[d][1];

                        if(next_x < 0 || next_y < 0 || arr[next_x][next_y] == 0){
                            flag = false; break;
                        }
                        min = Math.min(min, dp[next_x][next_y]);
                    }
                    dp[i][j] = flag ? min + 1 : 1;
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }

        System.out.println(ans * ans);
    }
}