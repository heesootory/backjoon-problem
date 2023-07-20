import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
    int a, b;
    Node(int a, int b){
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Node o){
        return this.a - o.a;
    }
}

public class Main {
    static int N;
    static ArrayList<Node> list;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        list = new ArrayList<>();

        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new Node(a, b));
        }

        Collections.sort(list);

        Stack<Node> stack = new Stack<>();
        stack.push(list.get(0));
        for(int i = 1; i < list.size(); i++){
            Node node = list.get(i);
            if(node.a <= stack.peek().b && node.b > stack.peek().b) stack.peek().b = node.b;
            else if(node.a > stack.peek().b) stack.push(node);
        }

        int len = 0;
        while(!stack.isEmpty()){
            Node node = stack.pop();
            len += (node.b - node.a);
        }

        System.out.println(len);
    }

}
