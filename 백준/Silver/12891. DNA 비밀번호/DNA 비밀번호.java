import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int answer = 0;

        int number = sc.nextInt();
        int password_length = sc.nextInt();
        char[] total_password = new char[number];

        String password = sc.next();

        for(int i=0; i<number; i++){
            total_password[i]  = password.charAt(i);
        }

        int A = sc.nextInt();
        int C = sc.nextInt();
        int G = sc.nextInt();
        int T = sc.nextInt();

        int A_count = 0;
        int C_count = 0;
        int G_count = 0;
        int T_count = 0;

        int lt = 0;
        int rt = lt + password_length - 1;
        for(int i=lt; i<=rt; i++){
            if(total_password[i] == 'A'){
                A_count++;
            }else if(total_password[i] == 'C'){
                C_count++;
            }else if(total_password[i] == 'G'){
                G_count++;
            }else if(total_password[i] == 'T'){
                T_count++;
            }
        }
        while(rt <= number - 1){
            if(A_count >= A && C_count >= C && G_count >= G && T_count >= T){
                answer++;
            }

            if(total_password[lt] == 'A'){
                A_count--;
            }else if(total_password[lt] == 'C'){
                C_count--;
            }else if(total_password[lt] == 'G'){
                G_count--;
            }else if(total_password[lt] == 'T'){
                T_count--;
            }
            lt++;

            rt++;
            if(rt > number - 1 ){break;}
            if(total_password[rt] == 'A'){
                A_count++;
            }else if(total_password[rt] == 'C'){
                C_count++;
            }else if(total_password[rt] == 'G'){
                G_count++;
            }else if(total_password[rt] == 'T'){
                T_count++;
            }

        }

        System.out.println(answer);
    }
}