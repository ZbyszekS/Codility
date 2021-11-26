// used recurency 
// https://app.codility.com/demo/results/trainingRMYJPS-X6X/
import static java.lang.Integer.min;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class FibFrogSimple implements IntFibFrog{
    
    int minJumps = Integer.MAX_VALUE;    
            
    public int solution(int[] A) {
        int[] visited;
        minJumps = Integer.MAX_VALUE;

        int N = A.length;
        int M = N+2;
        visited = new int[M];
        List<Integer> fj = getFibJmps(M-1);
        
        jump(0, 0, A, N, visited, M, fj);
        
        if(minJumps == Integer.MAX_VALUE)
            return -1;
        else
            return minJumps;
    }
    
    private List<Integer> getFibJmps(int N) {
        int f1 = 1;
        int f2 = 2;
        int s = f1 + f2;
        List<Integer> fb = new ArrayList<>();
        fb.add(1);
        fb.add(2);
        while (s <= N) {
            fb.add(s);
            f1 = f2;
            f2 = s;
            s = f1 + f2;
        }
        return fb;
    }

    private void jump(int le, int sp, int[] A, int N, int[] visited, int M, List<Integer> fj) {
        visited[sp] = le;
        Deque<Integer> possJumpsTo = getPossJumpsFrom(le, sp, A, N, visited, M, fj);
        
        if(!possJumpsTo.isEmpty()){
            for(Integer pos : possJumpsTo){
                if(pos == M-1 && le+1 < minJumps){
                    visited[pos] = le+1;
                    minJumps = le+1;
                }
                else if( le + 2 < minJumps)
                    jump(le+1, pos, A, N, visited, M, fj);
                else
                    visited[pos] = min(visited[pos], le+1);
            }
        }
    }

    private Deque<Integer> getPossJumpsFrom(int le, int sp, int[] A, int N, int[] visited, int M, List<Integer> fj) {
        Deque<Integer> o = new ArrayDeque<>();
        for(Integer j : fj){
            int pos = sp + j;
            if(pos < M-1){
                if(  pos == M-1 || ( A[pos-1] == 1 && ( visited[pos] == 0 || visited[pos] > le+1 ) ) ){
                    o.push(pos);
                }
            } else if(pos == M-1) {
                o.push(pos);
            } else
                break;
        }
        return o;
    }

}
