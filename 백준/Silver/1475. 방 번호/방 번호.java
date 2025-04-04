import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] count = new int[10];

        while (N <= 1000000 && N > 0) { // N은 자연수니까 N > 0 이렇게 씀.
            int digit = N % 10;
            count[digit]++;
            N /= 10;
        }

        int sixNineCount = count[6] + count[9]; // 숫자 6과 9는 뒤집어서 서로 쓰기 가능.
        count[6] = count[9] = (sixNineCount + 1) / 2; // 정수 나눗셈이기 때문에 소수점은 버려져서 +1을 하면 올림효과가 나서 원하는 세트의 수가 나옴.
        // 올림처리를 안하면 알맞은 세트의 개수가 부족하게 나올 수 있음.

        int max = 0; // max 가 0부터 시작된다.
        for (int i = 0; i < 10; i++) {
            max = Math.max(max, count[i]); // Math.max 는 max 와 count[i] 값 중 더 큰 값을 돌려주는 함수.
            }
        System.out.println(max);
        }
    }