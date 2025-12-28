import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer> A[];
    static int visited[];
    static List<Integer> answer;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numOfCity = Integer.parseInt(st.nextToken());
        int numOfRoad = Integer.parseInt(st.nextToken());
        int distance = Integer.parseInt(st.nextToken());
        int startCity = Integer.parseInt(st.nextToken());

        A = new ArrayList[numOfCity + 1];

        for(int i=0; i<=numOfCity; i++){
            A[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<numOfRoad; i++){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            A[S].add(E);
        }

        visited = new int[numOfCity + 1];
        for(int i=0; i<=numOfCity; i++){
            visited[i] = -1; // 방문 배열 초기화
        }

        BFS(startCity);

        answer = new ArrayList<>();

        for(int i=0; i<=numOfCity; i++){
            if(visited[i] == distance){
                answer.add(i);
            }
        }

        if(answer.isEmpty()){
            System.out.println("-1");
        }else{
            Collections.sort(answer);
        }

        for(Integer a : answer){
            System.out.println(a);
        }

    }

    private static void BFS(int node){
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(node);
        visited[node] = 0;
        while(!q.isEmpty()){
            int current_node = q.poll();
            for(int next_node : A[current_node]){
                if(visited[next_node] == -1){
                    visited[next_node] = visited[current_node] + 1;
                    q.add(next_node);
                }
            }
        }
    }
}