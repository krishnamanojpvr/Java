public class overflow {
    public static void main(String[] args) {
        // Overflow
        int a = 130;
        byte b = (byte) a;
        System.out.println(a);//130
        System.out.println(b);//-126
    }
}

// In this Java program, you're attempting to store an integer value 130 into a byte variable b. However, the range of a byte in Java is from -128 to 127 (inclusive). When you try to store a value outside this range, it results in overflow, and the value wraps around within the byte's range.

// Let's see what happens step by step:

// int a = 130; - You declare an integer variable a and assign it the value 130.
// byte b = (byte)a; - You attempt to cast the integer value a to a byte and store it in variable b. However, since 130 is outside the range of a byte, overflow occurs.
// System.out.println(a); - Prints the value of a, which is 130.
// System.out.println(b); - Prints the value of b, which is -126 (due to overflow).

// Here's why b becomes -126:
// Data Type Limit: In Java, a byte can store values from -128 to 127.
// Overflow: When you try to put a value outside this range into a byte, it overflows.
// Wrapping Around: After overflowing, it wraps around. For example, if you go beyond 127, it starts from -128 and counts up again.
// So, when you try to store 130 in a byte, it overflows and wraps around, resulting in -126.