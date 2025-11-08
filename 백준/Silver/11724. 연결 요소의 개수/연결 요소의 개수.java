import java.util.*;
public class Main {
    static boolean[] check;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int graphNumber = sc.nextInt();
        int lineNumber = sc.nextInt();

        graph = new ArrayList[graphNumber + 1];
        check = new boolean[graphNumber + 1];
        for(int i = 1; i<=graphNumber; i++){ // node 등록
            check[i] = false;
            graph[i] = new ArrayList<>();
        }
        for(int i=0 ; i<lineNumber; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();

            graph[start].add(end);
            graph[end].add(start);
        }

        int count = 0;
        for(int i=1; i<=graphNumber; i++){
            if(!check[i]){
                count++;
                DFS(i);
            }
        }
        System.out.println(count);
    }
    public static void DFS(int node){
        if(check[node]) return;
        check[node] = true;
        for(int next : graph[node]){
            DFS(next);
        }
    }
}