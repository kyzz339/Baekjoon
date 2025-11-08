
import java.util.*;

public class Main {

	public static void main(String[] args){
		Main T = new Main();
		Scanner sc = new Scanner(System.in);

		long answer = 0;
		int N = sc.nextInt();
		int number = sc.nextInt();

		long[] arr = new long[N];
		long[] sum_arr = new long[N];
		long[] percent_arr = new long[N];
		long[] r = new long[number];
		long current_value = 0;
		for(int i=0 ; i<N ; i++){
			arr[i] = sc.nextInt();
			sum_arr[i] = current_value + arr[i];
			percent_arr[i] = sum_arr[i] % number;
			current_value += arr[i];
		}

		for(int i =0; i<N ; i++){
			if(percent_arr[i] % number == 0){
				answer ++; // 해당값 단일로 나눠떨어질때
			}
			r[(int) (percent_arr[i] % number)] ++;
		}

		for(int i=0;i<r.length ; i++){
			if(r[i] > 1) {
				answer = answer + (r[i] * (r[i] - 1) / 2);
			}
		}

		System.out.println(answer);
	}
}