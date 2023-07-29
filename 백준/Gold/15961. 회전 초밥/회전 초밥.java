import java.io.*;
import java.util.*;

public class Main{
    static int N, d, k, c, cnt;
    static int[] arr;
    static Set<Integer> dishes;
    static int[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        dishes = new HashSet<>();
        visited = new int[d+1];

        for(int i = 1; i < N + 1; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 처음 c개를 고른 경우
        for(int i = 1; i < k + 1; i++) {
            dishes.add(arr[i]);
            visited[arr[i]]++;

            cnt = Math.max(cnt , dishes.contains(c) ? dishes.size() : dishes.size() + 1);
        }

        // 이후 c 개를 고르는 경우.
        for(int i = 1, j = k+1; i < N + 1; i++, j++){
            int start = arr[i];
            int end = arr[(j == N) ? N : j % N];

            visited[start]--;
            if(visited[start] == 0) dishes.remove(start);
            visited[end]++;
            dishes.add(end);

            cnt = Math.max(cnt, dishes.contains(c) ? dishes.size() : dishes.size() + 1);

        }

        System.out.println(cnt);
    }
}