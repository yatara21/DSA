import java.util.LinkedList;   // i have used  LinkedList pre defined in java becasue i have implemented this class before

public class QueueLinkedListBased<T> {
   LinkedList<T> list = new LinkedList<T>();

    public void enqueue(T item) {
        list.addLast(item);
    }
    public T dequeue() {
        if (list.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.removeFirst();
    }
    public boolean isEmpty() {
        return list.isEmpty();
    }
    public int size() {
        return list.size();
    }
    public T peek(){
        if (list.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.getFirst();
    }

}
