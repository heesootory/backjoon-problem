import java.io.*;
import java.util.*;


public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[] kayak = new int[N];
        int ans = 0;
        Arrays.fill(kayak, 1);

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < S; i++){
            int index = Integer.parseInt(st.nextToken())-1;
            kayak[index]--;
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < R; i++){
            int index = Integer.parseInt(st.nextToken())-1;
            kayak[index]++;
        }

        for(int i = 0; i < N-1; i++){
            if(kayak[i] == 0 &&  kayak[i+1] == 2){
                kayak[i]++;
                kayak[i+1]--;
            }
            else if(kayak[i] == 2 && kayak[i+1] == 0){
                kayak[i]--;
                kayak[i+1]++;
            }
        }

        for(int i = 0; i < N; i++){
            if(kayak[i] == 0) ans++;
        }
        System.out.println(ans);
    }
}

