import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 카드 수
        Queue<Integer> queue = new LinkedList<>(); // 큐 만들기

        // 1부터 n까지 큐에 넣기
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        // 카드가 한 장 남을 때까지 반복
        while (queue.size() > 1) {
            queue.poll(); // 제일 위 카드 버리기
            int num = queue.poll(); // 그 다음 카드 꺼내기
            queue.add(num); // 맨 아래에 다시 넣기
        }

        // 마지막 남은 카드 출력
        System.out.println(queue.peek());
    }
}
