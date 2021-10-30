import static java.lang.Integer.max;
import java.util.Arrays;

public class Dominator {
    
    public int solution(int[] A) {
        int N = A.length;
        if(N == 0) return -1;
        if(N == 1) return 0;
        
        int[] OA = A.clone();
        Arrays.sort(A);
        int countV = 0;
        int lastV = A[0];
        int maxiC = 0;
        
        for(int i = 0; i < N; i++){
            if(A[i] == lastV){
                countV++;
                maxiC = max(maxiC, countV);
                if(maxiC > N/2){
                    return indexOfValue(lastV, OA);
                }
            } else {
                lastV = A[i];
                countV = 1;
            }
        }
        return -1;
    }
    private int indexOfValue(int v, int[] OA) {
        for(int i = 0; i < OA.length; i++){
            if(OA[i] == v){
                return i;
            }
        }
        return 0;
    }    
 
}
