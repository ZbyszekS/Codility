import static java.lang.Integer.max;
import java.util.Arrays;

public class EquiLeader {
    public int solution(int[] A) {
        int N = A.length;
        if(N == 1)
            return 0;
        Integer leader = leader(A);
        if(leader == null)
            return 0;
        
        int M = N+1;
        int[] SL = new int[M];
        for(int i = 0; i < N; i++){
            SL[i+1] = SL[i] + ( (A[i] == leader) ? 1 : 0 );
        }
        int o = 0;
        for(int i = 1; i < M-1; i++){ // equiLeader cant have last pos
            if( (SL[i] > i/2) && (SL[M-1] - SL[i]) > (M-1 - i)/2 ){
                o++;
            }
        }
        return o;
    }    

    private Integer leader(int[] A) {
       int[] B = A.clone();
       Arrays.sort(B);
       
       int half   = B.length/2;
       int maxV   = 0;
       int countV = 0;
       int lastV  = B[0];
       for(int b: B){
           if(b == lastV){
               countV++;
               if(countV > half)
                   return lastV;
           } else {
               lastV = b;
               countV = 1;
           }
       }
       return null;
    }

}
