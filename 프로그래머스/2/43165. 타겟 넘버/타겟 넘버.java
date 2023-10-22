class Solution {
    static int targetNum;
    static int[] arr;
    static int cnt;
    static void makeTarget(int idx, int result){
        if(idx == arr.length){
            if(result == targetNum) cnt++;
            return;
        }
        
        makeTarget(idx + 1, result + arr[idx]);
        makeTarget(idx + 1, result - arr[idx]);
        
    }
    
    public int solution(int[] numbers, int target) {
        arr = numbers;
        targetNum = target;
        
        makeTarget(0, 0);
        return cnt;
    }
}