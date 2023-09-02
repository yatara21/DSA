// queue using simple array.

public class queue<T> {
    private int front;
    private int rear;
    private T[] arr;
    private int size;
    private int capacity;
    public queue(int capacity){  
        size = 0;
        this.capacity = capacity;
        front = -1;
        rear = -1;
        arr = (T[]) new Object[capacity];
    }
    public queue(){}

    public void enqueue(T element){
        if(isFull()){
            throw new IllegalStateException("Queue is full");
        }
        else if (isEmpty()){
            arr[++rear] = element;
            front++;
            size++;
        }
        else{
            arr[++rear] = element;
            size++;
        }
            
    }
    public T dequeue(){
        T tmp;
        if (isEmpty()){
            return null;
        }
        else if (size == 1){   // if queue has only one element
            tmp = arr[front];
            size--;
            front = rear = -1;
        }
        else{                 // if queue has more elements
            tmp = arr[front++];
            size--;
        }
        return tmp;
    }
    public T peek() {
        if (isEmpty()){
            throw new IllegalStateException("Queue is empty");
        }
        else{
            return arr[front];
        }
    }
    public boolean isEmpty() {
        if (front == -1 && rear == -1)
            return true;
        else
            return false;
    }
    public boolean isFull(){
        if ((rear+1) == capacity){
            return true;
        }
        else{
            return false;
        }
    }
    public int size() {
        if (front == -1)
            return 0;
        else
            return rear+1 - front;
    }
    public void display() {
        if(isEmpty()){
            throw new IllegalStateException("Query is empty");
        }
        else{
            for (int i = front; i <=rear; i++){
                System.out.print(arr[i]+" ");
            }
        }   
    }
    public void clear() {
        if (isEmpty()){
            throw new IllegalStateException("Query is empty");
        }    
        else if (front !=-1){
            front = -1;
            rear = -1;
        }
                   
    }   

}