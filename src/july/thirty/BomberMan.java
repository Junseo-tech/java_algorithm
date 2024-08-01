package july.thirty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BomberMan {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};
    private static List<List<Character>> graph;
    private static int R;
    private static int C;
    private static int N;
    private static int[][] visited;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()); // 세로
        C = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // N초가 흐른 후

        graph = new ArrayList<>();
        visited = new int[R][C];


        for (int i = 0; i <= R; i++) {
            graph.add(new ArrayList<>());
        }

        int time = 0;
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                graph.get(i).add(line.charAt(j));
                if (graph.get(i).get(j) == 'O') {
                    visited[i][j] = 3; // 초기
                }
            }
        }

        while(time++ < N) {
            if(time % 2 == 0) {
                setBomb(time);
            } else {
                startBomb(time);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                sb.append(graph.get(i).get(j));
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void setBomb(int time){
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (graph.get(i).get(j) == '.') {
                    graph.get(i).set(j, 'O');
                    visited[i][j] = time+3;

                }
            }
        }
    }



    private static void startBomb(int time) {
        for (int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if (visited[i][j] == time){
                    graph.get(i).set(j, '.');
                    visited[i][j] = 0;

                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                            continue;
                        }

                        if (graph.get(nx).get(ny) == 'O' && visited[nx][ny] != time) {
                            graph.get(nx).set(ny, '.');
                            visited[nx][ny] = 0;
                        }

                    }
                }
            }
        }
    }

}