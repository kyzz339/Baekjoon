
import java.util.*;

public class Main {
    static boolean[] check_DFS;
    static boolean[] check_BFS;
    static List<Integer>[] array;
    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);

        int Node = sc.nextInt();
        array = new List[Node + 1];
        check_DFS = new boolean[Node + 1];
        check_BFS = new boolean[Node + 1];
        for(int i=0;i<Node + 1;i++){
            array[i] = new ArrayList<>();
            check_DFS[i] = false;
            check_BFS[i] = false;
        }
        int Edge = sc.nextInt();
        int start = sc.nextInt();

        for(int i = 0; i<Edge; i++){
            int start_node = sc.nextInt();
            int end_node = sc.nextInt();
            array[start_node].add(end_node);
            array[end_node].add(start_node);

            array[start_node].add(end_node);
        }

        for(int i=1 ; i<array.length;i++){
            Collections.sort(array[i]);
        }

        DFS(start);
        System.out.println();
        BFS(start);
    }

    public static void DFS(int start){
        check_DFS[start] = true;
        System.out.print(start + " ");
        List<Integer> list = array[start];
        for (Integer a : list) {
            if(!check_DFS[a]) {
                DFS(a);
            }
        }
    }

    public static void BFS(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        check_BFS[start] = true;

        while(!queue.isEmpty()){
            int node = queue.poll();
            System.out.print(node + " ");

            List<Integer> list = array[node];
            for(Integer a : list){
                if(!check_BFS[a]) {
                    check_BFS[a] = true;
                    queue.add(a);
                }
            }
        }
    }
}