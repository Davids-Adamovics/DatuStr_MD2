public class MainService {
    public static void main(String[] args) throws Exception {
        MyStack<Integer> myStackSkaitliski = new MyStack<>();

        myStackSkaitliski.push(10);
        myStackSkaitliski.push(44);
        myStackSkaitliski.push(7);
        myStackSkaitliski.print();

        myStackSkaitliski.pop();
        myStackSkaitliski.print();

        myStackSkaitliski.push(76);
        myStackSkaitliski.push(49);
        myStackSkaitliski.print();
        MyNodeS topNode = myStackSkaitliski.top();
        System.out.println(topNode);
        myStackSkaitliski.emptyList();
        myStackSkaitliski.print();
        try {
            myStackSkaitliski.pop();
        } catch (Exception e) {
            // TODO: handle exception
        }
        myStackSkaitliski.push(23);
        myStackSkaitliski.print();


    }
}