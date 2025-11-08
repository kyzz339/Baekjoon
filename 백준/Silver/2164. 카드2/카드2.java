import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        Queue<Integer> card = new LinkedList<>();

        for(int i = 0 ; i< number; i++){
            card.add(i+1);
        }

        while(card.size() != 1){
            card.poll();
            int pollNumber = card.poll();
            card.add(pollNumber);
        }
        System.out.println(card.poll());
    }
}