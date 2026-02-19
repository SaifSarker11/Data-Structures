import java.util.*;
public class GCDCalculation {
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
            while(q != 0) {
                int l = scanner.nextInt();
                int r = scanner.nextInt();
                int hcf = 0;
                for(int i = 1; i <= l -1; i++) {
                    hcf = gcd(hcf, arr[i]);
                }
                for(int i = r + 1; i <= n; i++) {
                    hcf = gcd(hcf, arr[i]);
                }
                System.out.println(hcf);
                q--;
            }
            t--;
        }
    }
}
