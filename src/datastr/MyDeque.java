

public class MyDeque<T> {
    
    private MyNodeD frontNode;
    private MyNodeD rearNode;
    private int length = 0;

    // Konstruktors
    public MyDeque() {
        this.frontNode = null;
        this.rearNode = null;
    }

     public boolean isFull() {
        // mainigais
        boolean result = false;
        // OutOfMemoryError parbaude
        try {
            MyNodeD newNode = new MyNodeD<T>((T) new Object());
        } catch (OutOfMemoryError e) {
            result = true;
        }
        return result;
    }

    public boolean isEmpty() {
        return (length == 0);
    }

    public int size() {
        return length;
    }
    
    public void enqueueAtFront(T element) {
        MyNodeD newNode = new MyNodeD(element);
        if (isEmpty()) {
            frontNode = newNode;
            rearNode = newNode;
        } else {
            newNode.setNextD(frontNode);
            frontNode.setPrevious(newNode);
            frontNode = newNode;
        }
        length++;
    }

    public void enqueueAtEnd(T element) {
        MyNodeD newNode = new MyNodeD(element);
        if (isEmpty()) {
            frontNode = newNode;
            rearNode = newNode;
        } else {
            rearNode.setNextD(newNode);
            newNode.setPrevious(rearNode);
            rearNode = newNode;
        }
        length++;
    }
    

    public T dequeueFromFront() throws Exception{
        if (isEmpty()) throw new Exception("Nav ko nonemt, deks ir tukss");

        T removedElement = (T) frontNode.getElement();
        frontNode = frontNode.getNextD();
        length--;

        if (isEmpty()) rearNode = null;
        return removedElement;
    }
    
    public T dequeueFromEnd() throws Exception{
        if (isEmpty()) throw new Exception("Nav ko nonemt, deks ir tukss");
    
        T removedElement = (T) rearNode.getElement();
        rearNode = (MyNodeD) rearNode.getPrevious();
        length--;
    
        if (isEmpty()) frontNode = null;
        return removedElement;
    }
    

    public void print() {
        MyNodeD temp = frontNode; 
        for (int i = 0; i < length; i++) {
            System.out.print("[" + temp.getElement() + "] ");
            temp = temp.getNextD();
        }
        System.out.println();
    }

    public void emptyList() throws Exception {
        frontNode = null;
        rearNode = null;
        length = 0;
        System.gc();
    }


}
