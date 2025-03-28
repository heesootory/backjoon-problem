import java.io.*;
import java.util.*;


class Pair{
    int x, y;
    public Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static ArrayList<Pair> list;
    static int[][] arr, arr2;
    static boolean complete;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[9][9];
        arr2 = new int[9][9];
        list = new ArrayList<>();

        for(int i = 0; i < 9; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 0) list.add(new Pair(i, j));
            }
        }

        sudoku(0);
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                System.out.print(arr2[i][j] + " ");
            }
            System.out.println();
        }

    }

    static void sudoku(int idx){
        if(complete) return;

        if(idx == list.size()) {
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    arr2[i][j] = arr[i][j];
                }
            }
            complete = true;
            return;
        }

        Pair p = list.get(idx);
        boolean[] visited = new boolean[10];
        visited[0] = true;      // 미사용

        // 해당 포함 사각형 조사
        // 012  345  678  -> 3으로 나눌시 몫의 갯수에 따라
        int xs = p.x / 3;
        int ys = p.y / 3;
        for(int x = xs * 3; x < xs * 3 + 3; x++){
            for(int y = ys * 3; y < ys * 3 + 3; y++){
                visited[arr[x][y]] = true;
            }
        }

        // 행 조사
        for(int j = 0; j < 9; j++){
            visited[arr[p.x][j]] = true;
        }

        // 열 조사
        for(int j = 0; j < 9; j++){
            visited[arr[j][p.y]] = true;
        }

        // 빈칸에 숫자 넣기 시도
        for(int i = 1; i < 10; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[p.x][p.y] = i;
                sudoku(idx + 1);
                arr[p.x][p.y] = 0;
                visited[i] = false;
            }
        }

    }

}
