import java.io.*;
import java.util.*;


class Node{
    int x, y;
    Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main{

    static int[][] way = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int time = 1;
    static int N, K, moveCnt;
    static boolean[][] arr;
    static Map<Integer, Character> map;
    static Deque<Node> deque;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        arr = new boolean[N][N];

        for(int k = 0; k < K; k++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x-1][y-1] = true;
        }

        moveCnt = Integer.parseInt(br.readLine());
        map = new HashMap<>();

        for(int m = 0; m < moveCnt; m++){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            map.put(t, c);
        }

        // 뱀게임 시작
        deque = new LinkedList<>();
        deque.add(new Node(0, 0));

        int wayPoint = 100;
        int wp = wayPoint % 4;
        while(true){

            // 앞으로 전진
            Node head = deque.peek();
            Node next = new Node(head.x + way[wp][0], head.y + way[wp][1]);
//            System.out.println("머리 위치 : " + head.x + " " + head.y);

            // 벽일때
            if(next.x < 0 || next.x >= N || next.y < 0 || next.y >= N) break;
            // 자기 몸일때
            boolean flag = false;
            for(Node n : deque){
                if(n.x == next.x && n.y == next.y) flag = true;
            }
            if(flag) break;

            // 사과가 있을때
            if(arr[next.x][next.y]) {
                deque.addFirst(next);
                arr[next.x][next.y] = false;
            }
            else{        // 사과가 없을때
                deque.pollLast();
                deque.addFirst(next);
            }

            // 시간이 맞을때
            if(map.containsKey(time)) {
                if(map.get(time) == 'D') wayPoint++;
                else wayPoint--;
            }
            wp = wayPoint % 4;
//            System.out.print("시간 : " + time + " / ");
//            System.out.print("뱀 길이 : " + deque.size() + " / ");
            time++;
        }

        System.out.println(time);

    }
}