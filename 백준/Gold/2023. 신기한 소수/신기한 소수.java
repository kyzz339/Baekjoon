import java.util.*;
public class Main {
    static int number;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        number = sc.nextInt();
        for(int i=2; i<=9; i++) {
            DFS(i , 1);
        }
    }

    static void DFS(int n , int level){
        if(number < level) return;
        boolean IsPrime = isPrime(n);
        if(level == number && IsPrime){
            System.out.println(n);
        }
        if(IsPrime && level < number){ // 소수일때
            for(int i=0; i<=9; i++){
                int newNumber =  n * 10 + i;
                DFS(newNumber, level + 1);
            }
        }else{ // 소수아닐때
            return ;
        }
    }
    static boolean isPrime(int n){ // 소수 판별
        if (n < 2) return false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }

        return true;
    }

}