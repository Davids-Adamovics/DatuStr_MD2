public class MyNodeS <T>{

    //mainīgie elementi
    private T element;
    private MyNodeS next = null; // saite uz nākamo bloku
	private MyNodeS previous = null; // saite uz iepriekšējo bloku


    //getter un setters
    public T getElement() {
        return element;
    }
    public void setElement(T element) {
        this.element = element;
    }

    public MyNodeS getNext() {
        return next;
    }
    public void setNext(MyNodeS next) {
        this.next = next;
    }

    public MyNodeS getPrevious() {
        return previous;
    }
    public void setPrevious(MyNodeS previous) {
        this.previous = previous;
    }


    //konstruktors
    public MyNodeS(T element){
        setElement(element);
    }
    
    public MyNodeS() {
    }
    //toString funkcija
    public String toString() {
		return "" + element;
	}
}