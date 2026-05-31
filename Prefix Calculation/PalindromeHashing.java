import java.util.*;
public class PalindromeHashing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t != 0) {
            int n = scanner.nextInt();
            int q = scanner.nextInt();
            scanner.nextLine();
            int hsh[] = new int[26];
            String str = scanner.nextLine();
            while(q != 0) {
                int l = scanner.nextInt();
                int r = scanner.nextInt();
                for(int i = 0; i < 26; i++) {
                    hsh[i] = 0;
                }
                l--; r--;
                for(int i = l; i <= r; i++) {
                    hsh[str.charAt(i) - 'a']++;
                }
                int oddCount = 0;
                for(int i = 0; i < 26; i++) {
                    if(hsh[i] % 2 != 0) oddCount++;
                }
                if(oddCount > 1) System.out.println("No");
                else System.out.println("Yes");
                q--;
            }
            t--;
        } 
    }
}
