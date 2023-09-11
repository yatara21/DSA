import java.util.Stack;

public class QueueStackBased<T> {
    private Stack<T> stk1 ; //Encapsulates the stack till no one can access it. (OOP)
    private Stack<T> stk2 ;
    
    public QueueStackBased(){
        stk1 = new Stack<T>();
        stk2 = new Stack<T>();    
    }
    public boolean isEmpty(){
        return stk1.isEmpty() && stk2.isEmpty();
    }
    public int size(){
        return stk1.size() + stk2.size();  // one of the 2 stacks will be empty so we added the two sizes together
    }
    public void enqueue(T t){ //any enqueue operation we deal with stk1
        stk1.push(t);
    }
    public T dequeue(){  //any dequeue operation we pop all elements from stk1 and then deal with stk2.     
        if (isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        if (stk2.isEmpty()){
            while (!stk1.isEmpty()){
                stk2.push(stk1.pop());
            }
        }
        return stk2.pop();
        
    }
    public T peek(){
        if (isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        if (stk2.isEmpty()){
            while (!stk1.isEmpty()){
                stk2.push(stk1.pop());
            }
        }
        return stk2.peek();
    }
    
}
