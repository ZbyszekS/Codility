/* Stack is old class in java, so use Deque. But Deque has more than push & pop, so you have ADDITIONAL duty to avoid using "add" by mistake for example
 */
import java.util.ArrayDeque;
import java.util.Deque;

public class Fish {
    public int solution(int[] A, int[] B) {
        int nbAlife     = 0;
        int DOWN_STREAM = 1;
        int UP_STREAM   = 0; // just as unused description
        Deque<Integer> packDownStream = new ArrayDeque<>();
        
        for(int i = 0; i < A.length; i++){
            int direction = B[i];
            int size      = A[i];
            
            if(direction == DOWN_STREAM){
                packDownStream.push(size);
            } else {
                if( packDownStream.isEmpty() ){
                    nbAlife++;
                } else {
                    while ( !packDownStream.isEmpty() && packDownStream.peek() < size ){
                        packDownStream.pop();
                    }
                    if ( packDownStream.isEmpty() ){
                        nbAlife++;
                    }
                }
            }
        }
        nbAlife += packDownStream.size();
        return nbAlife;
    }    
    
