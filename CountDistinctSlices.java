package codility.lessons.catepillar_method;

import java.util.Arrays;

public class CountDistinctSlices {
  
    public int solution(int M, int[] A) {
      int r = 0;
      final int MAX_VALUE = 1000000000;
      final int N         = A.length;
      int[] posVisited    = new int[M+1];
      int start_pos       = 0;
      int current_pos     = 0;
      
      Arrays.fill(posVisited, -1);
      while(current_pos < N){
        int current_val                = A[current_pos];
        int current_val_prev_occurence = posVisited[current_val];
        
        if(current_val_prev_occurence < start_pos){ // just go forward
          posVisited[current_val] = current_pos;
          current_pos++;
        } else {
          r        += sumVal(current_pos - start_pos);
          if(r > MAX_VALUE) return MAX_VALUE;
          start_pos = current_val_prev_occurence+1;
          r        -= sumVal(current_pos - start_pos);
        }
      }
      r += sumVal(N - start_pos);
      if(r > MAX_VALUE) return MAX_VALUE;
      return r;
    }
    
    int sumVal(int v){
      int r = 0;
      double vd = (double)v;
      double d = (vd+1)/2*vd;
      r = (int) d;
      return r;
    }
}
