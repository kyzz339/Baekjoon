import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int result = 0;
        int n = sc.nextInt();

        for(int i=0; i<n; i++){
            int firstnumber = sc.nextInt();
            int secondnumber = sc.nextInt();

            result = MOD(firstnumber, secondnumber);
            System.out.println((firstnumber*secondnumber)/result);
        }
    }

    public static int MOD(int first , int second){

        int result = 0;

        if(first > second){
            int temp = first%second;
            if(temp == 0) return second;
            result = MOD(temp , second);
        }else{
            int temp = second%first;
            if(temp == 0) return first;
            result = MOD(temp , first);
        }
        return result;
    }
}