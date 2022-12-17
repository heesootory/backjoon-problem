import java.io.*;
import java.util.*;


public class Main{
    static final int row = 0;
    static final int column = 1;
    static final int diagonal = 2;
    static int[][] arr;
    static long[][][] memo;      // 0 : 가로, 1 : 상하, 2 : 대각.
    static int n;
    static long DFS(int way, int x, int y){
        // 도착 시점.
        if(x == n-1 && y == n-1) return 1;
        // memo 활용할 때
        if(memo[way][x][y] != 0) return memo[way][x][y];

        // memo 값이 없을 때.
        long result = 0;     // 현재 노드에서 갈수 있는 가짓 수들의 총합!!

        switch(way){
            case row:   // 가로 -> 가로
                if(y < n-1 && arr[x][y+1] == 0 ) result += DFS(row, x, y+1);
                break;
            case column:    // 세로 -> 세로
                if(x < n-1 && arr[x+1][y] == 0) result += DFS(column, x+1, y);
                break;
            case diagonal:  // 대각 -> 가로, 세로
                if(y < n-1 && arr[x][y+1] == 0 ) result += DFS(row, x, y+1);
                if(x < n-1 && arr[x+1][y] == 0) result += DFS(column, x+1, y);
                break;
        }
        // 가로, 세로, 대각 -> 대각.
        if(x < n-1 && y < n-1 && arr[x+1][y+1] == 0 && arr[x+1][y] == 0 && arr[x][y+1] == 0) result += DFS(diagonal, x+1, y+1);

        memo[way][x][y] = result;
        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        arr = new int[n][n];
        memo = new long[3][n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long ans = DFS(row, 0, 1);
        System.out.println(ans);
    }
}