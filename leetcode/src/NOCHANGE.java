import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class NOCHANGE {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public int[] yesCondition(int[] ar, int ind, int min, int n, int overpayValue, int[] ans) {
//        System.out.println(ind + "==" + ar.length);
        if (ind >= ar.length) {
            return ans;
        }
        if (overpayValue > n) {
            return ans;
        }
//        System.out.println(ind + "--" + overpayValue + "--"+ ar[ind]);
        int[] ans1 = yesCondition(ar, ind + 1, Math.min(ar[ind], min), n, overpayValue, ans);
        ans[ind] += 1;
        int[] ans2 = yesCondition(ar, ind, Math.min(ar[ind], min), n, overpayValue + ar[ind], ans);
        for (int i = 0; i < ans1.length; i++) {
            System.out.print(ans1[i] + "--");
        }
        System.out.println();
        return ans1;
    }
    public static int[] getIntArray ( int n) throws IOException {
            String temp[] = br.readLine().split(" ");
            int[] ar = new int[n];
            for (int i = 0; i < n; i++) {
                ar[i] = Integer.parseInt(temp[i]);
            }
            return ar;
        }
    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String temp[] = br.readLine().split(" ");
            int n = Integer.parseInt(temp[0]);
            int p = Integer.parseInt(temp[1]);
            int ar[] = getIntArray(n);
            int h = -1;
            int[] ans = new int[n];
            for (int i = 0; i < n; i++) {
                if (ar[i] > p) {
                    ans[i] = 1;
                    h = 0;
                    break;
                } else if (p % ar[i] != 0) {
                    ans[i] = (int) Math.ceil((double) p / ar[i]);
                    h = 0;
                    break;
                }
            }
            if (h == 0) {
                System.out.print("YES " );
                for (int i = 0; i < n - 1; i++) {
                    System.out.print( ans[i] + " ");
                }
                System.out.println(ans[n - 1]);
            } else {
                for (int i = 1; i < n; i++) {
                    if (ar[i] % ar[i - 1] != 0) {
                        int o = p / ar[i] - 1;
                        int oo = (p - o * ar[i]) / ar[i - 1];
                        if (oo * ar[i - 1] < p)
                            oo++;
                        ans[i - 1] = oo;
                        ans[i] = o;
                        h = 2;
                        break;
                    }
                }
                if (h == 2) {
                    System.out.print("YES ");
                    for (int i = 0; i < n - 1; i++) {
                        System.out.print(ans[i] + " ");
                    }
                    System.out.println(ans[n - 1]);
                }
            }
            if(h==-1)
                System.out.println("NO");
        }
    }
}
//            if (n == 1 && p % ar[0] == 0 )
//                System.out.println("NO");
//            else if (n == 2 && ar[0] == 1 && p % ar[1] == 0) {
//                System.out.println("NO");
//            } else if (p == 1) {
//                if (n == 1 && ar[0] != 1)
//                    System.out.println("NO");
//                else if (n == 2 && ar[1] != 1)
//                    System.out.println("NO");
//            } else {
//                int hh = 0;
//                for (int i = 1; i < n; i++) {
//                    if (!(ar[i] <= p && p % ar[i] == 0 && ar[i] % ar[i - 1] == 0))
//                        hh = 1;
//                }
//                if (hh == 0)
//                    System.out.println("NO");
//                    //any number not divisible
//                else {
//
//                    if (h != -1)
//                        System.out.println("YES " + ans.trim());
//                    else {
//                     //   System.out.println("n=" + n + "p=" + p);
//                        int l=ar.length-1;
//                        while(ar[l]%ar[l-1]==0)
//                            l--;
//                        int kk=0;
//                        String ans1="";
//                        for (int i = 0; i < ar.length; i++) {
//                            if(i!=l && i!=l-1)
//                                ans1+="0 ";
//                            else if(kk++==0){
//                                int o = p/ar[l] -1;
//                                int oo = (p-o*ar[l])/ar[l-1];
//                                if(oo*ar[l-1]<p)
//                                    oo++;
//                                ans+=oo+" "+o;
//                            }
//                        }
//                        System.out.println(ans1.trim());
////                        new NOCHANGE().yesCondition(ar, 0, ar[n-1], p, 0, g);
//                    }
//                }
//            }
//        }
//    }
//
//
//
//        static int findGCD ( int arr[], int n){
//            int result = arr[0];
//            for (int i = 1; i < n; i++) {
//                result = gcd(arr[i], result);
//                if (result == 1) {
//                    return 1;
//                }
//            }
//            return result;
//        }
//
//        static int gcd ( int a, int b){
//            if (a == 0)
//                return b;
//            return gcd(b % a, a);
//        }
//    }