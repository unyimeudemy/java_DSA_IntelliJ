package OOP;

import java.util.Arrays;

public class Introduction {

    static Student[] students = new Student[3];
    public static void main(String[] args){
//        Student newStudent1 = new Student("unyime", 380);
//        Student newStudent2 = new Student("emma", 400);
//        students[0] = newStudent1;
//        students[1] = newStudent2;
//
//        System.out.println(Arrays.toString(students));



        Student newStudent2 = new Student();
        newStudent2.score = 88.0434f;
        System.out.println(newStudent2.score);

    }
}

class Student{
    String name;
    float score;
    int rollNum;
//    public Student(String name, int score){
//        this.name = name;
//        this.score = score;
//    }
}
