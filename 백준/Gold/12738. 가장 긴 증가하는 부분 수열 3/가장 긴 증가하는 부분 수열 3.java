import java.io.*;
import java.util.*;

/**
 *  최대 길이를 구하기 위한 최선의 방법. 
 *  ansList가 무조건 가장 긴 증가하는 부분수열로 저장되는 것은 아님.
 */

public class Main{
    static int N;
    static ArrayList<Integer> ansList;
    static int lower_bound(int num){
        int l = 0;
        int r = ansList.size();

        while(l < r){
            int mid = (l + r) / 2;

            if(ansList.get(mid) < num) l = mid + 1;
            else r = mid;
        }

        return r;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        ansList = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());

            int len = ansList.size();

            // 빈 배열시, 일단 그냥 추가.
            if(len == 0) ansList.add(num);
            else{
                // 마지막 원소보다 큰 수 라면, 뒤에 그냥 추가.
                if(num > ansList.get(len - 1)) ansList.add(num);
                else{       // 그게 아니라면, 리스트 내에서 lower_bound를 찾아 바꾸기.
                    ansList.set(lower_bound(num), num);
                }
            }
        }

        System.out.println(ansList.size());
    }
}