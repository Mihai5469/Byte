package org.es;

public class Main {
    public static void main(String[] args) {
        Byte b = new Byte("101");
        System.out.println(b);
        System.out.println("metodo istanza: " + b.decimale());


        System.out.println("metodo statico: " + Byte.decimale("110"));
    }
}