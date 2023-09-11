import java.util.ArrayList;
public class QueueArrayList<T> {   // queue using arraylist
    private ArrayList<T> list;
    public QueueArrayList(){
        list = new ArrayList<T>();
    }
    public boolean isEmpty(){
        return list.isEmpty();
    }
    public int size(){
        return list.size();
    }
    public void enqueue(T element){
        list.add(element);
    }
    public T dequeue(){
        return list.remove(0);
    }
    public T peek(){
        return list.get(0);
    }
    public void display(){
        if (list.isEmpty()){
            throw new RuntimeException("Queue is empty");    
        }
        else{
            for(T element : list){
                System.out.print(element+" ");
            }
            System.out.println();
        }   
    }
}
