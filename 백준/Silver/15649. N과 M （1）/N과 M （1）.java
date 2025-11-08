import java.util.*;
public class Main {
    static int M;
    static int N;
    static int[] array;
    static int[] target;
    static boolean[] check;
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        array = new int[N];
        check = new boolean[N];

        for(int i = 0; i<N; i++){
            array[i] = i + 1;
        }
        M = sc.nextInt();
        target = new int[M];
        DFS(0 , array);

    }

    public static void DFS(int level , int[] array){
        if(level == M){
            for(int i : target){
                System.out.print(i + " ");
            }
            System.out.println();
        }else{
            for(int i=0; i<N; i++){
                if(!check[i]){
                    check[i] = true;
                    target[level] = i + 1;
                    DFS(level+1 ,array);
                    check[i] = false;
                }
            }
        }
    }
}