import java.io.*;
import java.util.*;


public class Main {
    static class Node{
        int num;
        Node left, right;

        Node(int num){
            this.num = num;
        }

        void insert(int n){
            if(n < this.num){
                if(this.left == null) this.left = new Node(n);
                else this.left.insert(n);
            }
            else{
                if(this.right == null) this.right = new Node(n);
                else this.right.insert(n);
            }
        }
    }

    static void PostOrder(Node node){
        if(node == null) return;
        PostOrder(node.left);
        PostOrder(node.right);
        System.out.println(node.num);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        Node root = new Node(Integer.parseInt(br.readLine()));

        while(true){
            String str = br.readLine();
            if(str == null || str.equals("")) break;

            int n = Integer.parseInt(str);
            root.insert(n);
        }
        PostOrder(root);
    }
}