import java.io.*;
import java.util.*;


public class Main {

    static int N, H;
    static int[] bottom;
    static int[] top;
    static int[] sumArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        bottom = new int[H + 1];
        top = new int[H + 1];
        sumArr = new int[H + 1];

        for(int i = 1; i < N + 1; i++){
            int num = Integer.parseInt(br.readLine());
            if(i % 2 != 0) bottom[num]++;
            else top[H - num + 1]++;
        }

        for(int i = H - 1; i > 0; i--){
            bottom[i] += bottom[i + 1];
        }

        for(int i = 1; i < H + 1; i++){
            top[i] += top[i - 1];
        }

        int min = Integer.MAX_VALUE;
        for(int i = 1; i < H + 1; i++){
            sumArr[i] = bottom[i] + top[i];
            if(sumArr[i] < min) min = sumArr[i];
        }

        int cnt = 0;
        for(int i = 1; i < H + 1; i++){
            if(sumArr[i] == min) cnt++;
        }

        System.out.println(min + " " + cnt);

    }
}
