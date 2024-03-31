package model;

import java.util.Arrays;

public class Student implements Comparable<Student>{
	
    private int ID;
    private String name;
    private String surname;
    private int[] grades = new int[3];
    private static int counter = 0;

    public int getID() {
        return ID;
    }

    public void setID() {
        this.ID = counter;
        counter++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int[] getGrades() {
        return grades;
    }

    public void setGrades(int[] grades) {
        this.grades = grades;
    }

    public Student() {
        name = "";
        surname = "";
        setID();
    }

    public Student(String name, String surname, int[] grades) {
        this.name = name;
        this.surname = surname;
        this.grades = grades;
        setID();
    }

    public double calculateAVGgrade() {
        double sum = 0.0;
        int gradeCount = 0;
        for (int grade : grades) {
            sum += grade;
            gradeCount++;
        }
        return sum/gradeCount;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", grades=" + Arrays.toString(grades) + calculateAVGgrade() +
                '}';
    }

	@Override
	public int compareTo(Student o) {
		double student1AVGGrade = this.calculateAVGgrade();
		double student2AVGGrade = o.calculateAVGgrade);
		if(student1AVGGrade > student2AVGGrade)
			return 1;
		else if (student1AVGGrade < student2AVGGrade)
			return -1;
		else
			return 0;
	}

   
}
