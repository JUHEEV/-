import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static boolean[] 방문함; // 각 컴퓨터 방문 여부
    static ArrayList<Integer>[] 연결정보; // 연결된 컴퓨터 정보
    static int 감염개수 = 0;

    public static void main(String[] args) {
        Scanner 입력 = new Scanner(System.in);

        int 컴퓨터수 = 입력.nextInt(); // 정점 개수
        int 연결쌍수 = 입력.nextInt(); // 간선 개수

        방문함 = new boolean[컴퓨터수 + 1]; // 1번부터 시작
        연결정보 = new ArrayList[컴퓨터수 + 1];

        // 리스트 초기화
        for (int i = 1; i <= 컴퓨터수; i++) {
            연결정보[i] = new ArrayList<>();
        }

        // 연결 정보 입력
        for (int i = 0; i < 연결쌍수; i++) {
            int a = 입력.nextInt();
            int b = 입력.nextInt();
            연결정보[a].add(b);
            연결정보[b].add(a); // 양방향 연결
        }

        dfs(1); // 1번 컴퓨터부터 시작

        System.out.println(감염개수 - 1); // 1번 자신 제외하고 출력
    }

    // 깊이 우선 탐색
    public static void dfs(int 번호) {
        방문함[번호] = true;
        감염개수++;

        for (int 연결된 : 연결정보[번호]) {
            if (!방문함[연결된]) {
                dfs(연결된);
            }
        }
    }
}
