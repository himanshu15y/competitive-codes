import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class NOCHANGE {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String temp[] = br.readLine().split(" ");
            int n = Integer.parseInt(temp[0]);
            int p = Integer.parseInt(temp[1]);
            int ar[] = getIntArray(n);
            int h = -1;
            String ans = "";
            for (int i = 0; i < n; i++) {
                if (p % ar[i] != 0) {
                    Math.ceil((double) p / ar[i]);
                    ans += (int) Math.ceil((double) p / ar[i]);
                    h = i;
                } else {
                    ans += "0 ";
                }
            }
            if (h != -1)
                System.out.println("YES " + ans.trim());
            else {
                ar[n] = p;
                int gcd = findGCD(ar, n);
                System.out.println(gcd + " " + ar[0]);
                if (gcd == ar[0])
                    System.out.println("NO");
            }
        }
    }

    public static int[] getIntArray(int n) throws IOException {
        String temp[] = br.readLine().split(" ");
        int[] ar = new int[n + 1];
        for (int i = 0; i < n; i++) {
            ar[i] = Integer.parseInt(temp[i]);
        }
        return ar;
    }

    static int findGCD(int arr[], int n) {
        int result = arr[0];
        for (int i = 1; i < n; i++) {
            result = gcd(arr[i], result);
            if (result == 1) {
                return 1;
            }
        }
        return result;
    }

    static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
}