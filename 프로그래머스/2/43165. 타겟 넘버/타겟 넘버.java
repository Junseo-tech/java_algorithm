class Solution {
    static int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        
        dfs(numbers, 0, 0, target);
        
        return answer;
    }
    
    private static void dfs(int[] numbers, int current, int idx, int target) {
        if(idx == numbers.length){
            if(current == target){
                answer++;
            }
            return;
        }
        
            dfs(numbers, current + numbers[idx], idx + 1, target);
            dfs(numbers, current - numbers[idx], idx + 1, target);
    }
}