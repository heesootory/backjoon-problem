import java.io.*;
import java.util.*;


public class Main{
    static int T,  M;
    static PriorityQueue<Integer> minHeap;
    static PriorityQueue<Integer> maxHeap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++){
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
            M = Integer.parseInt(br.readLine());
            System.out.println(M/2 + 1);
            int m = 1;
            boolean flag = false;
            while(true){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int i = 0; i < 10; i++){
                    int x = Integer.parseInt(st.nextToken());

                    // 입력받는 값을 넣어주는 방법. - 3개까지는 그냥 minHeap에 넣기
                    if (m > 3) {
                        if(x < maxHeap.peek()) maxHeap.add(x);
                        else minHeap.add(x);
                    }
                    else{
                        minHeap.add(x);
                    }

                    // 홀수 번째인 경우
                    if(m % 2 != 0){
                        while(minHeap.size() - 1 > maxHeap.size()){
                            maxHeap.add(minHeap.poll());
                        }
                        while(minHeap.size() < maxHeap.size()){
                            minHeap.add(maxHeap.poll());
                        }
                        System.out.print(minHeap.peek() + " ");
                    }

                    m++;
                    if(m == M + 1) {
                        flag = true; break;
                    }
                }
                if(flag) break;
            }
            System.out.println();

        }
    }
}