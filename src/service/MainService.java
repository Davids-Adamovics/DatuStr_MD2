import model.Student;

public class MainService {
    public static void main(String[] args) throws Exception {

        //izveido stack priekš veseliem skaitļiem
        MyStack<Integer> myStackSkaitliski = new MyStack<>();

        // Pārbaudam, vai stacks ir tukšs izmantojot 
        boolean atbilde1 = myStackSkaitliski.isEmpty();
        System.out.println("--------------\nVai tukss\n"+atbilde1+"\n-------------");

        // Pārbaudām, vai ir full
        boolean atbilde2 = myStackSkaitliski.isFull();
        System.out.println("Vai pilns\n"+atbilde2+"\n-------------\nPush");

        //Pievienojam 4 elementus
        // Kā tam jāizskatās: [10] [44] [7] [101]
        myStackSkaitliski.push(10);
        myStackSkaitliski.push(44);
        myStackSkaitliski.push(7);
        myStackSkaitliski.push(101);
        // Izvadam rezultātu
        myStackSkaitliski.print();
        System.out.println("----------------\nPop");

        // Noņemam augšējo elementu
        // Kā tam jāizskatās: [10] [44] [7] 
        myStackSkaitliski.pop();
        myStackSkaitliski.print();
        System.out.println("----------------\nPush");

        //Pieliekam klāt vēl divus elementus
        // Kā tam jāizskatās: [10] [44] [7] [76] [49]
        myStackSkaitliski.push(76);
        myStackSkaitliski.push(49);
        myStackSkaitliski.print();
        System.out.println("----------------\nTop");

        //Izvadīsim Top elementu
        // Kā tam jāizskatās: [49]
        MyNodeS topNode = myStackSkaitliski.top();
        System.out.println("Top elements ir: "+topNode);
        System.out.println("----------------\nIsEmpty + Push");

        //iztukšojam un pievienojam vienu
        myStackSkaitliski.emptyList();
        myStackSkaitliski.push(23);
        myStackSkaitliski.print();

        MyStack<Student> myStackStudent = new MyStack<Student>();
		
		Student students1 = new Student("Haralds", "Poters", 232321, (short)1997, (byte)7, (byte)31, "310797-21344", 'm', "hpoters1@gmail.com", 200000001);		
		Student students2 = new Student("Peteris", "Voldemorts", 227733, (short)1998, (byte)12, (byte)31, "311298-38499", 'm', "lordvoldemort@gmail.com", 200000002);		
		Student students3 = new Student("Anna", "Kanna", 298801, (short)1999, (byte)1, (byte)1, "010199-21104", 'f', "klavsongs22@gmail.com", 200000003);		
		
		System.out.println("\n--------------------");
        myStackStudent.push(students1);
        myStackStudent.push(students2);
        myStackStudent.push(students3);
        myStackStudent.print();
    }
}