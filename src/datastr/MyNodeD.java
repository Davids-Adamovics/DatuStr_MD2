public class MyNodeD<T> extends MyNodeS<T> {

    private MyNodeD nextD = null; // next

    // Getter/setter 
    public MyNodeD getNextD() {
        return nextD;
    }

    public void setNextD(MyNodeD nextD) {
        this.nextD = nextD;
    }

    // Konstruktors
    public MyNodeD(T element) {
        super(element);
    }

    public MyNodeD(T element, MyNodeD nextD) {
        super(element);
        this.nextD = nextD;
    }
}
