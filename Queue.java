public class Queue<E> {
    
    private Node front;
    private Node rear;
    private int length;
    
    public Queue(){
        this.front = null;
        this.rear = null;
        this.length = 0;
    }
    private class Node {
        E data;
        Node next;
        
    public Node(E obj){
        this.data = obj;
        this.next = null;
    }
    }

    public boolean isEmpty(){
        return front == null;
    }
    
    public void enqueue(E obj){
        Node newNode = new Node(obj);
        if (isEmpty()) {
            front = rear = newNode;
            length++;
            return;
        }
        rear.next = newNode;
        rear = newNode;
        length++;
    }
    public E dequeue(){
        if (isEmpty()){
            return null;
        }
        E removed = front.data;
        if (front == rear){
            front = rear = null;
            length--;
        }
        else {
            front = front.next;
            length--; 
        }
        return removed;
    }
    public E getFront(){
        if (isEmpty()){
            return null;
        }
        return front.data;
    }
    public E getRear(){
        if (isEmpty()) {
            return null;
        }
        return rear.data;
    }
    public int getLength() {
        return length;
    }
    public boolean contains(E obj){
        Node tmp = front;
        while (tmp != null) {
            if (tmp.data.equals(obj)) {
                return true;
            }
            tmp = tmp.next;
        }
        return false;
    }
    public void clear(){
        front = rear = null;
        length = 0;
    }
    public void display(){
        if (isEmpty()){
            return;
        }
        Node tmp = front;
        System.out.println("Printing Queue: ");
        while (tmp != null) {
            System.out.print(tmp.data + "\t");
            tmp = tmp.next;
        }
        System.out.println();
    }





}
