import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N,M;
	private static int[][] ocean;
	private static boolean[][] visited;
	private static int islandNum = 1;
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static int[] dx = {-1,1,0,0};
	private static int[] dy = {0,0,-1,1};
	private static int[] parents;
	private static PriorityQueue<Edge> edges = new PriorityQueue<>();
	private static ArrayList<Island>[] islands;
	static class Edge implements Comparable<Edge> {
		int start, end, weight;
		
		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
		
	}
	
	static class Island {
		int x, y;

		public Island(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	
	static void makeSet() {
		for(int i = 1; i < islandNum; i++) {
			parents[i] = i;
		}
	}
	
	static int findSet(int v) {
		if(parents[v] == v) return v;
		return parents[v] = findSet(parents[v]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return false;
		
		if(aRoot < bRoot) parents[bRoot] = aRoot;
		else parents[aRoot] = bRoot;
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ocean = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				ocean[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		islands = new ArrayList[7]; // 섬 정보 들어있음
		
		for(int i = 0; i < 7; i++) {
			islands[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(ocean[i][j] == 1 && !visited[i][j]) {
					islands[islandNum] = new ArrayList<>();
					bfs(i , j);
					islandNum++;
				}
			}
		}
		
		parents = new int[islandNum];
		
		for(int i = 1; i < islandNum; i++) { // 지금 i가 number
			for(int j = 0; j < islands[i].size(); j++) {
				int x = islands[i].get(j).x;
				int y = islands[i].get(j).y;
				for(int d = 0; d < 4; d++) {
					makeEdge(x, y, i, d, -1);
				}
				
			}
		}
		System.out.println(kruskal());
		
//		for(int i = 0; i < parents.length; i++) {
//			System.out.println(parents[i] + " ");
//		}
//	
	}
	
	
	private static void bfs(int x, int y) { // 번호 부여하기
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x,y});
		visited[x][y] = true;
		ocean[x][y] = islandNum;
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			int temp_x = temp[0];
			int temp_y = temp[1];
			
			islands[islandNum].add(new Island(temp_x, temp_y));
			
			for(int d = 0; d < 4; d++) {
				int nx = temp_x + dx[d];
				int ny = temp_y + dy[d];
				if(0 <= nx && nx < N && 0 <= ny && ny < M && !visited[nx][ny] && ocean[nx][ny] == 1) {
					visited[nx][ny] = true;
					ocean[nx][ny] = islandNum;
					queue.add(new int[] {nx, ny});
				}
			}
		}
	}
	
	private static void makeEdge(int x, int y, int num, int dir, int len) { // edge는 길이가 2 이상 이어야 함
		if(ocean[x][y] != 0 && ocean[x][y] != num) {
			if(len >= 2) {
				edges.add(new Edge(num, ocean[x][y], len));
			}
			return;
		}
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		
		if(nx < 0 || nx >= N || ny < 0 || ny >= M) return;
		
		if(ocean[nx][ny] == num) return;
		
		makeEdge(nx, ny, num, dir, len + 1);
		
	}
	
	private static int kruskal() {
	    makeSet();
	    int count = 0;
	    int cost = 0;
	    int bridge = 0; // 다리 개수를 세기 위한 변수 추가

	    while (!edges.isEmpty()) {
	        Edge edge = edges.poll();
	        if (union(edge.start, edge.end)) {
	            cost += edge.weight;
	            bridge++;
	        }
	    }

	    // 다리 개수 체크
	    if (bridge != islandNum - 2) return -1;
	    return cost;
	}


}
