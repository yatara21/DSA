public class Array {
    private int size;
    private int length;
    private int[] array;
    public Array(int size){
        this.size = size;
        this.length = 0;
        this.array = new int[size];
    }
    public int getSize(){
        return size;
    }
    public int getLength(){
        return length;
    }
    public boolean isEmpty(){
        return length == 0;
    }
    public boolean isFull(){
        return length == size;
    }
    public void add(int value){
        if (isFull()) {
            System.out.println("Array is full.");
        }
        else {
            array[length] = value;
            length++;
        }
    }
    public void display(){
        if (isEmpty()) {
            System.out.println("Array is empty.");
            return;
        }
        else {
            System.out.println("Displaying array: ");
            for (int i = 0; i < length; i++){
                System.out.print(array[i] + "\t");
            }
            System.out.println();
        }
    }
    public boolean contains(int value){
        boolean flag = false;
        if (isEmpty()) {
            return flag;
        }
        for (int i=0; i < array.length; i++) {
            if (array[i] == value) {
                flag = true;
            }
        }
        return flag;
    }
    public void removeByValue(int value){
        if(isEmpty()){
            System.out.println("Array is Empty.");
            return;
        }
        if (contains(value)) {
            for (int i=0; i < array.length; i++){
                if (array[i] == value) {
                    for(int j = i; j < array.length-1; j++){
                        array[j] = array[j+1];
                    }
                    array[length - 1] = 0;
                    System.out.println(value + " has been removed successfully.");
                    length--;
                    return;
                }
            }
        }
        else {
            System.err.println(value + " is not in the Array.");
        }
    }
    public void removeByIndex(int index){
        if (isEmpty()) {
            System.out.println("Array is Empty.");
            return;
        }

        if (index >= 0 && index < length) {
            for(int i=index; i < array.length-1; i++) {
                array[i] = array[i+1];
            }
            array[length - 1] = 0;   
            System.out.println("Item at " + index + " removed successfully.");
            length--;
            return;    
        }
        else {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
    }
    public void insertAt(int index, int value) {
        if (isFull()) {
            System.out.println("Array is Full.");
            return;
        }
    
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
    
        for (int i = length; i > index; i--) {
            array[i] = array[i - 1];
        }
    
        array[index] = value;
        length++;
        System.out.println(value + " added successfully at index " + index);
    }
    public int getAt(int index){
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        
        return array[index];
    }

}
