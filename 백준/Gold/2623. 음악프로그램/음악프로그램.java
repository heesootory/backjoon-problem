import java.io.*;
import java.util.*;

public class Main{
    static int N, M;
    static int[] inDegree;
    static ArrayList<Integer>[] adjList;
    static ArrayList<Integer> ansList;
    static void topologySort(){
        ansList = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i < N + 1; i++){
            if(inDegree[i] == 0) queue.offer(i);
        }

        while(!queue.isEmpty()){
            int curr = queue.poll();
            ansList.add(curr);
            for(int i : adjList[curr]){
                if(--inDegree[i] == 0) queue.offer(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        inDegree = new int[N + 1];
        adjList = new ArrayList[N + 1];
        for(int i = 0; i < N + 1; i++) adjList[i] = new ArrayList<>();

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int[] arr = new int[num];
            for(int j = 0; j < num; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            for(int k = 0; k < num - 1; k++){
                int from = arr[k];
                int to = arr[k + 1];
                inDegree[to]++;
                adjList[from].add(to);
            }
        }

        topologySort();
        if(ansList.size() != N) System.out.println(0);
        else for(int i : ansList) System.out.println(i);
    }
}