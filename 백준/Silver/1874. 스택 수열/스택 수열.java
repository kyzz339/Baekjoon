import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int[] arr = new int[number];
        for(int i=0; i<number; i++){
            arr[i] = sc.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        int start_number = 1; //시작값, 오름차순
        List<String> result = new ArrayList<>();
        boolean possible = true;
        for(int i=0; i<number; i++){
            int a = arr[i];
            if(a >= start_number) {
                while (a >= start_number) {
                    stack.push(start_number++);
                    result.add("+");
                }
                stack.pop();
                result.add("-");
            }else{
                int n = stack.pop();
                if(n != a){
                    System.out.println("NO");
                    possible = false;
                    break;
                }else {
                    result.add("-");
                }
            }
        }
        if(possible){
            for(String s : result){
                System.out.println(s);
            }
        }
    }
}