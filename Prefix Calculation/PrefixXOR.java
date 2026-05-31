import java.util.*;
public class PrefixXOR {
    static int N = (int)(1e5 + 10);
    static int arr[] = new int[N + 1];
    static int pref[] = new int[N + 1];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        for(int i = 1; i <= n; i++) {
            arr[i] = scanner.nextInt();
            pref[i] = pref[i - 1] ^ arr[i];
        }
        while(q != 0) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            System.out.println(pref[r] ^ pref[l -1]);
            q--;
        }
    }
}