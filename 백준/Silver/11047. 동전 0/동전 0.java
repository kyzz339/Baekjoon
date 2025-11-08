import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] arrayCoin = new int[N];

        for(int i=0 ; i<N; i++){
            arrayCoin[i] = sc.nextInt();
        }

        int count = 0;

        for(int i=arrayCoin.length - 1 ; i>=0 ; i--){
            int value = arrayCoin[i];

            if(arrayCoin[i] <= K){
                count += (K / value);
                K = K%value;
            }
        }

        System.out.println(count);

    }
}