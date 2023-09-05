import java.io.*;
import java.util.*;


public class Main {
    static String number;
    static char[] arr;
    static int len;
    static HashSet<String> set;
    static void dfs(int s_idx, int e_idx, String str){
        if(s_idx == 0 && e_idx == len - 1){
            set.add(str);
            return;
        }

        if(s_idx > 0) dfs(s_idx - 1, e_idx, str + number.substring(s_idx, e_idx + 1));
        if(e_idx < len - 1) dfs(s_idx, e_idx + 1, str + number.substring(s_idx, e_idx + 1));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        number = br.readLine();
        arr = number.toCharArray();
        len = arr.length;
        set = new HashSet<>();

        for(int i = 0; i < len; i++) dfs(i, i, "");

        System.out.println(set.size());

    }
}
