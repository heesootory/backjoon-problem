import java.io.*;
import java.util.*;

public class Main{
    static int N, M;
    static ArrayList<Integer>[] adjList;
    static int[] inDegree;
    static void topologySort(){
        ArrayList<Integer> ansList = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i < N + 1; i++) {
            if(inDegree[i] == 0) queue.offer(i);
        }

        while(!queue.isEmpty()){
            int curr = queue.poll();
            ansList.add(curr);

            for(int i : adjList[curr]){
                if(--inDegree[i] == 0) queue.offer(i);
            }
        }

        for(int i  : ansList) System.out.print(i + " ");
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N + 1];
        for(int i = 0; i < N + 1; i++) adjList[i] = new ArrayList<>();
        inDegree = new int[N + 1];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjList[a].add(b);
            inDegree[b]++;
        }

        topologySort();


    }
}