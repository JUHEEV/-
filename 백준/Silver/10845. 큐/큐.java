import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();

        int N = scanner.nextInt();

        // 큐를 표현할 배열 생성, 최대 N개의 원소
        int[] queue = new int[N];

        // 큐의 가장 앞(front)과 마지막 (back)의 위치를 나타내는 변수
        // front: pop 또는 front 명령어를 처리할 때 사용
        // back: push 명령어를 처리할 때 값을 저장할 위치를 가리킴
        int front = 0, back = 0;

        // 총 N개의 명령어를 반복문을 통해 처리합니다.
        for (int i = 0; i < N; i++) {
            String command = scanner.next();

            if (command.equals("push")) {
                // 다음에 오는 정수 값을 입력받아 큐에 추가
                int value = scanner.nextInt();
                queue[back] = value;  // 큐의 현재 back 위치에 값을 저장
                back++;               // 저장 후, back 포인터를 1 증가
            }
            else if (command.equals("pop")) {
                // "pop" 명령어: 큐의 가장 앞에 있는 값을 꺼내어 출력
                // 큐가 비어있으면 (front와 back이 같으면) -1을 결과에 추가
                if (front == back) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(queue[front]).append("\n");
                    front++;  // 값을 꺼낸 후 front 포인터를 1 증가시켜 큐에서 제거한 효과
                }
            }
            else if (command.equals("size")) {
                // "size" 명령어: 큐에 들어있는 원소의 개수는 back - front로 계산
                sb.append(back - front).append("\n");
            }
            else if (command.equals("empty")) {
                // "empty" 명령어: 큐가 비어있으면 1, 아니면 0을 출력
                if (front == back) {
                    sb.append("1").append("\n");
                } else {
                    sb.append("0").append("\n");
                }
            }
            else if (command.equals("front")) {
                // "front" 명령어: 큐의 가장 앞에 있는 원소 출력
                // 큐가 비어있으면 -1을 출력
                if (front == back) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(queue[front]).append("\n");
                }
            }
            else if (command.equals("back")) {
                // "back" 명령어: 큐의 가장 뒤에 있는 원소 출력
                // 큐가 비어있으면 -1을 출력
                if (front == back) {
                    sb.append("-1").append("\n");
                } else {
                    sb.append(queue[back - 1]).append("\n");
                }
            }
        }

        System.out.print(sb);
    }
}