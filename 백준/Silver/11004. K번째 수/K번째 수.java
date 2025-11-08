import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {

        //Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int number = Integer.parseInt(st.nextToken());
        int result_index = Integer.parseInt(st.nextToken());
        int[] array = new int[number];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<array.length; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        int lt = 0, rt = number - 1;

        quickSort(array , lt, rt);

        System.out.println(array[result_index - 1]);
    }

   public static void quickSort(int[] array , int lt , int rt){
        if(lt >= rt) return;
        int pivot = array[(lt + rt) / 2]; //pivot 중간값

        int i= lt ,  j = rt;

        while(i <= j){
            while(array[i] < pivot) i++;
            while(array[j] > pivot) j--;

            if(i <= j){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        quickSort(array , lt , j );
        quickSort(array ,  i , rt );
    }
}