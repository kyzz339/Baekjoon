import java.util.*;

public class Main {

	public static void main(String[] args){
		Main T = new Main();
		Scanner sc = new Scanner(System.in);

		int answer = 0;
		int number = sc.nextInt();
		int arr[] = new int[number+1];
		int lt=0 , rt = 0;
		int sum = 0;
		for(int i=1;i<=number;i++){
			arr[i] = i;
		}
		while(lt <= rt && rt < number){
			if(sum > number) {//sum이 number보다 클때 -> lt를 없애야함
				sum = sum - arr[lt];
				lt++;
			}else if(sum < number){//sum이 number보다 작을때 -> rt를 늘려서 갑을 크게
				rt++;
				sum = sum + arr[rt];
			}else{//sumdl number와 같을때 -> anwer을 늘리고 rt증가
				answer++;
				rt++;
				sum = sum + arr[rt];
			}
		}
		answer ++; //본인값 추가
		System.out.println(answer);
	}
}