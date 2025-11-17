import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int start_no = sc.nextInt();
        int max_value = 2000000; // 1000000을 넣었을때 최대수 1003001
        boolean[] primes = new boolean[max_value + 1];
        int result = 0;
        primes[0] = true;
        primes[1] = true;

        for(int i=2; i<=max_value; i++){

            if(!primes[i]) {
                for (int j = i + i; j <= max_value; j = j + i) {
                    primes[j] = true;
                }
            }
        }
        for(int i=start_no ; i<= max_value; i++){
            if(!primes[i]){
                char[] arr = Integer.toString(i).toCharArray();
                boolean flag = true;
                for(int j=0; j<arr.length; j++){
                    if(arr[j] != arr[arr.length - j - 1]){
                        flag = false;
                    }
                }
                if(flag) {
                    result = i;
                    break;
                }
            }
        }
        System.out.println(result);
    }
}