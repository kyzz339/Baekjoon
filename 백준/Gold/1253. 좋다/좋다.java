import java.util.*;

public class Main {

    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int answer = 0;

        int number = sc.nextInt();
        long[] array = new long[number];
        for (int i = 0; i < number; i++) {
            array[i] = sc.nextInt();
        }
        Arrays.sort(array);

        for(int i=0; i <array.length; i++) {
            int lt = 0;
            int rt = number - 1;
            long findValue = array[i];
            while (lt < rt) {
                if (array[lt] + array[rt] == findValue) {
                    if(lt != i && rt != i) {
                        answer++;
                        break;
                    }else if(lt == i){
                        lt++;
                    }else if(rt == i){
                        rt--;
                    }
                } else if (array[lt] + array[rt] < findValue) {
                    lt++;
                } else if (array[lt] + array[rt] > findValue) {
                    rt--;
                }
            }
        }

        System.out.println(answer);
    }
}