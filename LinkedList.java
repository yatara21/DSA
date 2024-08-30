/*
 * there are five boundary conditions you need to check in every method.
 * ------------------------------------------------------------------------
 * 1- Empty data structure.
 * 2- Single element in the data structure.
 * 3- Adding/removing at beginning of data structure.
 * 4- Adding/removing at end of data structure.
 * 5- Working in the middle.
 */
public class LinkedList<E> {
    private Node head;
    private Node tail;
    private int length;

    // Node class representing each element in the linked list
    private class Node {
        E data;
        Node next;

        public Node(E obj) {
            this.data = obj;
            this.next = null;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Node node = (Node) o;
            return data.equals(node.data);
        }

        @Override
        public int hashCode() {
            return data.hashCode();
        }
    }

    // Constructor: Initializes an empty LinkedList
    public LinkedList() {
        head = null;
        tail = null;
        length = 0;
    }

    // isEmpty: Checks if the list is empty
    // Time Complexity: O(1)
    public boolean isEmpty() {
        return head == null;
    }

    // getLength: Returns the length of the list
    // Time Complexity: O(1)
    public int getLength() {
        return length;
    }

    // addFirst: Adds a new element at the beginning of the list
    // Time Complexity: O(1)
    public void addFirst(E obj) {
        Node newNode = new Node(obj);
        if (isEmpty()) {
            head = tail = newNode;
            length++;
            return;
        }
        newNode.next = head;
        head = newNode;
        length++;
    }

    // addLast: Adds a new element at the end of the list
    // Time Complexity: O(1)
    public void addLast(E obj) {
        Node newNode = new Node(obj);
        if (isEmpty()) {
            addFirst(obj);
            return;
        }
        tail.next = newNode;
        tail = newNode;
        length++;
    }

    // removeFirst: Removes the first element in the list
    // Time Complexity: O(1)
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        E tmp = head.data;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
        }
        length--;
        return tmp;
    }

    // removeLast: Removes the last element in the list
    // Time Complexity: O(n) because we must traverse to find the node before the
    // tail
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }
        if (head == tail) {
            return removeFirst();
        }
        Node tmp = head;
        while (tmp.next != tail) {
            tmp = tmp.next;
        }
        E removed = tail.data;
        tmp.next = null;
        tail = tmp;
        length--;
        return removed;
    }

    // remove: Removes the first occurrence of the specified element in the list
    // Time Complexity: O(n) because we must potentially traverse the entire list to
    // find the element
    public E remove(E obj) {
        Node current = head, previous = null;
        while (current != null) {
            if (current.data.equals(obj)) {
                if (current == head) {
                    return removeFirst();
                }
                if (current == tail) {
                    return removeLast();
                }
                length--;
                previous.next = current.next;
                return current.data;
            }
            previous = current;
            current = current.next;
        }
        return null;
    }

    // peekFirst: Returns the first element in the list without removing it
    // Time Complexity: O(1)
    public E peekFirst() {
        if (isEmpty()) {
            return null;
        }
        return head.data;
    }

    // peekLast: Returns the last element in the list without removing it
    // Time Complexity: O(1)
    public E peekLast() {
        if (isEmpty()) {
            return null;
        }
        return tail.data;
    }

    // contains: Checks if the list contains the specified element
    // Time Complexity: O(n) because we might need to traverse the entire list to
    // find the element
    public boolean contains(E obj) {
        boolean flag = false;
        Node tmp = head;
        while (tmp != null) {
            if (tmp.data.equals(obj)) {
                flag = true;
                break;
            }
            tmp = tmp.next;
        }
        return flag;
    }

    // display: Prints all elements in the list
    // Time Complexity: O(n) because we must traverse the entire list to display all
    // elements
    public void display() {
        Node tmp = head;
        if (isEmpty()) {
            return;
        }
        System.out.println("Printing the LinkedList:");
        while (tmp != null) {
            System.out.print(tmp.data + "\t");
            tmp = tmp.next;
        }
        System.out.println();
    }
}
