
import java.io.*;
import java.util.*;

public class Main {

    static List<Integer> A[];
    static boolean[] visited;
    static List<Integer> result;
    static int maxNumer = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());

        int numOfPc = Integer.parseInt(token.nextToken());
        int numOfTruth = Integer.parseInt(token.nextToken());

        A = new ArrayList[numOfPc + 1];
        visited = new boolean[numOfPc + 1];
        result = new ArrayList();
        for(int i=0; i<= numOfPc; i++){
            A[i] = new ArrayList<Integer>();
        }

        for(int i=0; i<numOfTruth; i++) {

            token = new StringTokenizer(br.readLine());
            int E = Integer.parseInt(token.nextToken());
            int S = Integer.parseInt(token.nextToken());
            //E가 S를 신뢰 -> S를 해킹하면 E도 해킹 가능
            A[S].add(E);
        }

        for(int i=1; i<=numOfPc; i++){

            visited = new boolean[numOfPc + 1];
            int cnt = BFS(i);
            if(cnt > maxNumer){
                maxNumer = cnt;
                result.clear();
                result.add(i);
            }else if(cnt < maxNumer){

            }else{
                result.add(i);
            }
        }

        Collections.sort(result);

        for(int a : result){
            System.out.println(a);
        }
    }

    private static int BFS(int computer_node){

        Queue<Integer> q = new LinkedList();
        int cnt = 1;
        q.add(computer_node);
        visited[computer_node] = true;

        while(!q.isEmpty()){
            int now_computer = q.poll();

            for(int next_node : A[now_computer]){
                if(!visited[next_node]) {
                    visited[next_node] = true;
                    q.add(next_node);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}