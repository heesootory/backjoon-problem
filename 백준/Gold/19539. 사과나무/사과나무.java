import java.io.*;
import java.util.*;


public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        int possible2Day = 0;
        int sum = 0;
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            possible2Day += (arr[i] / 2);
        }

        int totalDay = sum / 3;

        System.out.println((sum % 3 == 0 && possible2Day >= totalDay) ? "YES" : "NO" );

    }
}

