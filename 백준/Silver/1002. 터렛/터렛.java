import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        List<Turet> turets = new ArrayList<>();
        List<Integer> result = new ArrayList();
        for(int i=0; i<a ; i++) {
            Turet turet = new Turet();
            turet.x1 = scanner.nextInt();
            turet.y1 = scanner.nextInt();
            turet.r1 = scanner.nextInt();
            turet.x2 = scanner.nextInt();
            turet.y2 = scanner.nextInt();
            turet.r2 = scanner.nextInt();

            turets.add(turet);
        }
        for (Turet turet : turets) {
            double dx = turet.x2 - turet.x1;
            double dy = turet.y2 - turet.y1;
            double distance = Math.sqrt(dx * dx + dy * dy);

            int r1 = turet.r1;
            int r2 = turet.r2;
            int rSum = r1 + r2;
            int rDiff = Math.abs(r1 - r2);

            if (turet.x1 == turet.x2 && turet.y1 == turet.y2 && r1 == r2) {
                result.add(-1); // 같은 중심, 같은 반지름
            } else if (turet.x1 == turet.x2 && turet.y1 == turet.y2) {
                result.add(0); // 같은 중심, 반지름 다름
            } else {
                if (distance == rSum || distance == rDiff) {
                    result.add(1); // 외접 or 내접
                } else if (rDiff < distance && distance < rSum) {
                    result.add(2); // 두 점에서 만남
                } else {
                    result.add(0); // 만나지 않음
                }
            }
        }
        for(Integer x : result){
            System.out.println(x);
        }
    }
    public static class Turet{
        int x1;
        int y1;
        int r1;
        int x2;
        int y2;
        int r2;
    }
}

