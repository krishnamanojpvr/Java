package MCQS;

class A {
    protected static String s = "A";
}

class B extends A {

}

class C extends B {
    static void methodOfC() {
        System.out.println(s);
    }
}

public class MainClass {
    public static void main(String[] args) {
        C.methodOfC();
    }
}