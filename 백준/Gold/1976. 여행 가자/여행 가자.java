import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] element;
    static Integer[] plan;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numOfCity = Integer.parseInt(br.readLine());
        int numOfJourney = Integer.parseInt(br.readLine());

        element = new ArrayList[numOfCity + 1];
        plan = new Integer[numOfJourney + 1];

        for(int i=0; i<=numOfCity; i++){
            element[i] = new ArrayList();
        }

        for(int i=1; i<numOfCity + 1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j<numOfCity + 1; j++){
                int value = Integer.parseInt(st.nextToken());
                if(value == 1) element[i].add(j);
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<numOfJourney ; i++){
            plan[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] visited  = new boolean[numOfCity + 1];
        Queue<Integer> q = new LinkedList<>();

        q.add(plan[0]);
        visited[plan[0]] = true;

        while(!q.isEmpty()){

            Integer currentValue = q.poll();

            for(Integer next : element[currentValue]){
                if(!visited[next]){
                    visited[next] = true;
                    q.add(next);
                }
            }
        }

        String result = "YES";
        for(int i = 0; i < numOfJourney; i++) {
            if(!visited[plan[i]]) {
                result = "NO";
                break;
            }
        }
        System.out.println(result);
    }
}