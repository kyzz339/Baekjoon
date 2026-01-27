import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static Integer[] persons;
    static ArrayList<Integer> truth;
    static ArrayList<Integer>[] partyList;


    public static void main(String[] args) throws IOException {
        truth = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer token = new StringTokenizer(br.readLine());
        int result = 0;
        int N = Integer.parseInt(token.nextToken()); // 사람의 수
        int M = Integer.parseInt(token.nextToken()); // 파티의 수

        persons = new Integer[N+1];
        partyList = new ArrayList[M+1];
        for(int i=0; i<=N; i++){
            persons[i] = i;
        }

        for(int i=0; i<=M;i++){
            partyList[i] = new ArrayList();
        }

        //진실을 아는 사람 수 , 번호
        token = new StringTokenizer(br.readLine());
        int truthPerson = Integer.parseInt(token.nextToken());
        if(truthPerson != 0){
            int firstTruth = Integer.parseInt(token.nextToken());
            truth.add(firstTruth);
            while(token.hasMoreTokens()){ // 0명이 아닐때 진실을 아는 사람 지정
                int truthPersonNumer = Integer.parseInt(token.nextToken());
                truth.add(truthPersonNumer);
                Union(firstTruth , truthPersonNumer);
            }
        }
        //M개의 줄 -> 파티마다 오는 사람의 수와 번호
        for(int i=1; i<=M; i++){
            token = new StringTokenizer(br.readLine());

            int numOfParticipant = Integer.parseInt(token.nextToken());

            int firstPerson = Integer.parseInt(token.nextToken());
            partyList[i].add(firstPerson);

            for(int j=1; j<numOfParticipant; j++){
                int nextvalue = Integer.parseInt(token.nextToken());
                partyList[i].add(nextvalue);
                Union(firstPerson , nextvalue);
            }
        }

        if(truthPerson == 0 ){
            result = M;
        }else{
            int truthRoot = Find(truth.get(0));

            for(int i=1; i<=M; i++){
                boolean canLie = true;

                for(int person : partyList[i]){
                    if(Find(person) == truthRoot){
                        canLie = false;
                        break;
                    }
                }
                if(canLie) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }

    public static void Union(int first , int second){
        int rootFirst = Find(first);
        int rootSecond = Find(second);

        if(rootFirst != rootSecond){
            persons[rootSecond] = rootFirst;
        }
    }

    public static int Find(int number){
        if(number != persons[number]){
            return persons[number] = Find(persons[number]);
        }else return number;
    }
}