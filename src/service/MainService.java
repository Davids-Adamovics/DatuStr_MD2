import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.Flow.Subscriber;

import javax.print.DocFlavor.STRING;
import javax.swing.plaf.synth.SynthOptionPaneUI;

import model.Student;

public class MainService {
    public static void main(String[] args) throws Exception {

        // izveido stack priekš veseliem skaitļiem
        MyStack<Integer> myStackSkaitliski = new MyStack<>();

        System.out.println("==============================================================================\n" +
                "==============================================================================\n" +
                "                                   STEKI                                      \n" +
                "==============================================================================\n" +
                "==============================================================================");
        System.out.println("\n------------MyStack PARBAUDE (INTEGER)---------------\n");

        // Pārbaudam, vai stacks ir tukšs izmantojot
        boolean atbilde1 = myStackSkaitliski.isEmpty();
        System.out.println("--------------\nVai tukss\n" + atbilde1 + "\n-------------");

        // Pārbaudām, vai ir full
        boolean atbilde2 = myStackSkaitliski.isFull();
        System.out.println("Vai pilns\n" + atbilde2 + "\n-------------\nPush");

        // Pievienojam 4 elementus
        // Kā tam jāizskatās: [10] [44] [7] [101]
        myStackSkaitliski.push(10);
        myStackSkaitliski.push(44);
        myStackSkaitliski.push(7);
        myStackSkaitliski.push(101);
        System.out.println("size: " + myStackSkaitliski.size());
        // Izvadam rezultātu
        myStackSkaitliski.print();
        System.out.println("----------------\nPop");

        // Noņemam augšējo elementu
        // Kā tam jāizskatās: [10] [44] [7]
        myStackSkaitliski.pop();
        myStackSkaitliski.print();
        System.out.println("----------------\nPush");

        // Pieliekam klāt vēl divus elementus
        // Kā tam jāizskatās: [10] [44] [7] [76] [49]
        myStackSkaitliski.push(76);
        myStackSkaitliski.push(49);
        myStackSkaitliski.print();
        System.out.println("----------------\nTop");

        // Izvadīsim Top elementu
        // Kā tam jāizskatās: [49]
        MyNodeS topNode = myStackSkaitliski.top();
        System.out.println("Top elements ir: " + topNode);
        System.out.println("----------------\nIsEmpty + Push");

        // iztukšojam un pievienojam vienu
        myStackSkaitliski.emptyList();
        myStackSkaitliski.push(23);
        myStackSkaitliski.print();

        MyStack<Student> myStackStudent = new MyStack<Student>();

        Student students1 = new Student("Haralds", "Poters", 232321, (short) 1997, (byte) 7, (byte) 31, "310797-21344",
                'm', "hpoters1@gmail.com", 200000001);
        Student students2 = new Student("Peteris", "Voldemorts", 227733, (short) 1998, (byte) 12, (byte) 31,
                "311298-38499", 'm', "lordvoldemort@gmail.com", 200000002);
        Student students3 = new Student("Anna", "Kanna", 298801, (short) 1999, (byte) 1, (byte) 1, "010199-21104", 'f',
                "klavsongs22@gmail.com", 200000003);
        Student students4 = new Student("Gustavs", "Priede", 220033, (short) 1991, (byte) 7, (byte) 22, "220791-38499",
                'm', "gustavsp23@gmail.com", 200000004);
        Student students5 = new Student("Janis", "Ola", 298999, (short) 1992, (byte) 2, (byte) 6, "060292-21104", 'm',
                "janisola2@gmail.com", 200000005);

        System.out.println("\n------------MyStack PARBAUDE (STUDENT)---------------\n");
        // Pārbaudam, vai stacks ir tukšs izmantojot
        boolean atbilde3 = myStackStudent.isEmpty();
        System.out.println("--------------\nVai tukss\n" + atbilde3 + "\n-------------");

        // Pārbaudām, vai ir full
        boolean atbilde4 = myStackStudent.isFull();
        System.out.println("Vai pilns\n" + atbilde4 + "\n-------------\nPush");

        // Pievienojam 3 elementus
        // Kā tam jāizskatās: [Haralds Poters] [Peteris Voldemorts] [Anna Kanna]
        myStackStudent.push(students1);
        myStackStudent.push(students2);
        myStackStudent.push(students3);
        // Izvadam rezultātu
        myStackStudent.print();
        System.out.println("----------------\nPop");

        // Noņemam augšējo elementu
        // Kā tam jāizskatās: [Haralds Poters] [Peteris Voldemorts]
        myStackStudent.pop();
        myStackStudent.print();
        System.out.println("----------------\nPush");

        // Pieliekam klāt vēl divus elementus
        // Kā tam jāizskatās: [Haralds Poters] [Peteris Voldemorts] [Gustavs Priede]
        // [Janis Ola]
        myStackStudent.push(students4);
        myStackStudent.push(students5);
        System.out.println("size: " + myStackStudent.size());
        myStackStudent.print();
        System.out.println("----------------\nTop");

        // Izvadīsim Top elementu
        // Kā tam jāizskatās: [Janis Ola]
        MyNodeS topNodeStudent = myStackStudent.top();
        System.out.println("Top elements ir: " + topNodeStudent);
        System.out.println("----------------\nIsEmpty + Push");

        // iztukšojam un pievienojam vienu
        myStackStudent.emptyList();
        myStackStudent.push(students3);
        myStackStudent.print();

        System.out.println("\n------------JAVA FAILA PARBAUDE---------------\n");
        // faili
        String test = "src\\TestJavaFiles\\test.java";
        String Student = "src\\TestJavaFiles\\Student.java";
        String userController = "src\\TestJavaFiles\\UserController.java";
        String UserServiceImplTest = "src\\TestJavaFiles\\UserServiceImplTest.java";
        System.out.println(sintaksesParbaude(UserServiceImplTest));

        System.out.println("==============================================================================\n" +
                "==============================================================================\n" +
                "                                   RINDAS                                     \n" +
                "==============================================================================\n" +
                "==============================================================================");

        System.out.println("\n------------myQueue PARBAUDE (INTEGER)---------------\n");
        MyQueue<Integer> myQueueSkaitliski = new MyQueue<>();
        // Pārbaudam, vai stacks ir tukšs izmantojot
        boolean atbilde5 = myQueueSkaitliski.isEmpty();
        System.out.println("--------------\nVai tukss\n" + atbilde5 + "\n-------------");

        // Pārbaudām, vai ir full
        boolean atbilde6 = myQueueSkaitliski.isFull();
        System.out.println("Vai pilns\n" + atbilde6 + "\n-------------\nENQUEUE");

        // Pievienojam 4 elementus
        // Kā tam jāizskatās: [86] [8] [701] [23]
        myQueueSkaitliski.enqueue(86); // pirmais iekšā, pirmais ārā
        myQueueSkaitliski.enqueue(8);
        myQueueSkaitliski.enqueue(701);
        myQueueSkaitliski.enqueue(23); // pēdējais iekšā, pēdējais ārā
        System.out.println("size: " + myQueueSkaitliski.size());
        // Izvadam rezultātu
        myQueueSkaitliski.print();

        System.out.println("----------------\nDEQUEUE");
        // Noņemam elementu
        // Kā tam jāizskatās: [8] [701] [23]
        myQueueSkaitliski.dequeue();
        myQueueSkaitliski.print();

        System.out.println("----------------\nEMPTY + ENQUEUE");
        // iztukšojam un pievienojam vienu
        myQueueSkaitliski.emptyList();
        myQueueSkaitliski.enqueue(388);
        myQueueSkaitliski.print();

        System.out.println("\n------------myQueue PARBAUDE (STUDENT)---------------\n");
        MyQueue<Student> myQueueStudenti = new MyQueue<>();
        // Pārbaudam, vai stacks ir tukšs izmantojot
        boolean atbilde7 = myQueueStudenti.isEmpty();
        System.out.println("--------------\nVai tukss\n" + atbilde3 + "\n-------------");

        // Pārbaudām, vai ir full
        boolean atbilde8 = myQueueStudenti.isFull();
        System.out.println("Vai pilns\n" + atbilde4 + "\n-------------\nENQUEUE");

        // Pievienojam 3 elementus
        // Kā tam jāizskatās: [Haralds Poters] [Peteris Voldemorts] [Anna Kanna]
        myQueueStudenti.enqueue(students1);
        myQueueStudenti.enqueue(students2);
        myQueueStudenti.enqueue(students3);
        System.out.println("size: " + myQueueStudenti.size());
        // Izvadam rezultātu
        myQueueStudenti.print();
        System.out.println("----------------\nDEQUEUE");

        // Noņemam augšējo elementu
        // Kā tam jāizskatās: [Peteris Voldemorts] [Anna Kanna]
        myQueueStudenti.dequeue();
        myQueueStudenti.print();
        System.out.println("----------------\nEMPTY + ENQUEUE");

        // EMPTY + ENQUEUE
        myQueueStudenti.emptyList();
        myQueueStudenti.enqueue(students5);
        myQueueStudenti.print();

        System.out.println("\n------------ZVANU AVARIJAS DIENESTS---------------\n");
        zvanuAvarijasDienest();

        System.out.println("==============================================================================\n" +
                "==============================================================================\n" +
                "                                   DEKI                                     \n" +
                "==============================================================================\n" +
                "==============================================================================");

        System.out.println("\n------------MyDeque PARBAUDE (INTEGER)---------------\n");
        MyDeque<Integer> myDequeSkaitliski = new MyDeque<>();

        // Pārbaudam, vai stacks ir tukšs izmantojot
        boolean atbilde9 = myDequeSkaitliski.isEmpty();
        System.out.println("--------------\nVai tukss\n" + atbilde9 + "\n-------------");

        // Pārbaudām, vai ir full
        boolean atbilde10 = myDequeSkaitliski.isFull();
        System.out.println("Vai pilns\n" + atbilde10 + "\n-------------\nENQUEUE FRONT UN END");

        // Pievienojam 6 elementus, 3 no priekšas un 3 no aizmugures
        // Kā tam jāizskatās: [4] [4344] [99] [731] [2] [12]
        System.out.println("Front");
        myDequeSkaitliski.enqueueAtFront(99);
        myDequeSkaitliski.enqueueAtFront(4344);
        myDequeSkaitliski.enqueueAtFront(4);
        myDequeSkaitliski.print();
        System.out.println("End");
        myDequeSkaitliski.enqueueAtEnd(731);
        myDequeSkaitliski.enqueueAtEnd(2);
        myDequeSkaitliski.enqueueAtEnd(12);

        // Izvadam rezultātu
        myDequeSkaitliski.print();
        System.out.println("Total size: " + myDequeSkaitliski.size());

        System.out.println("----------------\nDEQUEUE FRONT UN END ");
        // Noņemam elementu no priekšas
        // Kā tam jāizskatās: [4344] [99] [731] [2] [12]
        myDequeSkaitliski.dequeueFromFront();
        myDequeSkaitliski.print();

        // Noņemam elementu no aizmugures
        // Kā tam jāizskatās: [4344] [99] [731] [2]
        myDequeSkaitliski.dequeueFromEnd();
        myDequeSkaitliski.print();

        System.out.println("----------------\nEMPTY + ENQUEUE FRONT UN END");
        // iztukšojam un pievienojam vienu
        myDequeSkaitliski.emptyList();
        myDequeSkaitliski.enqueueAtFront(388);
        myDequeSkaitliski.enqueueAtEnd(388);
        myDequeSkaitliski.print();

        System.out.println("\n------------myQueue PARBAUDE(STUDENT)---------------\n");
        MyDeque<Student> myDequeStudent = new MyDeque<>();
        // Pārbaudam, vai stacks ir tukšs izmantojot
        boolean atbilde11 = myDequeStudent.isEmpty();
        System.out.println("--------------\nVai tukss\n" + atbilde11 +
                "\n-------------");

        // Pārbaudām, vai ir full
        boolean atbilde12 = myDequeStudent.isFull();
        System.out.println("Vai pilns\n" + atbilde12 + "\n-------------\nENQUEUE FRONT UN END");

        // Pievienojam 4 elementus 2 no priekšas un 2 no aizmugures
        // Kā tam jāizskatās: [Peteris Voldemorts] [Haralds Poters] [Anna Kanna] [Anna
        // Kanna]
        myDequeStudent.enqueueAtFront(students1);
        myDequeStudent.enqueueAtFront(students2);
        myDequeStudent.enqueueAtEnd(students3);
        myDequeStudent.enqueueAtEnd(students4);
        System.out.println("size: " + myDequeStudent.size());
        // Izvadam rezultātu
        myDequeStudent.print();
        System.out.println("----------------\nDEQUEUE FRONT UN END ");

        // Noņemam elementu no priekšas
        // Kā tam jāizskatās: [Haralds Poters] [Anna Kanna] [Anna Kanna]
        myDequeStudent.dequeueFromFront();
        myDequeStudent.print();

        // Noņemam elementu no aizmugures
        // Kā tam jāizskatās: [Haralds Poters] [Anna Kanna]
        myDequeStudent.dequeueFromEnd();
        myDequeStudent.print();

        System.out.println("----------------\nEMPTY + ENQUEUE FRONT UN END");
        // iztukšojam un pievienojam vienu
        myDequeStudent.emptyList();
        myDequeStudent.enqueueAtFront(students5);
        myDequeStudent.enqueueAtEnd(students2);
        myDequeStudent.print();

        System.out.println("------------\nPARLUKA VESTURES SIMULACIJA---------------");
        browserHistorySimulation();
    }

    // funkcija java koda sintakses pārbaudei
    public static String sintaksesParbaude(String filePath) throws Exception {
        BufferedReader reader; // buffer reader funkcija, lai lasītu failu
        int rindasNr = 0; // skaita rindas
        int errorCounter = 0; // skaita cik error
        MyStack<Character> iekavuStack = new MyStack<>(); // stack kur uzgalbāsies iekavas

        try {
            reader = new BufferedReader(new FileReader(filePath)); // nolasa java failu
            String rinda; // vienu rindiņu definē kā String
            System.out.println("Nolasitais fails: " + filePath + "\n");
            while ((rinda = reader.readLine()) != null) { // kamēr rindiņas nav beigušās
                rindasNr++; // skaitam rindas, lai zinātu kurā rindā ir kļūda
                for (int i = 0; i < rinda.length(); i++) { // ejam cauri rindas elementiem
                    char currentChar = rinda.charAt(i);
                    if (currentChar == '(' || currentChar == '[' || currentChar == '{') { // ja atrod kādu no
                                                                                          // atverošajām iekavām,
                        iekavuStack.push(currentChar); // to pievieno stekam
                    } else if (currentChar == ')' || currentChar == ']' || currentChar == '}') { // ja atrod kādu no
                                                                                                 // aizverošajām iekavām
                                                                                                 // ...
                        if (iekavuStack.isEmpty()) { // pārbaudām vai ir atverošās iekavas
                            System.out
                                    .println("Error: Lieka aizverosa iekava: " + currentChar + " in line " + rindasNr); // izvada
                                                                                                                        // lieku
                                                                                                                        // aizverošo
                                                                                                                        // iekavu
                            errorCounter++;
                        } else {
                            String augsejaAtverosaIekava = iekavuStack.top().toString(); // MyNodeS atgriež object
                                                                                         // formas mainīgos, tapēc
                            char Atverosa = augsejaAtverosaIekava.charAt(0); // japārvērš tas par char
                            iekavuStack.pop(); // izdzēš augšējo
                            if ((currentChar == ')' && Atverosa != '(') || // atrodot aizveroso un skatās, vai nav
                                                                           // atverošā
                                    (currentChar == ']' && Atverosa != '[') ||
                                    (currentChar == '}' && Atverosa != '{')) {
                                // atrod aizverošo iekavu bez atverošās, kad stacks nav tukšs
                                System.out.println("Error: aizverosa iekava bez atverosas: " + currentChar + " in line "
                                        + rindasNr);
                                errorCounter++;
                            }
                        }
                    }
                }
            }

            while (!iekavuStack.isEmpty()) { // iziet cauri atlikušajām atverošājām iekavām
                String augsejaAtverosaIekava2 = iekavuStack.top().toString(); // atkal pārvērš par char
                char neaizvertas = augsejaAtverosaIekava2.charAt(0);
                iekavuStack.pop(); // noņem augšējo
                System.out.println("Error: atverosa iekava bez aizverosas: " + neaizvertas + " in line ---"); // izvada,
                                                                                                              // ka ir
                                                                                                              // atverošā
                                                                                                              // iekava
                                                                                                              // bez
                                                                                                              // aizverošās.
                // Diemžēl atsevišķu rindu saglabāšanu atverošājām iekavām bija slinkums ieviest
                // :)
                errorCounter++;
            }

            reader.close(); // beidzam lasīt failu
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Error count: " + errorCounter; // izvadam kļūdu skaitu
    }


    public static void zvanuAvarijasDienest() throws Exception{
        MyQueue<Integer> myQueueTelefonaNr = new MyQueue<>();
        Random random = new Random();


        // katru sekundi vai mazāk zvanu dienest saņem jaunu zvanu (max 5, lai neaiziet
        // bezgalīgais loop)
        System.out.println("Generejam nr");
        for (int i = 1; i <= 5; i++) {
            int randomNr = random.nextInt(10000000) + 20000000;
            Thread.sleep(random.nextInt(1000));
            System.out.println(i + ". " + randomNr);
            myQueueTelefonaNr.enqueue(randomNr);
        }

        // Atbildam uz zvaniem
        System.out.println("\nAtbildam uz nr");
        while (!myQueueTelefonaNr.isEmpty()) {
            int phoneNumber = myQueueTelefonaNr.dequeue();
            int laiks = random.nextInt(3000);
            System.out.println(
                    "Atbildets " + phoneNumber + " zvana ilgums: " + Math.round((float) laiks / 100) / 10.0 + "s");
            Thread.sleep(laiks); // Simulē atbildes laiku
        }
        myQueueTelefonaNr.print(); // pārbaude, vai tiešām viss ir noņemts
    }

    public static void browserHistorySimulation() throws InterruptedException {
        Scanner newScanner = new Scanner(System.in);
        System.out.println("Vadit URL manuali (1), vadit URL automatiski (2)");
        String izvele = newScanner.nextLine();
        MyDeque<String> myDequeBrowser = new MyDeque<>();
        int urlCounter = 0;
        String url;
        if (izvele.equals("1")) {
            System.out.println("Ievadi vismaz 10 URL \n FUNKCIJAS \n \"stop\" : aptur darbibu \n \"print\" : izvada vesture sarakstu\n");
    
            do {
                System.out.print("\nEnter URL (enter 'stop' to end): ");
                url = newScanner.nextLine();
                if (!url.equals("stop")) {
                    myDequeBrowser.enqueueAtFront(url);
                    myDequeBrowser.print();
                    urlCounter++;
                    if (urlCounter >= 10) {
                        try {
                            myDequeBrowser.dequeueFromEnd();
                        } catch (Exception e) {
                            e.getMessage();
                        }
                    }
                }
            } while (!url.equals("stop"));
        } else if (izvele.equals("2")) {
            System.out.println("Automatiska URL ievade");
    
            for (int i = 0; i < 15; i++) {
                Thread.sleep(1000);
                url = generateRandomURL();
                System.out.println("\nEntered URL (atkartosies 15 reizes): " + url);
                myDequeBrowser.enqueueAtFront(url);
                myDequeBrowser.print();
                urlCounter++;
                if (urlCounter >= 10) {
                    try {
                        myDequeBrowser.dequeueFromEnd();
                    } catch (Exception e) {
                        System.out.println("Error removing URL from the end: " + e.getMessage());
                    }
                }
            }
        }
    }
    
        private static String generateRandomURL() {
            String burti = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String skaitli = "0123456789";
        
            StringBuilder urlBuilder = new StringBuilder();
            urlBuilder.append("https://");
            for (int i = 0; i < 2; i++) {
                urlBuilder.append(burti.charAt((int) (Math.random() * burti.length())));
                urlBuilder.append(skaitli.charAt((int) (Math.random() * skaitli.length())));
            }
            return urlBuilder.toString();
        }
        
    
}