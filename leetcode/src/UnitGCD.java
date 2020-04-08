import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UnitGCD {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n=100000000;
//        long l = System.currentTimeMillis();
        int[] listOfprimes =new int[n];
//        System.out.println("Time taken:-"+(System.currentTimeMillis()-l));
//        for(int a:listOfprimes) {
//            System.out.print(a + " ");
//            if (a == 0)
//                break;
//        }
//        System.out.println();
        long l = System.currentTimeMillis();
        listOfprimes = getListOfPrimesUsingSieve(n);
        System.out.println("Time taken:-"+(System.currentTimeMillis()-l));

//        l = System.currentTimeMillis();
//        listOfprimes = getListOfPrimeUsingNxN(n);
//        System.out.println("Time taken:-"+(System.currentTimeMillis()-l));
//        for(int a:listOfprimes) {
//            System.out.print(a + " ");
//            if (a == 0)
//                break;
//        }
//        int t = Integer.parseInt(br.readLine());
//        while(t-->0)
    }

    private static int[] getListOfPrimes(int i) {
        int z=0;
        int[] listOfPrimes= new int[i+1];
        listOfPrimes[z++]=2;
        for (int j = 3; j < i; j+=2) {
            boolean isPrime=true;
            for (int k = 0; k < z && listOfPrimes[k]*listOfPrimes[k] <= j; k++) {
                if(j%listOfPrimes[k]==0){
                    isPrime=false;
                    break;
                }
            }
            if(isPrime)
                listOfPrimes[z++]=j;
        }
        return listOfPrimes;
    }

    private static int[] getListOfPrimesUsingSieve(int n)
    {
        // Create a boolean array "prime[0..n]" and initialize
        // all entries it as true. A value in prime[i] will
        // finally be false if i is Not a prime, else true.
        boolean prime[] = new boolean[n+1];
        for(int i=0;i<n;i++)
            prime[i] = true;

        for(int p = 2; p*p <=n; p++)
        {
            // If prime[p] is not changed, then it is a prime
            if(prime[p] == true)
            {
                // Update all multiples of p
                for(int i = p*p; i <= n; i += p)
                    prime[i] = false;
            }
        }

        // Print all prime numbers
        int[] listOfPrimes = new int[n];
        int z=0;
        for(int i = 2; i <= n; i++)
        {
            if(prime[i])
                listOfPrimes[z++]=i;
        }
        return listOfPrimes;
    }

    static int[] getListOfPrimeUsingNxN(int n) {
        int[] listOfPrimes = new int[n];
        int z=0;
        for (int i = 2; i <= n; i++) {
                if (isPrime(i))
                    listOfPrimes[z++]=i;
            }
        return listOfPrimes;
    }
        static boolean isPrime(int n)
        {
            // Corner cases
            if (n <= 1)
                return false;
            if (n <= 3)
                return true;

            // This is checked so
            // that we can skip
            // middle five numbers
            // in below loop
            if (n % 2 == 0 ||
                    n % 3 == 0)
                return false;

            for (int i = 5;
                 i * i <= n; i = i + 6)
                if (n % i == 0 ||
                        n % (i + 2) == 0)
                    return false;

            return true;
        }

    public static int[] getIntArray ( int n) throws IOException {
        String temp[] = br.readLine().split(" ");
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = Integer.parseInt(temp[i]);
        }
        return ar;
    }
}
