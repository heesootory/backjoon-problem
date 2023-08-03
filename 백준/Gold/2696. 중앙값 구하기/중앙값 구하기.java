import java.io.*;
import java.util.*;


public class Main{

    static int T,  M;
    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            M = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            System.out.println(M/2 + 1);
            int m = 0;
            while(true){
                StringTokenizer st = new StringTokenizer(br.readLine());
                boolean b = false;
                for(int i = 0; i < 10; i++){
                    list.add(Integer.parseInt(st.nextToken()));
                    m++;
                    if(m % 2 != 0){
                        Collections.sort(list);
                        System.out.print(list.get(m/2) +  " ");
                    }

                    if(m == M) {
                        b = true; break;
                    }
                }
                if(b) break;
            }

//            for(int i : list) System.out.print(i + " ");
            System.out.println();





        }


    }
}