public class LinkedList<T> { // Singly linked list implementation
    private Node head;
    private Node tail;
    private int size;
    public LinkedList(){
        head = null;
        tail = null;
        size = 0; 
    }
    private class Node {      
        public T data;
        public Node next;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
    public int size() {
        return size;
    }
    public T getHead() {
        if (isEmpty()){
            throw new IllegalStateException("List is empty");
        }
        return head.data;
    }
    public T getTail() {
        if (isEmpty()){
            throw new IllegalStateException("List is empty");
        }
        return tail.data;
    }

    public void addFirst(T data) {   //O(1)
        Node newNode = new Node();
        if (isEmpty()) {
            newNode.data = data;
            newNode.next = null;
            head = newNode;
            tail = newNode;
        }
        else{
            newNode.data = data;
            newNode.next = head;
            head = newNode;
        }
        size++;
    }
    public void addLast(T data) {   //O(1)
        Node newNode = new Node();
        if (isEmpty()) {
            newNode.data = data;
            newNode.next = null;
            head = newNode;
            tail = newNode;    
        }
        else{
            newNode.data = data;
            tail.next = newNode;
            tail = newNode;
            newNode.next = null;
        }   
        size++;
    }
    public void removeFirst(){
        if (isEmpty()){
            throw new IllegalStateException("List is Empty");
        }
        else if (size == 1){
            head = tail = null;
            size--;
        }
        else{
            head = head.next;
            size--;
        }
    }
    public void removeLast(){
        if (isEmpty()){
            throw new IllegalStateException("List is Empty");
        }
        else if (size == 1){
            head = tail = null;
        }
        else{
            Node curr = head;
            for (int i=0;i<size-2;i++){
                curr = curr.next;
            }
            tail = curr;
            tail.next = null;
        }
        size--;
    }
    public void addAtIndex(T data,int index) {
        Node newNode = new Node();
        if (index == 0){
            addFirst(data);
            return;
        }
        else if (index == size){
            addLast(data);
            return;
        }
        else if (index < 0 || index > size){
            throw new IndexOutOfBoundsException(" Index out of range...");
        }
        else{
            Node curr = head;
            for (int i = 0; i < index-1 ;i++){ // we iterate until curr equals before node we need to adjust
                curr = curr.next;
            }
            newNode.data = data;
            newNode.next = curr.next;
            curr.next = newNode;
            size++;
        }
    }
    public void remove(T data){
        if (isEmpty()){
            throw new IllegalStateException(" List is Empty");
        }
        else if (head.data.equals(data)){
            removeFirst();

            
        }
        else if (tail.data.equals(data)){
            removeLast();
        }
        else {
            Node curr = head.next;
            Node prev = head;
            while(curr != null){
                if (curr.data == data){
                    break;
                }
                prev = curr;
                curr = curr.next;
            }
            if (curr == null){
                throw new IllegalStateException("Not found");
            }
            else {
                prev.next = curr.next;
                size--;
            }
        }
    }
    public void display(){   //o(n)
        Node Node = head;
        while(Node != null){
            System.out.print(Node.data+" ");
            Node = Node.next;
        }
        System.out.println();
    }
    public int searchIndex(T data){
        Node curr =head;
        int index =0;
        while(curr != null){
            if (curr.data.equals(data)){
                return index;
            }
            curr = curr.next;
            index++;
        }
        return -1;
    }
    public boolean contains(T data){
        return searchIndex(data) >= 0;
    }
    public void reverse(){ // 3 pointers
        Node prev,curr,next;
        prev =null;
        curr =head;
        next =curr.next;
        while(curr != null){
            next =curr.next;
            curr.next =prev;
            prev = curr;
            curr =next;
        }
        head = prev; 
    }
}
