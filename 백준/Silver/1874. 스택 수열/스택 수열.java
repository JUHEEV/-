import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        
        // 목표 수열을 저장하기 위한 배열
        int[] target = new int[N];
        for (int i = 0; i < N; i++) {
            target[i] = scanner.nextInt();
        }
        
        // 결과 문자열을 누적할 StringBuilder 객체를 생성
        StringBuilder sb = new StringBuilder();
        
        // java.util.Stack을 사용하여 스택 연산(push, pop 등)을 수행
        Stack<Integer> stack = new Stack<>();
        
        // nextPush는 스택에 넣을 다음 숫자
        // 1부터 시작해서 N까지 순서대로 push
        int nextPush = 1;
        
        // possible 변수는 목표 수열을 만들 수 있는지 여부를 저장
        boolean possible = true;
        
        for (int i = 0; i < N; i++) {
            int currentTarget = target[i];
            
            // 현재 목표 숫자(currentTarget)가 나올 때까지
            // 아직 push하지 않은 숫자(nextPush)가 currentTarget보다 작거나 같으면 계속 push
            while (nextPush <= currentTarget) {
                stack.push(nextPush);         // 스택에 nextPush 값을 추가
                sb.append("+\n");              // push 연산을 했다는 것을 "+" 기호로 기록
                nextPush++;                   // 다음 숫자로 이동
            }
            
            // 스택의 최상단 숫자(stack.peek())가 현재 목표 숫자와 같은지 확인
            if (stack.peek() == currentTarget) {
                stack.pop();                  // 같다면 스택에서 해당 숫자를 제거 (pop)
                sb.append("-\n");             // pop 연산을 했다는 것을 "-" 기호로 기록
            } else {
                // 만약 스택의 최상단 숫자가 목표 숫자와 다르면
                // 목표 수열을 만들 수 없으므로 possible을 false로 설정하고 반복을 중단
                possible = false;
                break;
            }
        }
        
        // 모든 연산이 완료된 후 목표 수열을 만들 수 있으면 연산 기록 출력
        // 그렇지 않으면 "NO"를 출력
        if (possible) {
            System.out.print(sb);
        } else {
            System.out.print("NO");
        }
        
    }
}
