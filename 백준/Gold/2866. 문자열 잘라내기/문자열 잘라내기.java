import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] charArr;

    static int check(int idx){
        HashSet<String> set = new HashSet<>();

        for(int i = 0; i < M; i++){
            String str = "";
            for(int j = idx; j < N; j++){
                str += charArr[j][i];
            }
            set.add(str);
        }

        return set.size();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        charArr = new char[N][M];
        for(int i = 0; i < N; i++) charArr[i] = br.readLine().toCharArray();

        int left = 0;
        int right = N - 1;
        int min = Integer.MAX_VALUE;
        while(left <= right){
            int mid = (left + right) / 2;
            if(check(mid) < M)  right = mid - 1;
            else {
                left = mid + 1;
                min = mid;
            }
        }

        System.out.println(min);

    }
}
