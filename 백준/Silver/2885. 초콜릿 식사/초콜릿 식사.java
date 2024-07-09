import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int choco = 1;
        while(choco < N){
            choco *= 2;
        }

        ArrayList<Integer> choList = new ArrayList<>();

        for(int i = choco; i >= 1; i /= 2){
            choList.add(i);
        }

        int divideN = N;
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < choList.size(); i++){
            int tmp = choList.get(i);
            if(tmp <= divideN){
                divideN -= tmp;
                list.add(tmp);
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i : list) {
            min = Math.min(min, i);
        }

        int ans = 0;
        while(min < choco){
            min *= 2;
            ans++;
        }

        System.out.println(choco + " " + ans);
    }
}

