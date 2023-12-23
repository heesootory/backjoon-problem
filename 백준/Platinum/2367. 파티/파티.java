import java.io.*;
import java.util.*;

public class Main{
    static final int start = 0;
    static final int end = 1;
    static final int max = 305;
    static int N, D, K;
    static int[][] capacity;
    static int[][] flow;
    static ArrayList<Integer>[] adjList;
    static int networkFlow(int start, int end){
        int total = 0;

        int[] visited = new int[max];

        while(true){
            // 갈 수 있는 경로 찾기 - bfs
            Arrays.fill(visited, -1);
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(start);
            while(!queue.isEmpty()){
                int curr = queue.poll();
                for(int i = 0; i < adjList[curr].size(); i++){
                    int next = adjList[curr].get(i);
                    if(capacity[curr][next] - flow[curr][next] > 0 && visited[next] == -1){
                        queue.offer(next);
                        visited[next] = curr;
                        if(next == end) break;
                    }
                }
            }
            //  더 이상 갈 수 있는 경로가 없으면 종료.
            if(visited[end] == -1) break;

            // 뒤로 돌아가며 유량 개선. -> 음의 유량 고려하기.
            int left = 987654321;
            for(int i = end; i != start; i = visited[i]){
                left = Math.min(left, capacity[visited[i]][i] - flow[visited[i]][i]);
            }
            for(int i = end; i != start; i = visited[i]){
                flow[visited[i]][i] += left;
                flow[i][visited[i]] -= left;
            }

            total += left;
        }

        return total;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        capacity = new int[max][max];
        flow = new int[max][max];
        adjList = new ArrayList[max];
        for(int i = 0; i < max; i++) adjList[i] = new ArrayList<>();

        for(int n = 2; n < N + 2; n++){     // 사람의 종류
            adjList[start].add(n);         // 시작점 - 사람 연결
            adjList[n].add(start);
            capacity[start][n] = K;        // 사람이 가져올 수 있는 음식의 최대 갯수 (최대 용량)으로 초기화.
        }

        st = new StringTokenizer(br.readLine());
        for(int d = N + 2; d < N + D + 2; d++){         // 음식의 종류
            int maxFood = Integer.parseInt(st.nextToken());
            adjList[end].add(d);             // 음식의 종류 - 도착점 연결.
            adjList[d].add(end);
            capacity[d][end] = maxFood;        // 음식마다 가져올 수 있는 최대 갯수 (최대 용량)으로 초기화.
        }

        for(int i = 2; i < N + 2; i++){             // 사람의 종류
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());     // 사람마다 가져올 수 있는 음식의 종류의 갯수. -> 갈 수 있는 간선을 의미.
            for(int j = 0; j < num; j++){
                int sort = Integer.parseInt(st.nextToken());
                adjList[i].add(N + 1 + sort);              // 사람 - 음식의 종류 연결.
                adjList[N + 1 + sort].add(i);
                capacity[i][N + 1 + sort] = 1;          // 각 사람이 음식의 종류마다 가져올 수 있는 최대 갯수 1개(최대 유량)로 초기화
            }
        }

        System.out.println(networkFlow(start, end));

    }
}