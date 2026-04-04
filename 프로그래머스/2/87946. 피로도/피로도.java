// 최소 필요 피로도(가지고 있어야 함) , 소모 피로도(던전 탐험 후 소모되는 피로도)
// 던전을 최대한 많이 탐험하고 싶다. 
// 유저가 탐험할 수 있는 최대 던전 수 return

class Solution {
    private static int answer;
    public int solution(int k, int[][] dungeons) { // 던전 최대 8개 
        answer = -1;
        int N = dungeons.length;
        
        backtracking(N, 0, new boolean[N], k, dungeons, 0);
        
        return answer;
    }
    
    // 순열 
    private void backtracking(int N, int depth, boolean[] visited, int k, int[][] dungeons, int count) {
        
        answer = Math.max(answer, count);

        for(int i = 0; i < N; i++) {
            if(!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                backtracking(N, depth + 1, visited, k - dungeons[i][1], dungeons, count + 1);
                visited[i] = false;
            }
        }
    }
    
}