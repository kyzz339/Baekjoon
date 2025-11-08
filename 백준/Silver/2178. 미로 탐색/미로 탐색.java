
import java.util.*;

public class Main {
    static int dx[] = {0 , 0 , -1 , 1}; //상하좌우
    static int dy[] = {1 , -1 , 0 , 0};//상하좌우
    static int answer[][];
    static int[][] board;
    static boolean[][] visited;
    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);
        int target_n = sc.nextInt();
        int target_m = sc.nextInt();
        sc.nextLine();
        board = new int[target_n + 1][target_m + 1];
        visited = new boolean[target_n + 1][target_m + 1];
        answer = new int[target_n + 1][target_m + 1];

        for(int i=1; i<board.length; i++){
            String input = sc.nextLine();
            for(int j=0 ; j<input.length(); j++){
                int a = input.charAt(j) - '0';
                board[i][j+1] = a;
            }
        }

        Queue<x> queue = new LinkedList<>();
        queue.add(new x(1,1));
        answer[1][1] = 1;
        while(!queue.isEmpty()){
            x temp = queue.poll();
            visited[temp.y][temp.x] = true;
            if(temp.y == target_n && temp.x == target_m){
                System.out.println(answer[temp.y][temp.x]);
            }
            for(int i=0; i<dx.length; i++ ){
                //x , y가 1보다 작고
                if(temp.x + dx[i] < 1 || temp.y + dy[i] <1 || temp.y + dy[i] > target_n || temp.x + dx[i] > target_m){
                    continue;
                }
                //board[x][y] 가 0이면 제외
                if(board[temp.y + dy[i]][temp.x + dx[i]] == 0){
                    continue;
                }
                if(!visited[temp.y + dy[i]][temp.x + dx[i]]) {
                    visited[temp.y + dy[i]][temp.x + dx[i]] = true;
                    answer[temp.y + dy[i]][temp.x + dx[i]] = answer[temp.y][temp.x] + 1;
                    queue.add(new x(temp.x + dx[i], temp.y + dy[i]));
                }
            }
        }
    }
}

class x{
    int x;
    int y;

    public x(int x, int y){
        this.x = x;
        this.y = y;
    }
}