
import java.util.*;

public class Main {
    static List<X>[] Node_list;
    static boolean[] visited;
    static int max = 0;
    static int farNode = 0;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int Node_number = sc.nextInt();
        Node_list = new List[Node_number + 1];
        visited = new boolean[Node_number + 1];
        for(int i=1;i<=Node_number;i++){
            Node_list[i] = new ArrayList<>();
        }

        for(int i=1; i<=Node_number; i++){
            int start_Node = sc.nextInt();

            while(true){
                int end_Node = sc.nextInt();
                if(end_Node == -1) break;
                int length = sc.nextInt();

                Node_list[start_Node].add(new X(end_Node , length));
                Node_list[end_Node].add(new X(start_Node , length));
            }
        }
        BFS(1);
        int A = farNode;

        max = 0;
        visited = new boolean[Node_list.length];
        BFS(A);

        System.out.println(max);
    }

    public static void BFS(int start_node){
        Queue<X> queue = new LinkedList<>();
        queue.add(new X(start_node , 0));
        visited[start_node] = true;

        while(!queue.isEmpty()){
            X node = queue.poll();

            if(node.length > max){
                max = node.length;
                farNode = node.endNode;
            }

            for(X next_node : Node_list[node.endNode]){
                if(!visited[next_node.endNode]){
                    visited[next_node.endNode] = true;
                    queue.add(new X(next_node.endNode , node.length + next_node.length));
                }
            }
        }
    }
}

class X{
    int endNode;
    int length;

    public X(int endNode, int length) {
        this.endNode =endNode;
        this.length = length;
    }
}