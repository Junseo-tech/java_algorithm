import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2578 {
    private static int[][] bingo = new int[5][5];
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static boolean[][] visited = new boolean[5][5];
    private static int[] numbers = new int[25];
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                bingo[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                numbers[i * 5 + j] = Integer.parseInt(st.nextToken());
            }
        }
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                            return;
                        }


    }

            }
        }
        }
        }

    }
