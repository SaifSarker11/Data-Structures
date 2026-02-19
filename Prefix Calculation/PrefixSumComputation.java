import java.util.*;
public class PrefixSumComputation {
    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t != 0) {
            int n = scanner.nextInt();
            int q = scanner.nextInt();
            int arr[] = new int[n + 10];
            for(int i = 1; i <= n; i++) {
                arr[i] = scanner.nextInt();
            }
            int forward[] = new int[n + 10];
            int backward[] = new int[n + 10];
            while(q != 0) {
                forward[0] = backward[n + 1] = 0;
                int l = scanner.nextInt();
                int r = scanner.nextInt();
                for(int i = 1; i <= n; i++) {
                    forward[i] = gcd(forward[i - 1], arr[i]);
                }
                for(int i = n; i >= 1; i--) {
                    backward[i] = gcd(backward[i + 1], arr[i]);
                }
                System.out.println(gcd(forward[l - 1], backward[r + 1]));
                q--;
            }
            t--;
        }
    }
}
