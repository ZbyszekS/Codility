import static java.lang.Integer.max;

public class MaxProfit {
    public int solution(int[] A) {
        int N = A.length;
        if(N<2) return 0;
        
        int[] P = new int[N]; // max price from i to end
        
        int tMax = -1;
        for(int i = N-1; i >= 0; i--){
            tMax = max(tMax, A[i]);
            P[i] = tMax;
        }
        int maxGain = 0;
        for(int i = 0; i < N; i++){
            maxGain = max( maxGain, P[i]-A[i] )  ;
        }
        return maxGain;
    }
}
