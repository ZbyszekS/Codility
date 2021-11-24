// interesting task but little strange behaviour
// trying to use int[] instead of Itneger[] for fibJmps and converting it from list by stream class, causes two time outs
//
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class FibFrog_NoVisited {

    public int solution(int[] A) {
        int            N        = A.length;
        Integer[]      fibJmps  = getFibJmps(N+1);
        Deque<Integer> curLevel = new ArrayDeque<>();
        Deque<Integer> nexLevel = new ArrayDeque<>();
        int            curJumps = 0;
        
        curLevel.push(-1);
        while( !curLevel.isEmpty() ){
            for( int sp : curLevel ){
                if( checkForMinJmpAndAddNextLevel(sp, A, N, nexLevel, fibJmps) ){
                    return curJumps+1;
                }
            }
            curJumps++;
            curLevel.clear();
            curLevel.addAll(nexLevel);
            nexLevel.clear();
        }
        return -1;
    }
    
    private Integer[] getFibJmps(int N) {
        int f1 = 1;
        int f2 = 2;
        int s =  f1+f2; 
        List<Integer> fb = new ArrayList<>();
        fb.add(1); 
        fb.add(2);
        while(s <= N){
            fb.add(s);
            f1 = f2;
            f2 = s;
            s = f1+f2;
        }
        return fb.toArray(new Integer[fb.size()]);
    }

    private boolean checkForMinJmpAndAddNextLevel(int sp, int[] A, int N, Deque<Integer> nexLevel, Integer[] fibJmps) {
        int i, pos;
        boolean minFound = false;

        
        for( i = 0; i < fibJmps.length  &&  (pos = sp + fibJmps[i]) <= N  &&  !minFound; i++){
            if (pos == N) {
                minFound = true;
            } 
            else {
                if (A[pos] == 1) {
                    nexLevel.push(pos);
                    A[pos] = 0;
                }
            }
        }
        return minFound;
    }

}
