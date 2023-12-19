package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Main myRecursion = new Main();
        myRecursion.message1();
    }

    public void message1(){
        System.out.println("hello world");
        message2();
    }


    public void message2(){
        System.out.println("hello world");
        message3();
    }

    public void message3(){
        System.out.println("hello world");
        message4();
    }

    public void message4(){
        System.out.println("hello world");
        message5();
    }

    public void message5(){
        System.out.println("hello world");
    }
}