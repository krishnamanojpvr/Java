public class typecasting {
    public static void main(String[] args) {
        double d = 10.5;
        System.out.println(d);
        float f = (float) d; //narrowing    

        // float f = 10.5;//Compile time error This is wrong!!!
        // float f = 10.5f;//Right way
        // float f = (float) 10.5;//Also a Right way
        
        // int a=f;//Compile time error
        int a = (int) f;//narrowing
        System.out.println(f);
        System.out.println(a);

        int i = 100;
        long l = i;//widening
        System.out.println(l);
        System.out.println(i);

        int j = 200;
        double k = j;//widening
        System.out.println(k);
        System.out.println(j);

        double m = 100.04;
        long n = (long) m;//narrowing
        System.out.println(m);
        System.out.println(n);
    }
}
