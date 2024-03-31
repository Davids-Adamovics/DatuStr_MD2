public class MyQueue<T> {

    private MyNodeQ frontNode;
    private MyNodeQ rearNode;
    private int length = 0;

    // Constructors
    public MyQueue() {
        this.frontNode = null;
        this.rearNode = null;
    }

    public boolean isFull() {
        // Since there's no fixed size for the queue, it cannot be full in this
        // implementation
        return false;
    }

    public boolean isEmpty() {
        return (length == 0);
    }

    public int size() {
        return length;
    }

    public void enqueue(T element) {
        MyNodeQ newNode = new MyNodeQ(element);
        if (isEmpty()) {
            frontNode = newNode;
            rearNode = newNode;
        } else {
            rearNode.setNextQ(newNode);
            rearNode = newNode;
        }
        length++;
    }

    public T dequeue() throws Exception {
        if (isEmpty())
            throw new Exception("Nav ko nonemt, rinda ir tuksa");

        T removedElement = (T) frontNode.getElement();
        frontNode = frontNode.getNextQ();
        length--;

        if (isEmpty())
            rearNode = null;
        return removedElement;
    }

    public void print() {
        MyNodeQ temp = frontNode; // pirmais iekšā pirmais ārā
        for (int i = 0; i < length; i++) {
            System.out.print("[" + temp.getElement() + "] ");
            temp = temp.getNextQ();
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
