package L11_SieveOfEratosthenes;

public class CountSemiprimes {
    public int[] solution(int N, int[] P, int[] Q) {
        int   maxV         = 50_000;
        int[] o            = new int[P.length];
        int[] primes       = primesTill(maxV/2);
        int[] semiPrimes   = semiPrimesOf(primes, maxV);
        int[] semiPrimesPS = new int[semiPrimes.length+1];
        
        for (int i = 0; i < semiPrimes.length; i++){
            semiPrimesPS[i+1] = semiPrimesPS[i] + semiPrimes[i];
        }
        for (int i = 0; i < P.length; i++){
            o[i] = semiPrimesPS[Q[i]+1] - semiPrimesPS[P[i]];
        }
        return o;
    }
  

    private int[] primesTill(int maxV) {
       boolean[] m    = new boolean[maxV+1];
       int       sqrt = (int)(Math.sqrt(maxV) + 0.5);
       int       size = 0;
       
       for(int i = 2; i <= sqrt; i++){
           for(int k = i*i; k <= maxV; k +=i){
               m[k] = true;
               size++;
           }
       }

       int[] o  = new int[size];
       int   io = 0;
       for(int i = 2; i < maxV+1; i++){
           if(!m[i])
               o[io++] = i;
       }
       return o;
    }
    
  
  private int[] semiPrimesOf(int[] primes, int maxV) {
        int[] o = new int[maxV+1];
        for(int i = 0; i < primes.length && primes[i]*primes[i] <= maxV; i++){
            for(int j = i; j < primes.length && primes[i]*primes[j] <= maxV; j++){
                o[primes[i] * primes[j]] = 1;
            }
        }
        return o;
    }
    
    
}
    

