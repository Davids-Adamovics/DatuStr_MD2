public class MyNodeQ<T> extends MyNodeS<T> {

    private MyNodeQ nextQ = null; // next

    // Getter/setter 
    public MyNodeQ getNextQ() {
        return nextQ;
    }

    public void setNextQ(MyNodeQ nextQ) {
        this.nextQ = nextQ;
    }

    // Konstruktors
    public MyNodeQ(T element) {
        super(element);
    }

    public MyNodeQ(T element, MyNodeQ nextQ) {
        super(element);
        this.nextQ = nextQ;
    }
}
