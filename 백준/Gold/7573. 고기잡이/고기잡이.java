import java.util.*;
import java.io.*;

class Point{
    int x, y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main{
    static int N, I, M;
    static int answer;
    static ArrayList<Point> fishes;
    static void fishing(int x, int y){
        int half = I / 2;

        for(int a = 1; a < half; a++){
            int b = half - a;

//            if(x + a >= N || y + b >= N) continue;

            int sum = 0;
            for(Point p : fishes){
                if(x <= p.x && p.x <= x + a && y <= p.y && p.y <= y + b) sum++;
            }

            if(sum > answer) answer = sum;
        }
    }
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        I = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        fishes = new ArrayList<>();

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            fishes.add(new Point(x - 1, y - 1));
        }

        for(int i = 0; i < M; i++){
            for(int j = 0; j < M; j++){
                fishing(fishes.get(i).x, fishes.get(j).y);
            }
        }

        System.out.println(answer);

    }
}