import java.io.*;
import java.util.Scanner;

public class Main {
    static Integer[] element;
    public static void main(String[] args) throws IOException{

        Scanner sc = new Scanner(System.in);

        Integer numOfElement = sc.nextInt();
        Integer numOfQuestion = sc.nextInt();

        element = new Integer[numOfElement + 1];

        for(int i=0; i<=numOfElement; i++){
            element[i] = i;
        }

        for(int i=0; i<numOfQuestion; i++){
            Integer operation = sc.nextInt();
            Integer firstNumber = sc.nextInt();
            Integer secondNumber = sc.nextInt();
            if(operation == 0){
                union(firstNumber , secondNumber);
            }else{
                System.out.println(find(firstNumber , secondNumber));
            }
        }

    }

    public static void union(Integer first , Integer second){
        Integer firstRoot = find(first);
        Integer secondRoot = find(second);

        if(firstRoot != secondRoot){
            element[secondRoot] = firstRoot;
        }
    }

    public static String find(Integer first , Integer second){
        if(find(first) == find(second)) return "YES";
        else return "NO";
    }

    public static Integer find(Integer number){
        if(element[number] == number){
            return number;
        }else{
            element[number] = find(element[number]);
            return element[number];
        }
    }
}