import java.util.*;

public class Main { //

	public static void main(String[] args){
		Main T = new Main();
		Scanner sc = new Scanner(System.in);

		int number = sc.nextInt();
		int chance = sc.nextInt();

		int[] array = new int[number];
		int[] sum_array = new int[number];
		for(int i=0 ; i<number ; i++){
			array[i] = sc.nextInt();
			if(i == 0) sum_array[i] = array[i];
			else sum_array[i] = sum_array[i-1] + array[i];
		}

		int[] start = new int[chance];
		int[] end = new int[chance];

		for(int i=0 ; i<chance ; i++){
			start[i] = sc.nextInt();
			end[i] = sc.nextInt();
		}

		for(int i=0 ; i<chance ; i++){
			if(start[i] - 1 < 1) {
				System.out.println(sum_array[end[i] - 1]);
			}else{
				System.out.println(sum_array[end[i] - 1] - sum_array[start[i] - 2]);
			}
		}

	}
}