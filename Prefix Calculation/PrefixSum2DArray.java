import java.util.*;
public class PrefixSum2DArray {
    static int N = (int)(1e3 + 10);
    static final int arr[][] = new int[N][N];
    static final int pref[][] = new int[N][N];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                arr[i][j] = scanner.nextInt();
                pref[i][j] = pref[i -1][j] + pref[i][j - 1] + arr[i][j] - pref[i -1][j - 1];
            }
        }
        int q = scanner.nextInt();
        while(q != 0) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            int d = scanner.nextInt();
            System.out.println(pref[c][d] - pref[a - 1][d] - pref[c][b - 1] + pref[a -1][b -1]);
            q--;
        }
        scanner.close();
    }
}