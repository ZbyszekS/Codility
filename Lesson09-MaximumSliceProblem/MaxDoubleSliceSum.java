package L09_MaximumSliceProblem;

import static java.lang.Integer.max;

public class MaxDoubleSliceSum {
    public int solution(int[] A) {
        int N = A.length;  
        if(N == 3) return 0;
        int[] forward  = new int[N];
        int[] backward = new int[N];
        
        int maxEnding = 0;
        for(int i = 1; i < N-1; i++){
            maxEnding += A[i];
            maxEnding = max(maxEnding, 0);
            forward[i] = maxEnding;
        }
        maxEnding = 0;
        for(int i = N-2; i > 0; i--){
            maxEnding += A[i];
            maxEnding = max(maxEnding, 0);
            backward[i] = maxEnding;
        }
        int maxDblSlice = 0;
        for(int i = 1; i < N-1; i++){
            maxDblSlice = max(maxDblSlice, forward[i-1] + backward[i+1]);
        }

        return maxDblSlice;
    }
}
