import java.io.*;
import java.util.*;

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
            if(len == 0) ansList.add(num);
            else{
                if(num > ansList.get(len - 1)) ansList.add(num);
                else{
                    ansList.set(lower_bound(num), num);
                }
            }
        }

//        for(int i : ansList) System.out.print(i + " ");
//        System.out.println();
        System.out.println(ansList.size());

    }
}