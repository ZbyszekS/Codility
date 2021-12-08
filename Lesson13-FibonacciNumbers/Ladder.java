
// https://app.codility.com/demo/results/trainingG2T2RJ-39D/
// it is enough to modulo divide rest_from_max_modulo_division by actual divisor

public class Ladder {
    public int[] solution(int[] A, int[] B) {
        int           N = A.length;
        int[]         o = new int[N];                // outcome
        int[]         powerOfTwo = getPowersOf2(30); // possible divisors
        int[]         fibModuloByMaxDivisor = getModuloByMaxDivisor(powerOfTwo[30]);
        
        for(int i = 0; i < N; i++){
            int  divisor = powerOfTwo[ B[i] ];
            int  rungs   = A[i];
            o[i] = fibModuloByMaxDivisor[rungs] % divisor;
        }

        return o;
    }    

    private int[] getPowersOf2(int n) {
        int[] o = new int[n+1];
        o[0] = 1;
        for(int i = 1; i < n+1; i++){
            o[i] = o[i-1] + o[i-1];
        }
        return o;
    }

    
    private int[]  getModuloByMaxDivisor(int maxDivisor) {
        int n = 50_000;
        int f1 = 0;
        int f2 = 1;
        int s  = 0;
        int[] o = new int[n+1];
        for(int i = 1; i <= n; i++){
            s = (f1 + f2) % maxDivisor;
            f1 = f2;
            f2 = s;
            o[i] = s;
        }
        return o;
    }

}
