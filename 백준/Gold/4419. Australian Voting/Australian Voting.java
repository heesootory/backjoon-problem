import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N;               // 후보자 수
    static int left;            // 남은 후보자 수
    static int voter;           // 투표자 수
    static int selected_num;        // 선출되기 위한 최소 득표수
    static String[] names;      // 후보자 배열 선언
    static boolean[] fails;       // 후보자 탈락 유무 배열 선언.
    static int[] results;           // 득표수 배열.
    static Queue<Integer>[] voteList;       // 선호도 결과를 받을 큐배열 선언

    /**
     * 결과를 확인하는 함수
     * @return
     * 0 ~ 19 : 선출된 후보자를 리턴
     * 20 : 후보자 모두 투표수가 같을때
     * -1 : 선출된 사람 없음.
     */
    static Integer checkResult(){
        boolean allSame = true;
        int norm = voter / left;
        for(int i = 0; i < N; i++){
            if(results[i] >= selected_num) return i;     // 선출될 시
            if(!fails[i] && results[i] != norm) allSame = false;        // 남은 후보자들의 득표수가 모두 동일할 경우.
        }
        if(allSame) return 20;      // 모두 동일한 득표
        else return -1;     // 재투표
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /**
         * 초기화
         */

        N = Integer.parseInt(br.readLine());
        left = N;
        names = new String[N];      // 후보자 배열 초기화
        fails = new boolean[N];       // 후보자 탈락 유무 배열 초기화.
        voteList = new LinkedList[1000];        // 선호도 결과를 받을 큐배열 초기화.
        for(int i = 0; i < 1000; i++) voteList[i] = new LinkedList<>();

        /**
         *  입력 받아오기
         */

        // 후보자 받아오기
        for(int i = 0; i < N; i++) names[i] = br.readLine();

        // 선호도 받아오기
        String str = "";
        int idx = 0;
        while(((str = br.readLine()) != null) && (str.length() > 0)){
            StringTokenizer st = new StringTokenizer(str);

            // 선호도 큐에 삽입.
            for(int i = 0; i < N; i++) voteList[idx].add(Integer.parseInt(st.nextToken()) - 1);
            idx++;
        }

        /**
         * 로직
         */

        voter = idx;        // 투표자 수
        selected_num = (idx % 2 == 0) ? idx / 2 : idx / 2 + 1;      // 선출되기 위해 받아야할 최소 득표수
        // 투표자가 없을 경우.
        if(selected_num == 0) {
            for(int i = 0; i < N; i++) System.out.println(names[i]);
            return;
        }
        int flag = -1;

        // 첫 득표수로 정리
        results = new int[N];           // 특표수 배열 초기화.
        for(int i = 0; i < voter; i++) results[voteList[i].peek()]++;

        while(true){
            // 50% 이상 득표수가 나오거나 모두 득표수가 같다면 중단.
            if((flag = checkResult()) >= 0) break;

            // 탈락자들 표시
            int min = Integer.MAX_VALUE;       // 가장 적은 득표수
            for(int i = 0; i < N; i++) {
                if(!fails[i]) min = Math.min(min, results[i]);
            }
            for(int i = 0; i < N; i++){
                if(results[i] == min) {
                    fails[i] = true;      // 이 득표수인 후보자 전부 탈락.
                    left--;             // 남은 후보 수.
                }
            }

            // 탈락자들 퇴출
            for(int i = 0; i < voter; i++){
                while(fails[voteList[i].peek()]) voteList[i].poll();
            }

            // 재집계
            results = new int[N];           // 특표수 배열 초기화.
            for(int i = 0; i < voter; i++) results[voteList[i].peek()]++;
        }

        /**
         * 정답 출력
         */

        if(flag == 20){
            for(int i = 0; i < N; i++) {
                if(!fails[i]) System.out.println(names[i]);
            }
        }else System.out.println(names[flag]);

    }
}
