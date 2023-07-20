import java.io.*;
import java.util.*;

class Circle implements Comparable<Circle>{
    char c;
    int x, num;

    Circle(char c, int x, int num){
        this.c = c;
        this.x = x;
        this.num = num;
    }

    @Override
    public int compareTo(Circle o) {
        return this.x - o.x;
    }
}

public class Main {
    static int N;
    static ArrayList<Circle> circles;
    static Stack<Circle> stack;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        circles = new ArrayList<>();

        StringTokenizer st;

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            circles.add(new Circle('(', a - b, a));
            circles.add(new Circle(')', a + b, a));
        }

        Collections.sort(circles);

        stack = new Stack<>();

        for(Circle c : circles){
            if(c.c == '(') stack.push(c);
            else{
                if(c.num != stack.peek().num){
                    System.out.println("NO");
                    return;
                }
                else stack.pop();
            }
        }

        System.out.println("YES");

    }

}
