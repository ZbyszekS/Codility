public class ChocolatesByNumbers {
  
    public int solution(int N, int M) {
        return N/gcd(N,M);
    }
    
    int gcd(int a, int b){
        if(a%b == 0) 
            return b;
        else 
            return gcd(b, a%b);
    }
    
}
