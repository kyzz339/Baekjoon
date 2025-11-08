import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int cardNumber = sc.nextInt();
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int sum = 0;
        for(int i = 0; i<cardNumber; i++){
            q.add(sc.nextInt());
        }

        while(q.size() > 1){

            int value1 = q.poll();
            int value2 = q.poll();

            sum += value1 + value2;
            q.add(value1 + value2);
        }
        System.out.println(sum);
    }
}