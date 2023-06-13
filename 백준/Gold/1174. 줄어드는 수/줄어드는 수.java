import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N;
    static int[] arr = {9,8,7,6,5,4,3,2,1,0};
    static List<Long> list;

    // 만들 수 있는 수 모조리 만들어서 list에 담기.
    static void dfs(int idx, long num){
        if(!list.contains(num)) list.add(num);

        if(idx >= 10) return;

        dfs(idx + 1, (num * 10) + arr[idx]);
        dfs(idx + 1, num);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();

        dfs(0, 0);
        Collections.sort(list);

        int len = list.size();
        System.out.println((N > len) ? -1 : list.get(N-1));

    }
}
