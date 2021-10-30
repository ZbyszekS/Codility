import java.util.ArrayDeque;
import java.util.Deque;

public class Nesting {
    public int solution(String S) {
        if(S.isEmpty()) return 1;
        if(S.length() == 1) return 0;
        
        Deque<Character> stack = new ArrayDeque<>();
        char[] A = S.toCharArray();
        for(char a: A){
            if( a == '(' ){
                stack.push(a);
            } else {
                if( stack.isEmpty() || stack.peek() != '(' ){
                    return 0;
                } else {
                    stack.pop();
                }
            }
        }
        if(!stack.isEmpty()){
            return 0;
        }
        return 1;
    }    
}
