package model;

public class Student implements Comparable<Student>{
    //1. mainīgie jeb dati
    private String name;
    private String surname;
    private int studentId;
    private short birthYear;
    private byte birthMonth;
    private byte birthDay;
    private String personCode;
    private char gender;
    private String email;
    private long phoneNo;
    
    
    
    //2. get funkcijas
    public String getName() {
    return name;
    }
    
    public String getSurname() {
    return surname;
    }
    
    public int getStudentId() {
    return studentId;
    }
    
    public byte getBirthMonth() {
    return birthMonth;
    }
    
    
    public short getBirthYear() {
    return birthYear;
    }
    
    public byte getBirthDay() {
    return birthDay;
    }
    
    public String getPersonCode() {
    return personCode;
    }
    
    public char getGender() {
    return gender;
    }
    
    public String getEmail() {
    return email;
    }
    
    public long getPhoneNo() {
    return phoneNo;
    }
    
    //3. set funkcijas
    
    
    public void setName(String inputName) {
    if(inputName != null && inputName.length() > 2
    && inputName.matches("[A-Z]{1}[a-z]+")) {
    
    name = inputName;
    }
    else
    {
    name = "--wrong name--";
    }
    }
    
    public void setSurname(String inputSurname) {
    if(inputSurname != null && inputSurname.length()>2
    && inputSurname.matches("[A-Z]{1}[a-z]+")) {
    surname = inputSurname;
    }
    else
    {
    surname = "--wrong surname--";
    }
    }
    
    
    
    public void setStudentId(int inputStudentId) {
    if(inputStudentId >= 100000 && inputStudentId <=999999) //100000 - 999999
    {
    studentId = inputStudentId;
    }
    else
    {
    studentId = 99999;//pēc noklusejuma, ja nebūs pareizi ievadīts
    }
    }
    
    //ģeneŗēts no Eclipses
    /*
    public void setStudentId(int studentId) {
    if(studentId >= 100000 && studentId <=999999) {
    this.studentId = studentId;
    }
    else
    {
    this.studentId = 99999;//pēc noklusejuma, ja nebūs pareizi ievadīts
    }
    }*/
    
    public void setBirthYear(short inputBirthYear) {
    if(inputBirthYear >= 1900 && inputBirthYear <=2010) //1900 - 2010
    {
    birthYear = inputBirthYear;
    }
    else
    {
    birthYear = 2000;//pēc noklusejuma, ja nebūs pareizi ievadīts
    }
    }
    
    public void setBirthMonth(byte inputBirthMonth) {
    if(inputBirthMonth >= 1 && inputBirthMonth <=12) //1 - 12
    {
    birthMonth = inputBirthMonth;
    }
    else
    {
    birthMonth = 1;//pēc noklusejuma, ja nebūs pareizi ievadīts
    }
    }
    
    public void setBirthDay(byte inputBirthDay) {
    //TODO skatīties pēc ieprieks salabātā mēneša un no ta skatīti, vai ir atbilstoša diena
    if(inputBirthDay >= 1 && inputBirthDay <=31) //1 - 30
    {
    birthDay = inputBirthDay;
    }
    else
    {
    birthMonth = 1;//pēc noklusejuma, ja nebūs pareizi ievadīts
    }
    }
    
    public void setPersonCode(String inputPersonCode) {
    if(inputPersonCode!=null && inputPersonCode.matches("[0-9]{6}-[0-9]{5}")) {
    personCode = inputPersonCode;
    }
    else
    {
    personCode = "-- wrong person code--";
    }
    }
    
    public void setGender(char inputGender) {
    if(inputGender == 'f' || inputGender == 'm') {
    gender = inputGender;
    }
    else
    {
    gender = 'f';
    }
    }
    
    public void setEmail(String inputEmail) {
    if(inputEmail != null && inputEmail.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
    email = inputEmail;
    }
    else
    {
    email = "--wrong email--";
    }
    }
    
    public void setPhoneNo(long inputPhoneNo) {
    if(inputPhoneNo>= 20000000 && inputPhoneNo <= 29999999) { //20000000 29999999
    phoneNo = inputPhoneNo;
    }
    else
    {
    phoneNo = 19999999;//nepareizais
    }
    }
    
    
    //4.izveidot konstruktoru
    public Student() { //noklusetais konstruktors, kas izveidot dummy objektu
    setName("Janis");
    setSurname("Berzins");
    setStudentId(234567);
    setBirthYear((short)2000);
    setBirthMonth((byte)9);
    setBirthDay((byte)29);
    setPersonCode("121212-23456");
    setGender('m');
    setEmail("janis.berzins@venta.lv");
    setPhoneNo(27867456);
    
    
    }
    
    
    
    public Student(String inputName, String inputSurname,
    int inputStudentId, short inputBirthYear, byte inputBirthMonth,
    byte inputBirthDay, String inputPersonCode, char inputGender,
    String inputEmail, long inputPhoneNo) {//argumentu konstruktors
    
    setName(inputName);
    setSurname(inputSurname);
    setStudentId(inputStudentId);
    setBirthYear(inputBirthYear);
    setBirthMonth(inputBirthMonth);
    setBirthDay(inputBirthDay);
    setPersonCode(inputPersonCode);
    setGender(inputGender);
    setEmail(inputEmail);
    setPhoneNo(inputPhoneNo);
    ;
    }

    //toString
    public String toString() {
    String result = name + " " + surname;
    return result;
}



//6.papildus funkcijas (ja nepieciešams)
    @Override
    public int compareTo(Student arg0) {
    if(surname.charAt(0) > arg0.surname.charAt(0))
    return 1;
    else if (surname.charAt(0) < arg0.surname.charAt(0))
    return -1;
    else
    return 0;
    }
    }
