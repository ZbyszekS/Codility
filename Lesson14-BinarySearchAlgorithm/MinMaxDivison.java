// https://app.codility.com/demo/results/trainingM7QXX5-82Y/
// determina min and max possible value of solution and test it in binary search fashion against input data

import static java.lang.Math.max;

public class MinMaxDivison {
    public int solution(int K, int M, int[] A) {
        int N = A.length;
        int maxV = Integer.MIN_VALUE;
        int sumA = 0;
        int minP;
        int lowB, highB, midP;
        for(int a: A){
            maxV = max(maxV, a);
            sumA += a;
        }
        minP = sumA/K;
        lowB  = max(minP, maxV);
        highB = sumA;
        
        while(lowB != highB){
            midP = (highB - lowB)/2 + lowB;
            if( isOk(midP, A, N, K)){
                highB = midP;
            } else {
                lowB = midP +1;
            }
        }
        return highB;
    }

    private boolean isOk(int maxS, int[] A, int N, int K) {
        boolean o = false;
        int ts = 0;
        int co = 1;
        int i  = 0;
        while(i < N && co <= K){
            if(ts + A[i] <= maxS){
                ts += A[i];
            } 
            else {
                co++;
                ts = A[i];
            }
            i++;
        }
        return i == N && co <= K;
    }
}
