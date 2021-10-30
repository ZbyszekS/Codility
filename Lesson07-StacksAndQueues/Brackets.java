import java.util.ArrayDeque;
import java.util.Deque;

public class Brackets {
    public int solution(String S) {
        if( S.isEmpty() )     return 1;
        if( S.length() == 1 ) return 0;
            
        char[]           A = S.toCharArray();
        Deque<Character> D = new ArrayDeque<>();
        
        for(char a : A){
            if( isOpening(a) ){
                D.push(a);
            }
            else {
                if( D.isEmpty() ) return 0;
                if( !matchCloseChar( D.peek(), a) ) return 0;
                D.pop();
            }
        }
        
        if( D.size() > 0) return 0;
        
        return 1;
    }

    private boolean isOpening(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    private boolean matchCloseChar(Character peek, char c) {
        if(peek == null)
            return false;
        
        if( peek == '(' && c == ')' ||
            peek == '[' && c == ']' ||
            peek == '{' && c == '}'    )
        {
            return true;
        }
        else {
            return false;
        }
    }
     
}
