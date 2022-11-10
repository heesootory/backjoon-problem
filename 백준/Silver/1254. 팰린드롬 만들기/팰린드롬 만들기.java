import java.io.*;
import java.util.*;


public class Main {
    static String str;
    static int len;
    static boolean isPalin(int start){
        int end = len - 1;
        while(start <= end){
            if(str.charAt(start) !=  str.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        str = br.readLine();
        len = str.length();
        for(int i = 0 ; i < len; i++){
            if(isPalin(i)){
                System.out.println(len + i);
                return;
            }
        }

    }
}