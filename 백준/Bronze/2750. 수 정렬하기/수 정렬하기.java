import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();
        int[] array = new int[number];
        for(int i=0; i<number; i++){
            array[i] = sc.nextInt();
        }

        for(int i=0; i<number; i++){
            for(int j=0; j<number - 1; j++){
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }

        for(int a : array){
            System.out.println(a);
        }
    }
}