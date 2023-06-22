class Solution {
    static int[][] arr;
    
    public int solution(int n, int[][] results) {
        int answer = 0;
        int len = results.length;
        arr = new int[n+1][n+1];
        
        // 승리하는 경우만 표시
        for(int i = 0; i < len; i++){
            arr[results[i][0]][results[i][1]] = 1;
        }
        
        // 경유지 = 거쳐가는 상대, 출발지 = 승리자, 도착지 = 패배자 
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                for(int z = 1; z <= n; z++){
                    if(arr[j][i] == 1 && arr[i][z] == 1) arr[j][z] = 1;
                    // i를 거쳐서 안해본 경기 결과를 표시.
                }
            }
        }
        
        for(int i = 1; i <= n; i++){
            int result = 0;
            for(int j = 1; j <= n; j++){
                if(arr[i][j] == 1 || arr[j][i] == 1) result++;
            }
            if(result == n-1) answer++;
        }
        
        return answer;
    }
}