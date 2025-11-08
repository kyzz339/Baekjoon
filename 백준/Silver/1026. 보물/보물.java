import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for(int i = 0; i < a; i++) {
            list1.add(scanner.nextInt());
        }
        for(int i = 0; i < a; i++) {
            list2.add(scanner.nextInt());
        }

        List<Integer> sortedList1 = list1.stream()
                .sorted()
                .collect(Collectors.toList());

        List<Integer> sortedList2 = list2.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        Integer result = 0;
        for(int i = 0; i<sortedList1.size(); i++) {
            result += sortedList1.get(i) * sortedList2.get(i);
        }
        System.out.println(result);
    }
}

