
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int meetingNumber = sc.nextInt();
        int TotalEndTime = 0; // 전체 회의종료시간
        int answer = 0;

        List<Meeting> meetingList = new ArrayList<Meeting>();

        for(int i=0; i<meetingNumber; i++){
            int startTime = sc.nextInt();
            int endTime = sc.nextInt();

            Meeting meeting = new Meeting(startTime , endTime);

            meetingList.add(meeting);
        }

        Collections.sort(meetingList);

        for(int i=0; i<meetingList.size(); i++){
            Meeting meeting = meetingList.get(i);

            if(meeting.startTime >= TotalEndTime) { 

                TotalEndTime = meeting.endTime;
                answer++;
            }
        }
        System.out.println(answer);
    }
}

class Meeting implements Comparable<Meeting>{
    int startTime;
    int endTime;
    public Meeting(int startTime , int endTime){
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public int compareTo(Meeting o){
        if(this.endTime == o.endTime) return this.startTime - o.startTime;
        return this.endTime - o.endTime;
    }
}