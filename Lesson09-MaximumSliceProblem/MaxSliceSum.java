import static java.lang.Integer.max;

public class MaxSliceSum {
    public int solution(int[] A) {
        int N = A.length;
        if(N == 1) return A[0];
        
        int maxEnding = 0;
        int maxSlice  = 0;
        int maxValue  = Integer.MIN_VALUE;
        for(int a: A){
            maxEnding = max(0, maxEnding + a);
            maxSlice = max(maxSlice, maxEnding);
            maxValue = max(maxValue, a);
        }
        if(maxSlice == 0){
            if(maxValue < 0){
                maxSlice = maxValue;
            }
        }
        return maxSlice;
    }
}
