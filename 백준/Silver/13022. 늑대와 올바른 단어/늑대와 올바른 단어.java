import java.util.*;
import java.io.*;


public class Main{
    static ArrayList<Integer> words = new ArrayList<>();
    static String str;

    static boolean check(int idx, char c, int cnt){
        int count = 0;
        for(int i = idx; i < 50; i++){
            if(str.charAt(i) == c) count++;
            else break;
        }
        if(c == 'f'){
            if(str.charAt(idx + count) != 'w' && str.charAt(idx + count) != '.') {
                return false;
            }
        }
        return (cnt == count);
    }

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();
        str += ".";

        words.add(0);

        for(int i = 1; i < str.length(); i++){
            if(str.charAt(i-1) == 'f' && str.charAt(i) == 'w') words.add(i);
        }
        words.add(str.length()-1);

        boolean flag = true;
        for(int i = 0; i < words.size()-1; i++){
            int cnt = 0;
            int j = words.get(i);
            while(str.charAt(j) == 'w'){
                cnt++; j++;
            }

            flag = check(j, 'o', cnt);
            if(!flag) break;
            flag = check(j + cnt, 'l', cnt);
            if(!flag) break;
            flag = check(j + cnt*2, 'f', cnt);
            if(!flag) break;
        }

        System.out.println((flag) ? 1 : 0);

    }
}