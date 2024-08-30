public class Stack<E> {
    private Node top;
    private int length;

    public Stack(){
        this.length = 0;
        this.top = null;
        
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
        return top == null;
    }
    public void push(E obj){
        Node newnNode = new Node(obj);
        if (isEmpty()) {
            top = newnNode;
        }
        else {
            newnNode.next = top;
            top = newnNode;
        }
        length++;
    }
    public E pop(){
        if (isEmpty()) {
            return null;
        }
        E removed = top.data;
        top = top.next;
        length--;
        return removed;
    }
    public int getLength(){
        return length;
    }
    public E peek(){
        if (isEmpty()) {
            return null;
        }
        return top.data;
    }
    public void display(){
        if (isEmpty()) {
            return;
        }
        Node tmp = top;
        System.out.println("Printing Stack: ");
        while (tmp != null) {
            System.out.print(tmp.data + "\t");
            tmp = tmp.next;
        }
        System.out.println();
    
    
    }   
    public boolean contains(E obj){
        Node tmp = top;
        while (tmp != null) {
            if (tmp.data.equals(obj)) {
                return true;
            }
            tmp = tmp.next;
        }
        return false;
    }

}
