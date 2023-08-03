import java.io.*;
import java.util.*;

class Problem{
    int P, L;
    boolean recommend;
    Problem(int P, int L, boolean recommend){
        this.P = P;
        this.L = L;
        this.recommend = recommend;
    }
}

public class Main{
    static int n, m;
    static PriorityQueue<Problem> maxPQ;
    static PriorityQueue<Problem> minPQ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        minPQ = new PriorityQueue<>((o1, o2) -> {
            if(o1.L == o2.L) return o1.P - o2.P;
            return o1.L - o2.L;
        });
        maxPQ = new PriorityQueue<>((o1, o2) -> {
            if(o1.L == o2.L) return o2.P - o1.P;
            return o2.L - o1.L;
        });

        HashSet<Integer> solvedProblem = new HashSet<>();

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());
            maxPQ.add(new Problem(P, L, true));
            minPQ.add(new Problem(P, L, true));
        }

        StringBuilder sb = new StringBuilder();

        m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str =  st.nextToken();

            switch(str){
                case "add":
                    int P = Integer.parseInt(st.nextToken());
                    int L = Integer.parseInt(st.nextToken());
                    maxPQ.add(new Problem(P, L, false));
                    minPQ.add(new Problem(P, L, false));
                    break;
                case "recommend" :
                    int x = Integer.parseInt(st.nextToken());
                    PriorityQueue<Problem> pq = (x == 1) ? maxPQ : minPQ;
                    while(pq.peek().recommend && solvedProblem.contains(pq.peek().P)) pq.poll();
                    sb.append(pq.peek().P).append("\n");
                    break;
                case "solved" :
                    int sP = Integer.parseInt(st.nextToken());
                    solvedProblem.add(sP);
                    break;
            }
        }
        System.out.println(sb);
    }
}