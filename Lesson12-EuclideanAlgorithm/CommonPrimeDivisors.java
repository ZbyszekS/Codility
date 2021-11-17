public class CommonPrimeDivisors {
  
    public int solution(int[] A, int[] B) {
        int N = A.length;
        int o = 0;
        for(int i = 0; i < N; i++){
            if(hasTheSameDivs(A[i], B[i])){
                o++;
            }
        }
        return o;
    }

    private boolean hasTheSameDivs(int a, int b) {
        int gcd = gcd(a, b);
        
        if ( !goingToOne(a, gcd) || !goingToOne(b, gcd) ) 
            return false;
         else 
            return true;
    }

    private int gcd(int a, int b) {
        if(a % b == 0)
            return b;
        else
            return gcd(b, a % b);
    }

    private boolean goingToOne(int a, int gcd) {
        while( gcd != 1 ){
            a = a/gcd;
            gcd = gcd(a, gcd);
        }
        return a == 1;
    }
    

}
