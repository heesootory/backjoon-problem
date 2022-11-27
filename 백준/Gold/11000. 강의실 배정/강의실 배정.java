import java.io.*;
import java.util.*;

public class Main {
    static class lec{
        int start;
        int end;
        lec(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    static int N;
    static PriorityQueue<Integer> pq;
    static PriorityQueue<lec> input;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>();
        input = new PriorityQueue<>(new Comparator<lec>() {
            @Override   // 시작시간이 빠른순으로 오름차순
            public int compare(lec o1, lec o2) {
                return o1.start - o2.start;
            }
        });

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            lec lecture = new lec(a, b);
            input.add(lecture);
        }

        pq.add(input.poll().end);

        for(int i = 0; i < N -1; i++){
            lec next = input.poll();

            // 기존에 다음 들어올 수업의 시작시간보다 종료시간이 더 작은게 있다면, 빼버리고
            if(pq.peek() <= next.start) pq.poll();
            // 다음 수업시간은 무조건 포함됨.(종료시간으로 기록되서)
            pq.add(next.end);
        }
        System.out.println(pq.size());
    }
}