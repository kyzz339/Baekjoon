import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int start_number = sc.nextInt();
        int end_number = sc.nextInt();
        boolean[] primes = new boolean[end_number + 1]; // true이면 소수 x
        primes[0] = true;
        primes[1] = true;
        for(int i=2; i<=Math.sqrt(end_number); i++){
            if(!primes[i]) {
                for (int j = 2; j <= end_number; j++) {
                    int prime_number = i * j;
                    if (prime_number > end_number) break;
                    primes[prime_number] = true;
                }
            }
        }

        for(int i=start_number; i<=end_number; i++){
            if(!primes[i]){
                System.out.println(i);
            }
        }
    }
}