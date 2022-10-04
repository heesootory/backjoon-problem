import java.io.*;
import java.util.*;

public class Main {
    static String poliomino(String s){
        String ans = "";
        String A = "AAAA";
        String B = "BB";

        s = s.replaceAll("XXXX", A);       // 큰 문자열 먼저 교체
        ans = s.replaceAll("XX", B);       // 작은 문자열 교체

        if(ans.contains("X")) ans = "-1";       // 전부 교체하고도 X가 남아있다면 불가능!

        return ans;     // 끝
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String pole = br.readLine();

        String str = poliomino(pole);

        System.out.println(str);

    }
}