import java.io.*;
import java.util.*;

public class Main{
    static int N, M, L;
    static int[] arr;
    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        arr = new int[N+2];
        arr[N+1] = L;

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N+1; i++) arr[i] = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        Arrays.sort(arr);

        for(int i = 1; i < N + 2; i++) list.add(arr[i] - arr[i-1]);
        Collections.sort(list);

//        for(int i : list) System.out.print(i + " ");

        int low = 1;
        int high = list.get(list.size() - 1);
        int min = 123456789;

        while(low <= high){
            int mid = (low + high) / 2;
            int cnt = 0;
            for(int i : list) cnt += ((i-1) / mid);

            if(cnt <= M){
                high = mid - 1;
                if(mid < min) min = mid;
            }
            else low = mid + 1;

        }

        System.out.println(min);

    }


}