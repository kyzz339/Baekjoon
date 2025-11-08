import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long N = sc.nextInt();
        long k = sc.nextInt();

        long start = 1;
        long end = N * N;
        long answer = 0;

        while(start<=end){
            long mid = (start + end)/2;
            long cnt = 0;

            for(int i=1; i<=N; i++){
                cnt+=Math.min(mid/i , N);
            }
            if(cnt < k){
                start = mid + 1;
            }else{
                answer = mid;
                end= mid - 1;
            }
        }
        System.out.println(answer);
    }
}