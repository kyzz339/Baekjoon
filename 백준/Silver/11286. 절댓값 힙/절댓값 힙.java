import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1 , o2) ->{
            int first_abs = Math.abs(o1);
            int second_abs = Math.abs(o2);
            if(first_abs == second_abs)
                return Integer.compare(o1, o2);
            else
                return first_abs - second_abs;
        });

        for(int i=0 ; i<number; i++){
            int addNumber = Integer.parseInt(br.readLine());
            if(addNumber == 0){
                if(pq.isEmpty()){
                    System.out.println("0");
                }else{
                    int out = pq.poll();
                    System.out.println(out);
                }
            }else{
                pq.add(addNumber);
            }
        }
    }
}