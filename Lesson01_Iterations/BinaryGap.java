package L01_iterations;

public class BinaryGap {
     public int solution(int N) {
         int     o = 0;
         String  s  = Integer.toBinaryString(N);
         char[]  ca = s.toCharArray();
         int     cu = 0;
         boolean wasStarted = false;
         
         
         
         for(char c: ca){
             if(c == '1'){
                 if(wasStarted){
                     if(cu > o){
                         o = cu;
                     }
                     cu = 0;
                 } else {
                     wasStarted = true;
                 }
             }
             else {
                 if(wasStarted){
                     cu++;
                 }
             }
         }
         
         return o;
    }

}
