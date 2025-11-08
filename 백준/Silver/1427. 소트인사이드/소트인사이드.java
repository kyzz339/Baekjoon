import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{

        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        int[] array = new int[str.length()];
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            array[i] = Integer.parseInt(String.valueOf(ch));
        }

        for(int i=0; i<array.length - 1; i++){
            for(int j=0 ; j<array.length - 1;j++){
                if(array[j] < array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }

        for(Integer i : array){
            System.out.print(i);
        }
    }
}