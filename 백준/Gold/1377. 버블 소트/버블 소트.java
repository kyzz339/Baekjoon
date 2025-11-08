import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(br.readLine());
        mData[] arrayData = new mData[number];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < number; i++) {
            int value = Integer.parseInt(br.readLine());
            mData data = new mData(i , value);
            arrayData[i] = data;
        }

        Arrays.sort(arrayData);

        for(int i = 0 ; i<number; i++){
            max = Math.max(max, arrayData[i].index - i);
        }

        System.out.println(max + 1);
    }

    static class mData implements Comparable<mData>{
        int index;
        int value;
        public mData(int index , int value){
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(mData o1){
            return this.value - o1.value;
        }
    }
}