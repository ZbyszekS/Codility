public class Peaks {
    public int solution(int[] A) {
        int N = A.length;
        if (N < 3)
            return 0;
        
        int[] sumP = new int[N+1];
        for(int i = 0; i < N; i++){
            sumP[i+1] = sumP[i];
            if ( isPeak(i, A) ){
                sumP[i+1]++;
            }
        }
        for(int len = 2; len <= N; len++){
            if(N % len == 0){
                if ( arePeaksFor(len, A, sumP)) {
                    return N / len;
                }
            }
        }
        return 0;
    }

    private boolean isPeak(int i, int[] A) {
        if (i == 0 || i == A.length-1){
            return false; }
        else {
            return A[i] > A[i-1] && A[i] > A[i+1]; }
    }

    private boolean arePeaksFor(int len, int[] A, int[] sumP) {
        for(int i = 0; i <= A.length-len; i += len){
            if(sumP[i+len] == sumP[i]){
                return false; }
        }
        return true;
    }
}
