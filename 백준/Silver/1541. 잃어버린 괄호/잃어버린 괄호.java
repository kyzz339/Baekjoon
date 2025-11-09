import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        List<Integer> number = new ArrayList<>();
        List<Character> cord = new ArrayList<>();
        int current_number = 0;
        for(char a : input.toCharArray()){
            if(a == '+' || a == '-'){
                number.add(current_number);
                cord.add(a);
                current_number = 0;
            }else{
                int charToint = Integer.parseInt(String.valueOf(a));
                current_number = current_number*10 + charToint;
            }
        }

        number.add(current_number);

        int result = number.get(0);
        boolean minus = false;
        for(int i=1 ; i<number.size() ; i++){
            if(cord.get(i - 1) == '+'){
                if(minus){
                    result = result - number.get(i);
                }else{
                    result = result + number.get(i);
                }
            }else{
                  minus = true;
                  result = result - number.get(i);
            }
        }
        System.out.println(result);
    }
}