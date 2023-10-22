class Solution {
    static int dfs(int[] nums, int target, int idx, int result){
        if(idx == nums.length){
            if(result == target) return 1;
            return 0;
        }
        
        return dfs(nums, target, idx + 1, result + nums[idx]) + dfs(nums, target, idx + 1, result - nums[idx]);
    }
    
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }
}