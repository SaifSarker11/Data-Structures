import java.util.*;
public class PalindromePrefixSumHashing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t != 0) {
            int n = scanner.nextInt();
            int q = scanner.nextInt();
            scanner.nextLine();
            String str = scanner.nextLine();
            int hsh[][] = new int[n + 1][26];
            for(int i = 0; i < n; i++) {
                hsh[i + 1][str.charAt(i) - 'a']++;
            }
            for(int i = 0; i < 26; i++) {
                for(int j = 1; j <= n; j++) {
                    hsh[j][i] += hsh[j - 1][i];
                }
            }  
            while(q != 0) {
                int l = scanner.nextInt();
                int r = scanner.nextInt();
                int oddCount = 0;
                for(int i = 0; i < 26; i++) {
                    int charCount = hsh[r][i] - hsh[l - 1][i];
                    if(charCount % 2 != 0) oddCount++;
                }
                if(oddCount > 1) System.out.println("No");
                else System.out.println("Yes");
                q--;
            }
            t--;
        }
    }
}
