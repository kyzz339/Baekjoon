import java.util.*;

public class Main { //

	public static void main(String[] args){
		Main T = new Main();
		Scanner sc = new Scanner(System.in);

		int N = sc .nextInt();
		int number = sc.nextInt();
		int[][] array = new int[N + 1][N + 1];
		int[][] sum_array = new int[N + 1][N + 1];
		for(int i = 1 ; i<=N; i++){
			for(int j=1; j<=N; j++){
				array[i][j] = sc.nextInt();
			}
		}

		for(int i=1; i<=N; i++){
			for(int j=1; j<=N; j++){
				sum_array[i][j] = sum_array[i-1][j] + sum_array[i][j-1] - sum_array[i-1][j-1] + array[i][j];
			}
		}

		int[] result = new int[number];
		for(int i= 0 ; i<number; i++){
			int start_i = sc.nextInt();
			int start_j = sc.nextInt();
			int end_i = sc.nextInt();
			int end_j = sc.nextInt();

			if(start_i == end_i && start_j == end_j){
				result[i] = array[start_i][start_j];
			}else {
				result[i] = sum_array[end_i][end_j] - sum_array[end_i][start_j - 1]
						- sum_array[start_i - 1][end_j] + sum_array[start_i - 1][start_j - 1];
			}
		}

		for(int i : result){
			System.out.println(i);
		}

	}
}