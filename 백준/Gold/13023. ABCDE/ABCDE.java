import java.util.*;
public class Main {
    static ArrayList<Integer>[] list;
    static boolean[] check;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();
        int relationship = sc.nextInt();
        list = new ArrayList[number];
        check = new boolean[number];
        for(int i=0; i<number; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<relationship; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();

            list[start].add(end);
            list[end].add(start);
        }

        for(int i=0; i<number; i++){
            DFS(i , 1 , relationship);
        }

        System.out.println("0");
    }

    static void DFS(int node , int level, int relationship){
        if(level == 5){
            System.out.println("1");
            System.exit(0);
        }

        check[node] = true;

        List<Integer> DFS_list = list[node];
        for(Integer a : DFS_list){
            if(!check[a]) {
                DFS(a, level + 1 , relationship);
            }
        }
        check[node] = false;
    }
}