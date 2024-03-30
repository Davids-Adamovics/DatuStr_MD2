public class MyStack<T> {

    private MyNodeS topNode;
    private MyNodeS first;
    private MyNodeS last;
    private int length = 0;

    // konstruktors
    public MyStack(MyNodeS topNode) {
        this.topNode = topNode;
    }

    public MyStack() {
    }

    public boolean isFull() {
        // mainigais
        boolean result = false;
        // OutOfMemoryError parbaude
        try {
            MyNodeS newNode = new MyNodeS<T>((T) new Object());
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

    public void push(T element) throws Exception {
        if (isFull())
            throw new Exception("Nevar, nav ko iznemt");
        else {
            // ja nav neviens elements
            if (isEmpty()) {
                MyNodeS newNode = new MyNodeS(element);
                first = newNode;
                last = newNode;
                // ja ir jau vismaz viens elements
            } else {
                MyNodeS newNode = new MyNodeS(element);
                last.setNext(newNode);
                newNode.setPrevious(last);
                last = newNode;
            }
            length++;
        }

    }

    public void pop() throws Exception {
        if (isEmpty())
            throw new Exception("Nevar, nav ko iznemt");

        if (length == 1) {
            first = null;
            last = null;
            System.gc();
            length--;
        } else {
            MyNodeS removedNode = last;
            MyNodeS newLastNode = removedNode.getPrevious();
            newLastNode.setNext(null);
            last = newLastNode;
            System.gc();
            length--;
        }
    }

    public MyNodeS top() throws Exception{

        if (isEmpty()) throw new Exception("Nav ko atgriezt, tukšs");
        else{
            MyNodeS TopNode = last;
            return TopNode;
        }
    }

    public void print() {
		MyNodeS temp = first;
		for (int i = 0; i < length; i++) {
			System.out.print("["+temp.getElement()+"] ");
			temp = temp.getNext();
		}
		System.out.println();
	}

    public void emptyList() throws Exception {
		first = null;
		last = null;
		length = 0;
		System.gc();
	}
}
