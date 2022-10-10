import java.io.*;
import java.util.*;


public class Solution{
    static int N, K;
    static int n;
    static int[] arr;
    static Set<Integer> set;
    static List<Integer> list;

    static void rotate(){
        int idx = N / 4;    // 3,2,1,0
        int sum = 0;
        for(int i = 0; i < N / 4; i++){ // 회전수
            // 시계 방향 회전
            int tmp = arr[N - 1];
            for(int j = N - 2; j >= 0; j--) arr[j + 1] = arr[j];
            arr[0] = tmp;

            // 구간마다 수를 구해서 저장.
            for(int a = 0; a < N; a++){
                idx--;
                sum += Math.pow(16, idx) * arr[a];
                if(idx == 0){
                    set.add(sum);
                    idx = N / 4;
                    sum = 0;
                }
            }
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            n = N / 4;
            arr = new int[N];
            set = new HashSet<>();
            list = new ArrayList<>();

            String str = br.readLine();
            for(int i = 0; i < N; i++){
                char c = str.charAt(i);
                if(c - '0' >= 0 && c - '0' < 10) arr[i] = c - '0';
                else arr[i] = c - 'A' + 10;
            }

            // N/4번 회전하면서, 구성할 수 있는 모든 수를 set에 저장.
            rotate();
            for(int i : set) list.add(i);
            Collections.sort(list);

            int ans = list.size() - K;

            System.out.printf("#%d %d\n", t, list.get(ans));

        }
    }
}