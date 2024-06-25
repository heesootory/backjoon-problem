import java.io.*;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int a = 0;
        int b = 0;

        long time = 0;

        if(W * 2 < S) {
            time = (long)(X + Y) * W;
        }else{

            if(S < W){
                while(Math.abs(X-a) + Math.abs(Y-b) > 1){
                    if(a > X) {
                        a--; b++;
                        time += S;
                    }else if(b > Y){
                        a++; b--;
                        time += S;
                    }else{
                        a++; b++;
                        time += S;
                    }
                }
            }else{
                while(a < X && b < Y) {
                    a++;
                    b++;
                    time += S;
                }
            }

            time += ((long)Math.abs(X - a) * W);
            time += ((long)Math.abs(Y - b) * W);
        }

        System.out.println(time);
    }
}











