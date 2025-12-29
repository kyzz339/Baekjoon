import java.io.*;
import java.util.*;

public class Main {

    static List<Integer> linkedList[];
    static boolean visited[];
    static int value[];
    static String result;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for(int i=0; i<testCase; i++){
            StringTokenizer token = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(token.nextToken());
            int numOfEdge = Integer.parseInt(token.nextToken());

            result = "YES";
            linkedList = new List[N + 1];
            value = new int[N + 1];
            visited = new boolean[N + 1];

            for(int j=0 ; j <= N ; j++){
                linkedList[j] = new ArrayList<Integer>();
            }

            for(int j=0; j<numOfEdge; j++){

                token = new StringTokenizer(br.readLine());

                int S = Integer.parseInt(token.nextToken());
                int E = Integer.parseInt(token.nextToken());

                linkedList[S].add(E);
                linkedList[E].add(S);
            } // 데이터 준비 완료

            for(int j = 1; j <= N; j++) {
                if(!visited[j]) BFS(j);
            }

            System.out.println(result);
        }
    }

    private static void BFS(int node){

        Queue<Integer> q = new LinkedList<>();
        visited[node] = true;
        q.add(node);
        value[node] = 0;

        while(!q.isEmpty()){
            int current_node = q.poll();
            for(int next_node : linkedList[current_node]){
                if(!visited[next_node]){ // 미방문 상태
                    visited[next_node] = true;
                    value[next_node] = 1 - value[current_node];
                    q.add(next_node);
                }else{ // 이미 방문 했음
                    if(value[current_node] == value[next_node]){
                        result = "NO";
                    }
                }
            }
        }
    }
}