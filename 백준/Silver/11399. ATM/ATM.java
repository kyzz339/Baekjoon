import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{

        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();
        int[] array = new int[number];
        for(int i=0 ; i<number; i++){
            array[i] = sc.nextInt();
        }

        Arrays.sort(array);
        int sum = 0;
        for(int i=0 ; i<number; i++){
            for(int j=0 ; j<i; j++){
                sum += array[j];
            }
            sum += array[i];
        }

        System.out.println(sum);
    }
}