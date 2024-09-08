package september.seven;

public class practice {
    private static int[] num = {1,2,3,4,5};
    public static void main(String[] args) {
       // permutation(0,new int[5], new boolean[5]);
       // combination(0,0, new int[3]);
      //  double_permutation(0, new int[5]);
       // double_combination(0, 0, new int[5]);
        partSet(0, new boolean[5]);
    }

    private static void permutation(int count, int[] chosen, boolean[] visited) {
        if(count == num.length) {
            for (int i = 0; i < chosen.length; i++) {
                System.out.print(chosen[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i = 0; i < num.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                chosen[count] = num[i];
                permutation(count + 1, chosen, visited);
                visited[i] = false;
            }
        }
    }

    private static void double_permutation(int count, int[] chosen) {
        if(count == num.length) {
            for (int i = 0; i < chosen.length; i++) {
                System.out.print(chosen[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i = 0; i < num.length; i++) {
            chosen[count] = num[i];
            double_permutation(count + 1, chosen);
        }
    }
    private static void combination(int count, int start, int[] chosen) {
        if(count == 3) {
            for (int i = 0; i < chosen.length; i++) {
                System.out.print(chosen[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i = start; i < num.length; i++) {
            chosen[count] = num[i];
            combination(count + 1, i + 1, chosen);
        }
    }
    private static void double_combination(int count, int start, int[] chosen) {
        if(count == num.length) {
            for (int i = 0; i < chosen.length; i++) {
                System.out.print(chosen[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i = 0; i < num.length; i++) {
            chosen[count] = num[i];
            double_combination(count + 1, i, chosen);
        }
    }
    private static void partSet(int count, boolean[] visited) {
        if(count == num.length) {
            for (int i = 0; i < visited.length; i++) {
                if(visited[i]) {
                    System.out.print(num[i] + " ");
                }
            }
            System.out.println();
            return;
        }
        visited[count] = true;
        partSet(count + 1, visited);
        visited[count] = false;
        partSet(count + 1, visited);
    }
}
