import java.io.*;
import java.util.Scanner;
public class vot{
    public static void main(String[] args) throws IOException{
        File f = new File("/home/manoj/prog/java/fs/hyderabad");
        f.mkdirs();
        File f2 = new File("voters.txt");
        f2.createNewFile();
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        int age = scanner.nextInt();
        FileWriter fw = new FileWriter(f2);
        fw.write(name + " , " + age);
        fw.close();
        scanner.close();
    }
}