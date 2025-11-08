import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int arraySize = sc.nextInt();
        int result = 0;
        PriorityQueue<Integer> q_plus = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> q_minus = new PriorityQueue<>();
        boolean hasZero = false;
        for(int i=0; i<arraySize; i++){
            int input_value = sc.nextInt();
            if (input_value > 1) q_plus.add(input_value);
            else if (input_value == 1) result += 1;
            else if (input_value == 0) hasZero = true;
            else q_minus.add(input_value);
        }

        while(!q_plus.isEmpty()){
            int value1 = q_plus.poll();
            int sum = 0;

            if(value1 == 1){
                result += 1;
            }else {
                if (!q_plus.isEmpty()) {
                    int value2 = q_plus.poll();
                    sum += (value1 * value2);
                    result += sum;
                } else {
                    result += value1;
                }
            }
        }

        while (!q_minus.isEmpty()){
            int a = q_minus.poll();
            if (!q_minus.isEmpty()) result += a * q_minus.poll();
            else if (!hasZero) result += a;
        }
        System.out.println(result);
    }
}