public class variableTypes {
    static int m = 100;// static variable

    void method() {
        int n = 90;// local variable
        System.out.println(n);// local variable
    }

    public static void main(String args[]) {

        int data = 50;// instance variable
        System.out.println(data);// instance variable

        System.out.println(m);// static variable

        variableTypes obj=new variableTypes();
        obj.method();
    }
}
