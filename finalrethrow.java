import java.util.*;
public class finalrethrow {

    finalrethrow() {        
        try{
            throwExceptions();
           } catch (final A | B | C e){
               System.out.printf("Exception class %s%n", e.getClass());
           }
    }
   
    private void throwExceptions() throws A, B, C {
        try {                        
            throwAccordingToIndex(new Random().nextInt(2));
        } catch (final Exception  e){
            System.out.printf("Caught %s and rethrowing...%n", e);
            throw e;
        }
    }
    
    private void throwAccordingToIndex(int index) throws A, B, C {
        switch (index)
        {
            case 0:
                throw new A();
            case 1:
                throw new B();
            case 2:
                throw new C();
        }        
    }
    
    public static void main(String ... args) {       
        new finalrethrow();
    }

}
class A extends Exception {

}

class B extends Exception {
}

class C extends Exception {
}