import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numOfLesson = sc.nextInt();
        int numOfBlueRay = sc.nextInt();
        int[] arrayOfLessons = new int[numOfLesson];

        int result = 0;
        for(int i=0; i<numOfLesson; i++){
            arrayOfLessons[i] = sc.nextInt();
        }
        int minSize = Arrays.stream(arrayOfLessons).max().getAsInt();
        int maxSize = Arrays.stream(arrayOfLessons).sum();
        while(minSize <= maxSize){
            int midSize = (minSize + maxSize)/2;
            int cnt = 1 , sum = 0;
            for(int i=0; i<numOfLesson; i++){
                if(sum + arrayOfLessons[i] > midSize){
                    cnt++;
                    sum = 0;
                    sum += arrayOfLessons[i];
                }else {
                    sum += arrayOfLessons[i];
                }
            }
            if(cnt > numOfBlueRay){// cnt 큰건 크기를 늘려야함
                minSize = midSize + 1;
            }else{ // cnt가 작은건 크기를 줄여야 함
                result = midSize;
                maxSize = midSize - 1;
            }
        }
        System.out.println(result);
    }
}