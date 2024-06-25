import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main{
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();

        for(int n = 0; n < N; n++){
            int num = Integer.parseInt(br.readLine());
            list.add(num);
        }

        Collections.sort(list);

        long sum = 0;
        for(int i = 0; i < N; i++){
            sum += (Math.abs(list.get(i) - (i + 1)));
        }
        System.out.println(sum);
    }
}

