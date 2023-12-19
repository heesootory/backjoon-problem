import java.io.*;
import java.util.*;


public class Main{
    static int N;
    static int[] idxArr, arr;
    static ArrayList<Integer> list;
    static int LowerBound(int num){
        int l = 0;
        int r = list.size();

        while(l < r){
            int mid = (l + r) / 2;
            if(list.get(mid) < num) l = mid + 1;
            else r = mid;
        }
        return r;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        idxArr = new int[N];
        arr = new int[N];
        list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;

            int len = list.size();
            if(len == 0) {
                list.add(num);
                idxArr[i] = 0;
            }
            else{
                if(num > list.get(len - 1)) {
                    list.add(num);
                    idxArr[i] = len;
                }
                else{
                    int idx = LowerBound(num);
                    list.set(idx, num);
                    idxArr[i] = idx;
                }
            }
        }

        int ans = list.size();
        System.out.println(ans);

        // 역추적
        int rev = ans - 1;
        Stack<Integer> stack = new Stack<>();
        for(int i = N - 1; i >= 0; i--) {
            int ele = idxArr[i];
            if(ele == rev) {
                stack.push(arr[i]);
                rev--;
            }
            if(rev < 0) break;
        }

        while(!stack.isEmpty()) System.out.print(stack.pop() + " ");
    }
}