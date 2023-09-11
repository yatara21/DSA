public class CircularQueue<T> {
    private final int capacity; // queue using circular queue
    private int size;
    private int rear;
    private int front;
    private final T[] arr;
    public CircularQueue(int capacity){
        this.capacity = capacity;
        front =0;
        rear = capacity-1;
        arr = (T[]) new Object[capacity];
        size =0;
    }    
    public boolean isEmpty() {
        return size==0;
        
    }
    public boolean isFull() {
        return size==capacity; //array is full size 0 base index
        
    }
    public int size(){
            return size;
    }
    public void enqueue(T value){
        if(isFull()){
            throw new RuntimeException("Queue is full");
        }
        else{
            rear=(rear+1) % capacity; // circular queue implementation
            arr[rear]=value;
            size++;
        }
    
    }
    public T dequeue(){
        if(isEmpty()){
            throw new RuntimeException("Queue is Empty");
        }
        else{
            T removed=arr[front];
            front=(front+1) % capacity; // circular queue implementation
            size--;  
            return removed;
        }
        
    }
    public T peek(){
        if(isEmpty()){
            throw new RuntimeException("Queue is Empty");
        }
        else{
            return arr[front];
        }
        
    }
    public void display() {
        if (isEmpty()){ 
            throw new RuntimeException("Queue is Empty");
        }
        else{
            for(int i=front;i!=rear;i=(i+1)%capacity){
                System.out.print(arr[i]+" ");
            }
            System.out.print(arr[rear]);
        }
        
    }
    public void clear() {
        front = 0;
        rear = capacity - 1;
        size = 0;
    }
} 