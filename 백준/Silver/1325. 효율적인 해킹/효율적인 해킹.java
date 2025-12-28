import java.io.*;
import java.util.*;

public class Main {
    //인접 리스트 구조를 더 단순화 ArrayList 하면 시간초과
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

        StringBuilder sb = new StringBuilder();
        for(int a : result) {
            sb.append(a).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    private static int BFS(int computer_node){

        Queue<Integer> q = new ArrayDeque<>();
        int cnt = 1;
        q.add(computer_node);
        visited[computer_node] = true;

        while(!q.isEmpty()){
            int now_computer = q.poll();

            for(int next_node : A[now_computer]){
                if(!visited[next_node]) {
                    //q에 넣어줄떄 미리 true로 바꿔야 시간초과 회피
                    visited[next_node] = true;
                    q.add(next_node);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}