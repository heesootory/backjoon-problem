import java.io.*;
import java.util.*;

public class Main {
    static class Pair{
        int x, y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static final int len = 9;
    static int[][] arr;
    static List<Pair> list;
    static boolean flag = false;
    static void print(){
        for(int[] i : arr){
            for(int j : i) System.out.print(j);
            System.out.println();
        }
    }

    static boolean check(Pair p, int n){
        for(int j = 0; j < 9; j++){
            if(arr[p.x][j] == n) return false;
        }

        for(int i = 0 ; i < 9; i++){
            if(arr[i][p.y] == n) return false;
        }

        int a = p.x / 3;
        int b = p.y / 3;
        for(int i = a*3; i < (a+1)*3; i++){
            for(int j = b*3; j < (b+1)*3; j++){
                if(arr[i][j] == n) return false;
            }
        }
        return true;
    }

    static void dfs(int idx){
        if(flag) return;
        if(idx == list.size()){
            print();
            flag = true;
            return;
        }

        //back
        Pair now = list.get(idx);
        for(int i = 1; i <= 9; i++){
            if(!check(now, i)) continue;
            arr[now.x][now.y] = i;
            dfs(idx + 1);
            arr[now.x][now.y] = 0;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        arr = new int[len][len];
        list = new ArrayList<>();

        for(int i =0 ; i < len; i++){
            String str = br.readLine();
            for(int j = 0; j < len; j++){
                arr[i][j] = str.charAt(j) - '0';
                if(arr[i][j] == 0) list.add(new Pair(i, j));
            }
        }

        dfs(0);

    }
}