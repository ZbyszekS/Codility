public class Flags {
    public int solution(int[] A) {
        int result = 0;
        int N = A.length;
        if(N < 3)
            return 0;
        boolean[] P = new boolean[N]; // peaks
        int[]     I = new int[N]; // idx of next peak
        for(int i = 1; i < N-1; i++){
            if( A[i] > A[i-1] && A[i] > A[i+1]){
                P[i] = true;}
        }
        for(int i = N-2; i >=0; i--){
            if(P[i]){
                I[i] = i;} 
            else {
                I[i] = I[i+1];}
        }
        if( I[1] == 0){ // no peaks
            return 0;}
        
        boolean foundResult = false;
        int     testFlagNb  = 0;
        int     startIdx    = I[1];
        int     nextIdx     = 0; // info
        int     flagsUsed   = 0; // info
                result      = 0;
        
        while(!foundResult){
            testFlagNb++;
            
            nextIdx   = startIdx; // there is one peak
            flagsUsed = 0;
            do {
                flagsUsed++;
                nextIdx = I[ Math.min(N-1, nextIdx + testFlagNb) ];
            } 
            while (testFlagNb > flagsUsed && nextIdx < N-1 && nextIdx != 0);

            if(flagsUsed > result){
                result = flagsUsed;
            } else {
                foundResult = true;
            }
        }
        return result;
    }
}
