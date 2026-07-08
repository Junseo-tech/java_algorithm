// 모든 명함을 수납할 수 있는 가장 작은 지갑
// return => 지갑 크기
import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
//         int[] width = new int[sizes.length];
//         int[] vertical = new int[sizes.length];
        
//         for(int i = 0; i < sizes.length; i++) {
//             if(sizes[i][0] > sizes[i][1]){
//                 width[i] = sizes[i][0];
//                 vertical[i] = sizes[i][1];
//                 continue;
//             }
//             width[i] = sizes[i][1];
//             vertical[i] = sizes[i][0];
//         }
        
//         Arrays.sort(width);
//         Arrays.sort(vertical);
        
//         answer = width[sizes.length - 1] * vertical[sizes.length - 1];
        int width = 0; int height = 0;
        for(int[] size : sizes) {
            width = Math.max(width, Math.max(size[0], size[1]));
            height = Math.max(height, Math.min(size[0], size[1]));
        }
        
        return width * height;
    }
}