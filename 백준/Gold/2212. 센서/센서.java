import java.io.*;
import java.sql.Array;
import java.util.*;

class Pair implements Comparable<Pair>{
    int diff = 0;
    int index = 0;

    public Pair(int diff, int index){
        this.diff = diff;
        this.index = index;
    }

    @Override
    public int compareTo(Pair p){
        return p.diff - this.diff;
    }
}

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[] sensor = new int[N];
        Pair[] diffArr = new Pair[N-1];
        boolean[] checkArr = new boolean[N-1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            sensor[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sensor);
        for(int i = 0; i < N-1; i++){
            diffArr[i] = new Pair(sensor[i+1] - sensor[i], i);
        }

        Arrays.sort(diffArr);
        //for(Pair p : diffArr) System.out.print(p.index + " ");

        int cnt = 0;
        for(int i = 0; i < N-1; i++){
            if(cnt == K-1) break;
            int rIndex = diffArr[i].index;
            checkArr[rIndex] = true;
            cnt++;

//            if(rIndex == 0){
//                if(!checkArr[rIndex+1]) {
//                    checkArr[rIndex] = true;
//                    cnt++;
//                }
//            }else if(rIndex == N-2){
//                if(!checkArr[rIndex-1]){
//                    checkArr[rIndex] = true;
//                    cnt++;
//                }
//            }else{
//                if(!checkArr[rIndex-1] && !checkArr[rIndex+1]){
//                    checkArr[rIndex] = true;
//                    cnt++;
//                }
//            }
        }

        int ans = 0;
        for(int i = 0; i < N-1; i++){
            if(!checkArr[diffArr[i].index]) {
                ans += diffArr[i].diff;
            }
        }

//        for(boolean b : checkArr) System.out.print(b + " ");
//        System.out.println();
        System.out.println(ans);
    }
}

