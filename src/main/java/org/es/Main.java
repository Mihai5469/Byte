package org.es;

public class Main {
    public static void main(String[] args) {
        Byte b = new Byte("0000010");

        System.out.println(b);
        System.out.println("metodo istanza: " + b.decimale());

        System.out.println("Cifra PS: " + b.cifraPS());
        System.out.println("Cifra MS: " + b.cifraMS());
        System.out.println("Invertito: " + b.inverti());



    }
}