public class DoublyLinkedList<T> { // Doubly linked list and  circular implementation 
    Node head;
    Node tail;
    int size;
    public DoublyLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }
    private class Node{
        T data;
        Node prev;
        Node next;
    public Node (T data) {  
        this.data = data;
        prev = next = null;
    }
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void clear() {
        head = tail = null;
        size = 0;
    }
    public int size() {
        return size;
    }
    public void addFirst(T data) {
        Node newNode = new Node(data);
        if(isEmpty()){
            head = tail = newNode;
            newNode.prev = newNode.next = null;
        }
        else{
            newNode.prev = null;
            newNode.next = head;
            head.prev = newNode;
        //  tail.next = newNode; //this is for circular linked list
            head = newNode;
        }
        size++;
    }
    public void addLast(T data) { 
        Node newNode = new Node(data);
        if(isEmpty()){
            head = tail = newNode;
            newNode.prev = newNode.next = null;
        }
        else{
            newNode.next = null;
            newNode.prev = tail;
            tail.next = newNode;
        //  head.prev = newNode; //this is for circular linked list
            tail = newNode;
        }
        size++;
    }
    public void addAtIndex(T data , int index) {
        Node newNode = new Node(data);
        if (index == 0){
            addFirst(data);
            return;
        }
        else if (index == size){
            addLast(data);
            return;
        }
        else if (index < 0 || index > size){  
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        else{
            Node curr = head; 
            for (int i=1;i<index;i++){
                curr =curr.next;

            }
            newNode.prev = curr;     // we must link new node first and then see current node to avoid infinite loop.
            newNode.next = curr.next;
            curr.next.prev = newNode;
            curr.next = newNode;
        }
        size++;
    }
    public void removeFirst(){
        if (isEmpty()){
            throw new IllegalStateException("Empty List");
        }
        if (size == 1){
            head = tail = null;
        }
        else {
            head = head.next;
            head.prev = null;
        //  head.prev = tail;  //this is for circular linked list
        //  tail.next = head
        }
        size--;
    }
    public void removeLast(){
        if (isEmpty()){
            throw new IllegalStateException("Empty List");
        }
        if (size == 1){
            head = tail = null;
        }
        else{
            tail = tail.prev;
            tail.next = null;
        //  head.prev = tail;  //this is for circular linked list
        //  tail.next = head;
        }
        size--; 
    }
    public void removeAtIndex(int index){
        if (index ==0){
            removeFirst();
            return;
        }
        else if (index == size){
            removeLast();
            return;
        }
        else if (index < 0 || index > size){  
            throw new IndexOutOfBoundsException("Index out of range...");
        }
        else{
            Node tmp = head;
            for (int i = 0; i < index; i++){ //tmp located at removed node 
                tmp = tmp.next;
            }
            tmp.prev.next = tmp.next;
            tmp.next.prev = tmp.prev;
        }
        size--;
    }
    public void display() {
        Node curr = head;
        while (curr != null){
            System.out.print(curr.data +" ");
            curr = curr.next;
        }
    }
    public void reverseDisplay(){
        Node curr = tail;
        while (curr != null){
            System.out.print(curr.data +" ");
            curr = curr.prev;
        }
    }
    /* // for circular linked list
    public void display() {
        Node curr = head;
        do {
            System.out.print(curr.data +" ");
            curr = curr.next;
        } while (curr != head);
    }
    public void reverseDisplay(){
        Node curr = tail;
        do {
            System.out.print(curr.data +" ");
            curr = curr.prev;
        } while (curr != tail);
    }
     */
}
