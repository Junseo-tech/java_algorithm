import java.io.*;
import java.util.*;
public class Main{
    static ArrayList<Integer> arr[];
    static int N,a,b,parent[];
    static boolean visit[];
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visit = new boolean[N+1];
        parent = new int[N+1];
        arr =new ArrayList[N+1];
        
        for(int i=1; i<=N; i++){
            arr[i] = new ArrayList<>();
        }
        
        for(int i=1; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            a=Integer.parseInt(st.nextToken());
            b=Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);   
        }
        bfs(1);
        
        for(int i=2; i<=N; i++){
            System.out.println(parent[i]);
        }
    }
    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visit[start]=true;
        
        while(!q.isEmpty()){
            int p = q.poll();
            for(int next:arr[p]){
                if(!visit[next]){
                    visit[next]=true;
                    q.add(next);
                    parent[next]=p;
                }
            }
        }
    }
}