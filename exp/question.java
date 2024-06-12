package exp;

import java.io.*;

public class question {
   public static void main(String []args) throws IOException{
        File f = new File("emp.csv");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String s=br.readLine();
        while(s!=null){
            String[] str = s.split(",");
            try{
                if(!str[2].contains("Water")||!str[2].contains("Accounts")){
                  throw new InvalidDepartment();
                }
                if(Integer.parseInt(str[1])>65){
                    throw new InvalidAge();
                  }
                  if(Integer.parseInt(str[3])<10000){
                    throw new InvalidSalary();
                  }
            }
            catch(Exception e){
                System.out.println("In Catch");
            }
        }
        br.close();
   }

 static   class InvalidDepartment extends RuntimeException {
        InvalidDepartment() {
            System.out.println("Invalid Department");
        }
    }

  static  class InvalidAge extends RuntimeException {
        InvalidAge() {
            System.out.println("Invalid Age");
        }
    }

  static  class InvalidSalary extends RuntimeException {
        InvalidSalary() {
            System.out.println("Invalid Salary");
        }
    }
}
