import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 총 명령어(숫자)의 개수 K를 입력받습니다.
        int K = scanner.nextInt();

        //  크기가 K인 배열을 생성
        int[] stack = new int[K];
        // 현재 스택에 저장된 숫자의 개수를 나타내는 변수
        int size = 0;

        // K번 반복하면서 각 숫자 명령어를 처리
        for (int i = 0; i < K; i++) {
            // 한 줄에 하나의 정수를 입력
            int number = scanner.nextInt();

            // 입력한 숫자가 0이면 최근에 추가한 수를 제거
            if (number == 0) {
                // 스택에 저장된 숫자가 있다면 size 를 감소시켜 "pop" 효과
                if (size > 0) {
                    size--;
                }
            }
            // 입력한 숫자가 0이 아니면 스택에 추가
            else {
                // 현재 size 위치에 숫자 저장
                stack[size] = number;
                // 스택의 크기를 1 증가
                size++;
            }
        }

        // 스택에 남아있는 숫자들의 합
        int sum = 0;
        // 배열의 첫 번째 원소부터 size-1까지 더하기
        for (int i = 0; i < size; i++) {
            sum += stack[i];
        }

        System.out.println(sum);

    }
}