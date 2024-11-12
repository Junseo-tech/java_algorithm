package november;

public class practice {
    private static int[] pre = new int[] {1,2,3,4,5};
    private static int N = 5;
    public static void main(String[] args) {
        //permutation(0, new int[N], new boolean[N]);
       // combination(0,0, new int[N]);
        //partSet(0, new int[N]);
        multiPer(0, new int[N]);
    }

    private static void permutation(int depth, int[] chosen, boolean[] visited) {
        if(depth == N) {
            for(int i = 0; i < N; i++) {
                System.out.print(chosen[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 0; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                chosen[depth] = pre[i];
                permutation(depth + 1, chosen, visited);
                visited[i] = false;
            }
        }
    }

    private static void combination(int depth, int start, int[] chosen) {
        if(depth == 3) {
            for(int i = 0; i < N; i++) {
                System.out.print(chosen[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i = start; i < N; i++) {
            chosen[depth] = pre[i];
            combination(depth + 1, i + 1, chosen);
        }
    }

    private static void partSet(int depth, int[] chosen) {
        if(depth == N) {
            for(int i = 0; i < N; i++) {
                System.out.print(chosen[i] + " ");
            }
            System.out.println();
            return;
        }
        chosen[depth] = pre[depth];
        partSet(depth + 1, chosen);

        chosen[depth] = 0;
        partSet(depth + 1, chosen);
    }

    private static void multiPer(int depth, int[] chosen) {
        if(depth == N) {
            for(int i = 0; i < N; i++) {
                System.out.print(chosen[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i = 0; i < N; i++) {
            chosen[depth] = pre[i];
            multiPer(depth + 1, chosen);
        }
    }
}
