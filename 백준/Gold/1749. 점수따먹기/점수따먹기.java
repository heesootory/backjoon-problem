import java.io.*;
import java.util.*;



public class Main{
    static int n, m;
    static int[][] arr;
    static int[][] sumArr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n+1][m+1];
        sumArr = new int[n+1][m+1];

        for(int i = 1; i < n + 1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < m + 1; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(i == 1 && j == 1) sumArr[i][j] = arr[i][j];
                else if(i == 1) sumArr[i][j] = sumArr[i][j - 1] + arr[i][j];
                else if(j == 1) sumArr[i][j] = sumArr[i - 1][j] + arr[i][j];
                else sumArr[i][j] = arr[i][j] + sumArr[i - 1][j] + sumArr[i][j - 1] - sumArr[i - 1][j - 1];
            }
        }
        int max = Integer.MIN_VALUE;
        for(int a = 0; a < n + 1; a++){
            for(int b = a + 1; b < n + 1; b++){
                for(int c = 0; c < m + 1; c++){
                    for(int d = c + 1; d < m + 1; d++){
                        int sum = sumArr[b][d] - sumArr[a][d] - sumArr[b][c] + sumArr[a][c];
                        if(sum > max) max = sum;
                    }
                }
            }
        }

        System.out.println(max);
    }
}