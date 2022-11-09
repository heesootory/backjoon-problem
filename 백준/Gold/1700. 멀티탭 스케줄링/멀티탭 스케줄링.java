import java.io.*;
import java.util.*;

public class Main {

    static int num, plug, cnt;
    static int[] con, arr, con_check;
    static boolean check(int a){
        for(int i = 0; i < num; i++){   // 이미 꽃혀있는 경우
            if(con[i] == a) return true;
        }
        for(int i = 0; i < num; i++){
            if(con[i] == 0) {       // 빈 칸이 있을 때
                con[i] = a;
                return true;
            }
        }
        return false;
    }

    static void print(){
        for(int i : con){
            System.out.print(i + " ");
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        num = Integer.parseInt(st.nextToken());
        plug = Integer.parseInt(st.nextToken());

        con = new int[num];
        arr = new int[plug];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < plug; i++) arr[i] = Integer.parseInt(st.nextToken());

        cnt = 0;
        for(int i = 0; i < plug; i++){      // 나열된 물건들을 하나씩 조사
            if(check(arr[i])){
                continue;     // 콘센트에 이미 꽃혀있다면 넘어감.
            }
            else{               // 뭘 뽑을지 선택하기
                cnt++;
                con_check = new int[num];
                int flag = 0;
                int max = 0;
                for(int j = 0; j < num; j++){   // 콘센트에 꽃힌 물건들을 탐색하기
                    for(int k = i+1; k < plug; k++){      // 그 뒤에 나올 물건들 조사
                        if(con[j] == arr[k]) {      // 뒤에 또 나올 물건이라면, 일단 거리 저장.
                            con_check[j] = k;
                            if(con_check[j] > max) max = con_check[j];      //가장 먼거리 저장.
                            flag++;
                            break;
                        }
                    }
                    if(con_check[j] == 0){      // 뒤에 더 없는 물건이라면,
                        con[j] = arr[i];
                        break;
                    }
                }
                // 콘센트에 꽃힌 물건들 모두 뒤에 나온다면, 현 시점에서 가장 먼 거리에 있는 물건 뽑기.
                if(flag == num) {
                    for(int r = 0; r < num; r++){
                        if(con_check[r] == max) {
                            con[r] = arr[i]; break;
                        }
                    }
                }
            }
        }
        System.out.println(cnt);

    }
}