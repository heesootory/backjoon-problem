import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static int[] arr1;
    static Map<Integer, Integer> map;
    static ArrayList<Integer> ansList;
    static int[] idxArr;
    static int LowerBound(int num){
        int l = 0;
        int r = ansList.size();
        while(l < r){
            int mid = (l + r) / 2;
            if(ansList.get(mid) < num) l = mid + 1;
            else r = mid;
        }
        return r;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr1 = new int[N];
        idxArr = new int[N];
        map = new HashMap<>();
        ansList = new ArrayList<>();

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr1[i] = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            map.put(arr1[i], num);
        }

        Arrays.sort(arr1);

        for(int i = 0; i < N; i++){
            int curr = map.get(arr1[i]);
            if(ansList.isEmpty()) {
                idxArr[i] = 0;
                ansList.add(curr);
            }
            else{
                if(curr > ansList.get(ansList.size() - 1)) {
                    idxArr[i] = ansList.size();
                    ansList.add(curr);
                }
                else {
                    int idx = LowerBound(curr);
                    idxArr[i] = idx;
                    ansList.set(idx, curr);
                }
            }
        }

        int ans = ansList.size();
        System.out.println(N - ans);

        Stack<Integer> stack = new Stack<>();
        for(int i = N - 1; i >= 0; i--){
            if(idxArr[i] == ans - 1) {
                ans--;
                continue;
            }
            else stack.push(arr1[i]);
        }

        while(!stack.isEmpty()) System.out.println(stack.pop());

    }
}