import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long result = 0;

        long firstNumber = sc.nextLong();
        long secondNumber = sc.nextLong();

        long k = MOD(firstNumber, secondNumber);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<k;i++){
            sb.append("1");
        }
        System.out.println(sb.toString());

    }

    public static long MOD(long a , long b){
        if(b == 0) {
            return a;
        }
        return MOD(b, a % b);
    }
}