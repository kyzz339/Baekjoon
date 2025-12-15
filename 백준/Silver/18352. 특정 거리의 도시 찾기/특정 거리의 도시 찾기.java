import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static ArrayList<Integer> answer = new ArrayList<>();
    static int[] dist;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int numOfCity = sc.nextInt();
        int numOfLoad = sc.nextInt();
        int distance = sc.nextInt();
        int startCity = sc.nextInt();

        graph = new ArrayList[numOfCity+ 1];
        dist = new int[numOfCity+ 1];
        for(int i=1; i<=numOfCity; i++){
            graph[i] = new ArrayList<>();
        }

        Arrays.fill(dist, -1);

        for(int i=0; i<numOfLoad; i++){ // 그래프 작성 완료
            int start = sc.nextInt();
            int end = sc.nextInt();
            graph[start].add(end);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(startCity);
        dist[startCity] = 0;

        while(!queue.isEmpty()){
            int currentCity = queue.poll();

            for(int nextCity : graph[currentCity]){
                if(dist[nextCity] == -1){
                    dist[nextCity] = dist[currentCity] + 1;
                    queue.add(nextCity);
                }
            }
        }

        for(int i=1; i<=numOfCity; i++){
            if(dist[i] == distance){
                answer.add(i);
            }
        }

        if(answer.isEmpty()){
            System.out.println(-1);
        }else{
            Collections.sort(answer);
            for(int city : answer){
                System.out.println(city);
            }
        }
    }

}