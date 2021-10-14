package L01_iterations;

import static java.lang.Math.max;

public class BinaryGap {
    public int solution(int N) {
        String s  = Integer.toString(N, 2);
        char[] ar = s.toCharArray();
        boolean countingStarted = false;
        int tCount = 0;
        int mCount = 0;
        
        for(char c : ar){
            if( c == '1' ){
                if( !countingStarted ){
                    countingStarted = true;
                } else {
                    mCount = max(mCount, tCount);
                    tCount = 0;
                }
            } else {
                if( countingStarted ){
                    tCount++;
                }
            }
        }
        return mCount;
    }

}
