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
            if(this.e == o.e) return this.s - o.s;
            else return this.e - o.e;
        }
    }
    static int N;
    static Queue<meeting> queue;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        queue = new PriorityQueue<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            queue.add(new meeting(start, end));
        }

        int cnt = 1;
        int norm = queue.poll().e;

        while(!queue.isEmpty()){
            meeting m = queue.poll();
            if(m.s >= norm){
                cnt++;
                norm = m.e;
            }
        }

        System.out.println(cnt);

    }
}