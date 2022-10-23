import java.io.*;
import java.util.*;

public class Main{
    static class meeting implements Comparable<meeting>{
        int s, e;
        meeting(int s, int e){
            this.s = s;
            this.e = e;
        }
        @Override
        public int compareTo(meeting o){
            // 시작시간이 작은것부터 오름차순, 시작시간이 같다면 끝나는 시간이 작은것 순으로 오름차순
            if(this.s == o.s) return this.e - o.e;
            else return this.s - o.s;
        }
    }
    static int N;
    static Queue<meeting> queue;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        queue = new PriorityQueue<>();
        arr = new int[100000];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            queue.add(new meeting(start, end));
        }

        arr[0] = queue.poll().e;
        int max = 0;

        while(!queue.isEmpty()){
            meeting m = queue.poll();
            for(int i = 0; i < arr.length; i++) {
                if (arr[i] <= m.s) {
//                    System.out.println(i);
                    if(max < i) max = i;
                    arr[i] = m.e;
                    break;
                }
            }
        }

        System.out.println(max + 1);
    }
}