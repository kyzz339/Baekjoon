import java.util.*;
//다시 풀이 추천 - 어려움
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long min = sc.nextLong();
        long max = sc.nextLong();
        boolean[] check = new boolean[(int)(max - min + 1)];
        int cnt = 0;

        for(long i=2; i<=Math.sqrt(max); i++){
            long square = i * i;
            
            long start = (min / square) * square;
            if (start < min) start += square;

            for(long j = start; j <= max; j += square) {
                if(j > 1) {
                    check[(int)(j-min)] = true;
                }else{
                    break;
                }
            }
        }

        for(long i=min; i<=max; i++){
            if (!check[(int)(i - min)]){
                cnt++;
            }
        }

        System.out.println(cnt);

    }
}