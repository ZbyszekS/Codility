import java.util.ArrayDeque;
import java.util.Deque;

public class StoneWall {
    public int solution(int[] H) {
        Deque<Integer> stack = new ArrayDeque<>();
        int count = 0;
        
        for(int h: H) {
            while (!stack.isEmpty() && stack.peek() > h) {
                stack.pop();
            }
            if(stack.isEmpty() || stack.peek() < h){
                stack.push(h);
                count++;
            }
        }
        return count;
    }
}
