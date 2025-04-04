import java.util.Scanner;

public class Main{
    
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();
        
        int result = A*B*C;
        
        int[] count = new int[10];
        
        if(A >= 100 && A < 1000 && B >= 100 && B < 1000 && C >= 100 && C < 1000){
            while(result > 0) {
                int digit = result % 10; // result가 0이 된다는 건 더이상 꺼낼 자릿수가 없다는 뜻, 값이 0이 되는 것은 아님.
                count[digit]++; // digit 값에 해당하는 숫자가 나온 횟수 +1
                result /= 10; // 마지막 자릿수를 안 없애면 숫자가 10개 이상 추출되어서 자릿수 하나씩 줄이기 위해 씀.
            }
            for (int i = 0; i < 10; i++){ // i를 0부터 시작, i는 10보다 작을 동안 반복, 반복마다 i를 1씩 증가.
                System.out.println(count[i]);
            }
        }
    }
    
}