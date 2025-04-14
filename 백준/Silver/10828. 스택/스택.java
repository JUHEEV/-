import java.util.Scanner;
public class Main {

    public static int[] stack;
    public static int size = 0;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = in.nextInt();

        stack = new int[N];

        for(int i = 0; i < N; i++) {

            String str = in.next();

            switch (str) { // 명령어 문자열의 내용에 따라 서로 다른 케이스 실행

                case "push":
                    push(in.nextInt());
                    break;

                case "pop":
                    sb.append(pop()).append('\n');
                    // 명령어 pop 메서드 호출, 스택 최상위 요소 제거 후 값 반환 받음
                    // 반환된 값 StringBuilder 객체 sb에 추가하고 줄바꿈
                    break;

                case "size": // 저장된 원소 개수 반환
                    sb.append(size()).append('\n');
                    break;

                case "empty":
                    sb.append(empty()).append('\n');
                    break;

                case "top":
                    sb.append(top()).append('\n');
                    break;
            }

        }
        System.out.println(sb);
    }

    public static void push(int item) {
        stack[size] = item;
        size++;
    }

    public static int pop() {
        if(size == 0) {
            return -1;
        }
        else {
            int res = stack[size - 1]; // 스택 최상위 요소 변수 res에 저장
            stack[size - 1] = 0; // 인덱스는 0부터 시작해서 size-1
            size--; // 원소 제거했으므로 스택 크기 1 감소
            return res;
        }
    }

    public static int size() {
        return size;
    }

    public static int empty() {
        if(size == 0) { // 스택에 원소가 없다면 1 반환
            return 1;
        }
        else {
            return 0;
        }
    }

    public static int top() {
        if(size == 0) {
            return -1; // 스택이 비어있다면 -1을 반환
        }
        else {
            return stack[size - 1];
        }
    }

}