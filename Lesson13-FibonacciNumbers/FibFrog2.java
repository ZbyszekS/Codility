// https://app.codility.com/demo/results/trainingCZU6CY-AUW/
import static java.lang.Math.min;
import java.util.ArrayList;
import java.util.List;

public class FibFrog_ByA {
    
    public int solution(int[] A) {
        int       N       = A.length;
        int       M       = N+2;
        int[]     visited = new int[M]; 
        Integer[] fibJmps = getFibJmps(M-1);
        
        for(int sp = 0; sp < M; sp++){
            if (sp == 0 || visited[sp] > 0) {
                for (int i = 0; i < fibJmps.length; i++) {
                    int jT = sp + fibJmps[i];
                    if (jT < M) {
                        if (jT == M-1 || A[jT - 1] == 1) {
                            if(visited[jT] == 0){
                                visited[jT] = visited[sp] + 1;
                            } else {
                                visited[jT] = min(visited[jT], visited[sp] + 1);
                            }
                        }
                    }
                }
            }
        }
        if(visited[N+1] == 0)
            return -1;
        else
            return visited[N+1];
    }    

    private Integer[] getFibJmps(int N) {
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
        return fb.toArray(new Integer[fb.size()]);
    }

}
