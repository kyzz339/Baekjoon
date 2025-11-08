import java.util.*;

public class Main {
    static boolean[] col;      // 열
    static boolean[] diag1;    // ↘ 대각선
    static boolean[] diag2;    // ↙ 대각선
    static int number;
    static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        number = sc.nextInt();

        col = new boolean[number + 1];
        diag1 = new boolean[number * 2 + 1];
        diag2 = new boolean[number * 2 + 1];

        DFS(1);
        System.out.println(result);
    }

    public static void DFS(int row) {
        if (row == number + 1) {
            result++;
            return;
        }

        for (int c = 1; c <= number; c++) {
            if (!col[c] && !diag1[row + c] && !diag2[row - c + number]) {
                col[c] = diag1[row + c] = diag2[row - c + number] = true;
                DFS(row + 1);
                col[c] = diag1[row + c] = diag2[row - c + number] = false;
            }
        }
    }
}