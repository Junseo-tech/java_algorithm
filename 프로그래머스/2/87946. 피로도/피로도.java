// 최대한 많이 탐험
// 최소 필요 피로도, 소모 피로도 => 탐험할 수 있는 최대 던전 수 return
class Solution {
    static int N;
    static int answer;
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        N = dungeons.length;
        
        permutation(new boolean[N], k, 0, dungeons, new int[N]);
        
        return answer;
    }
    
    
    private void permutation(boolean[] visited, int k, int depth, int[][] dungeons, int[] sequence) { 
        if(depth == N) {
            answer = Math.max(answer, countDungeons(k, sequence, dungeons));
            return;
        }
        
        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                sequence[depth] = i;
                permutation(visited, k, depth + 1, dungeons, sequence);
                visited[i] = false;
            }
        }
    }
    
    private int countDungeons(int k, int[] sequence, int[][] dungeons) {
        int count = 0;
        for(int i = 0; i < N; i++) {
            if(k - dungeons[sequence[i]][0] >= 0) {
                k -= dungeons[sequence[i]][1];
                count++;
            }
        }
        return count;
    }
}