import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int number1 = sc.nextInt();
        int[] array1 = new int[number1];

        for(int i=0; i<number1; i++){
            array1[i] = sc.nextInt();
        }

        int number2 = sc.nextInt();
        int[] array2 = new int[number2];
        for(int i=0; i<number2; i++){
            array2[i] = sc.nextInt();
        }

        Arrays.sort(array1);

        for(int i=0; i<array2.length; i++){
            int searchNumber = array2[i];

            int lt = 0;
            int rt = array1.length - 1;
            while(lt <= rt){
                int mid = (lt + rt) / 2;
                if(array1[mid] == searchNumber){
                    System.out.println("1");
                    break;
                }else if(array1[mid] >= searchNumber){
                    rt = mid - 1;
                }else if(array1[mid] < searchNumber){
                    lt = mid + 1;
                }
                if(lt > rt) System.out.println("0");
            }
        }
    }
}