import java.util.*;

public class Main { //

	public static void main(String[] args){
		Main T = new Main();
		Scanner sc = new Scanner(System.in);

		int subject = sc.nextInt();
		double sum = 0;
		int max_score = Integer.MIN_VALUE;
		double new_score[] = new double[subject];
		for(int i=0 ; i<subject ; i++){
			int score = sc.nextInt();
			new_score[i] = score;
			max_score = Math.max(score , max_score);
		}
		for(int i=0 ; i<subject ; i++){
			new_score[i] = 	new_score[i]/max_score*100;
			sum += new_score[i];
		}
		double average = sum/subject;

		System.out.println(average);
	}
}