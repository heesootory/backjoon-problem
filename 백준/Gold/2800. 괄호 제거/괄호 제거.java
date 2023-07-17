import java.awt.*;
import java.io.*;
import java.util.*;

class Node{
    char c;
    int num;

    Node(char c, int num){
        this.c = c;
        this.num = num;
    }
}

public class Main {
    static String str;
    static Node[] nodes;
    static Stack<Node> stack;
    static int count;
    static boolean[] visited;
    static ArrayList<Integer> list;
    static TreeSet<String> tset;

    static String make(){
        String ans = "";
        for(Node node : nodes){
            if(node.num == -1 || list.contains(node.num)) ans += node.c;
        }
        return ans;
    }
    static void subset(int idx, int cnt){
        if(idx == count){
            list = new ArrayList<>();
            for(int i = 0; i < count; i++){
                if(visited[i]) list.add(i);
            }
            tset.add(make());
            return;
        }

        visited[idx] = true;
        subset(idx + 1, cnt + 1);
        visited[idx] = false;
        subset(idx + 1, cnt);

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();

        nodes = new Node[str.length()];
        tset = new TreeSet<>();
        stack = new Stack<>();

        for(int i = 0, j = 0; i < str.length(); i++){
            char ch = str.charAt(i);

            if(ch == '('){
                count++;
                Node node = new Node(ch, j);
                stack.push(node);
                nodes[i] = node;
                j++;
            }else if(ch == ')'){
                Node node = new Node(ch, stack.pop().num);
                nodes[i] = node;
            }else {
                Node node = new Node(ch, -1);
                nodes[i] = node;
            }
        }

        visited = new boolean[count];

        if(count == 0) {
            System.out.println(str); return;
        }

        subset(0, 0);

        for(String s : tset) {
            if(!s.equals(str) && !s.equals("")) System.out.println(s);
        }

    }

}
