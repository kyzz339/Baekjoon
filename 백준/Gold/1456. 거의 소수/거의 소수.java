
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long start_number = sc.nextLong();
        long end_number = sc.nextLong();
        int limit = (int)Math.sqrt(end_number);
        int cnt = 0;
        boolean[] primes = new boolean[limit + 1]; // true이면 소수 x

        primes[0] = true;
        primes[1] = true;

        for(int i = 2 ; i<= limit; i++){
            if(!primes[i]) {
                for (long j = i + i; j <= limit; j = j + i) {
                    primes[(int)j] = true;
                }
            }
        }

        for (int i = 2;  i <= limit; i++) {
            if (!primes[i]) {
                long num = (long)i * i;
                while (num <= end_number) {
                    if (num >= start_number) cnt++;
                    if (num > end_number / i) break;
                    num *= i;
                }
            }
        }
        System.out.println(cnt);
    }
}