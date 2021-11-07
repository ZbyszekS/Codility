public class CountFactors {
    public int solution(int N) {
        int o = 0;
        int maxDivisor = (int) Math.sqrt(N);
        
        for(int i = 1; i <= maxDivisor; i++){
            if ( (N % i) == 0 ){
                o +=2;
                if( i == maxDivisor && maxDivisor * maxDivisor == N){
                    o--;
                }
            }
        }
        return o;
    }
}
