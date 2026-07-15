// 최대한 많이 탐험
// 최소 필요 피로도, 소모 피로도 => 탐험할 수 있는 최대 던전 수 return
class Solution {
    static int N;
    static int answer;
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        N = dungeons.length;
        
        permutation(new boolean[N], k, 0, dungeons);
        
        return answer;
    }
    
    
    private void permutation(boolean[] visited, int k, int depth, int[][] dungeons) { 
        answer = Math.max(answer, depth);
        
        for(int i = 0; i < N; i++) {
            if(!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                permutation(visited, k - dungeons[i][1], depth + 1, dungeons);
                visited[i] = false;
            }
        }
    }
}