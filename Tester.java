public class Tester {
    public static void main(String[] args) {
       /* System.out.println("Hello world!");
        LinkedList<Integer> l = new LinkedList<>();
        l.addFirst(40);
        l.addLast(50);
        l.addLast(60);
        l.addLast(70);
        l.addLast(80);
        Integer m = l.remove(60);
        System.out.println(m + " has been removed successfully.");
        l.display();
        System.out.println("the length of the List is: " + l.getLength());
        System.out.println(l.contains(60));*/
        // LinkedList<Integer> list = new LinkedList<>();
        // LinkedList<String> l = new LinkedList<>();
        // int n = 10;
        // for (int i=0; i < n; i++){
        //     list.addFirst(i);
        // }
        // System.out.println(list.getLength());
        // list.display();

        // for (int i=0; i < n; i++){
        //     list.removeLast();
        // }
        // System.out.println(list.getLength());
        // list.display();
        // Queue<Integer> q = new Queue<>();
        // q.enqueue(1);
        // System.out.println(q.dequeue());
        // q.display();
        // System.out.println(q.getLength());
        // System.out.println(q.isEmpty());
        // q.enqueue(99);
        // q.display();
        // System.out.println(q.getLength());
        Stack<Integer> stack = new Stack<>();

        // Test isEmpty on an empty stack
        System.out.println("Is the stack empty? " + stack.isEmpty());  // true

        // Test push operation
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Display stack
        stack.display();  // Should print 30, 20, 10

        // Test peek operation
        System.out.println("Peek at the top element: " + stack.peek());  // 30

        // Test pop operation
        System.out.println("Pop from stack: " + stack.pop());  // 30

        // Display stack after pop
        stack.display();  // Should print 20, 10

        // Test getLength operation
        System.out.println("Current stack length: " + stack.getLength());  // 2

        // Test contains operation
        System.out.println("Does the stack contain 10? " + stack.contains(10));  // true
        System.out.println("Does the stack contain 50? " + stack.contains(50));  // false

        // Test pop until empty
        System.out.println(stack.pop());  // 20
        System.out.println(stack.pop());  // 10
        System.out.println("Is the stack empty now? " + stack.isEmpty());  // true

        // Try to pop from an empty stack
        System.out.println("Pop from empty stack: " + stack.pop());  // null
    }
}