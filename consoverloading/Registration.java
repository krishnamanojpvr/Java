// * Constructor Overloading

// Enigma has recently opened its internet services in India. The company wants users to register for their internet services. But for the authentication of the user, the company has set criteria as below:
//     • The customer name and two phone numbers (one alternate phone number) are compulsory fields.
//     • The user should have a passport. If the user is not having a passport, he/she can provide anyone of the following combinations:
//     • License number and pan card number.
//     • Voter id and license number.
//     • Pan card and voter id.

import java.util.Scanner;
public class Registration{
    public String customerName;
    private String panCardNo;
    private int voterId;
    private String passportNo;
    private int licenseNo;
    private long[] telephoneNo;

    public static Scanner input = new Scanner(System.in);
    Registration(String customerName, String passportNo, long[] telephoneNo){
        this.customerName = customerName;
        this.passportNo = passportNo;
        this.telephoneNo = telephoneNo;
        System.out.println("Congratulations " + customerName + " You have been successfully registered for our services with the following details:");
        System.out.println("Passport number : " + passportNo);
        System.out.println("Phone numbers : " + telephoneNo[0] + "\n" + telephoneNo[1]);
    }
    Registration(String customerName, int licenseNo, String panCardNo,long[] telephoneNo ){
        this.customerName = customerName;
        this.licenseNo = licenseNo;
        this.panCardNo = panCardNo;
        this.telephoneNo = telephoneNo;
        System.out.println("Congratulations " + customerName + " You have been successfully registered for our services with the following details:");
        System.out.println("License number : " + licenseNo);
        System.out.println("Pan card number : " + panCardNo);
        System.out.println("Phone numbers : " + telephoneNo[0] + "\n" + telephoneNo[1]);
    }
    Registration(String customerName, int voterId, int licenseNo, long[] telephoneNo){
        this.customerName = customerName;
        this.voterId = voterId;
        this.licenseNo = licenseNo;
        this.telephoneNo = telephoneNo;
        System.out.println("Congratulations " + customerName + " You have been successfully registered for our services with the following details:");
        System.out.println("Voter id : " + voterId);
        System.out.println("License number : " + licenseNo);
        System.out.println("Phone numbers : " + telephoneNo[0] + "\n" + telephoneNo[1]);
    }
    Registration(String customerName, String panCardNo, int voterId, long[] telephoneNo){
        this.customerName = customerName;
        this.panCardNo = panCardNo;
        this.voterId = voterId;
        this.telephoneNo = telephoneNo;
        System.out.println("Congratulations " + customerName + " You have been successfully registered for our services with the following details:");
        System.out.println("Pan card number : " + panCardNo);
        System.out.println("Voter id : " + voterId);
        System.out.println("Phone numbers : " + telephoneNo[0] + "\n" + telephoneNo[1]);
    }
    

    void display(){
        System.out.println("Name : " + customerName);
        System.out.println("Passport number : " + passportNo);
        System.out.println("Phone numbers : " + telephoneNo[0] + "\n" + telephoneNo[1]);
        if(licenseNo != 0){
            System.out.println("License number : " + licenseNo);
        }
        if(panCardNo != null){
            System.out.println("Pan card number : " + panCardNo);
        }
        if(voterId != 0){
            System.out.println("Voter id : " + voterId);
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Enigma internet service");
        System.out.println("Please enter your details below");

        String name = Methods.getCustomerName();

        boolean status = Methods.checkPass();

        Registration user;

        if(status){
            String passport = Methods.getPassportNo();
            long[] telephone = Methods.getTelephoneNo();
            user = new Registration(name, passport, telephone);
            user.display();
        }
        else{
            System.out.println("Please provide any one of the following combinations : ");
            System.out.println("1. License number and pan card number.");
            System.out.println("2. Voter id and license number.");
            System.out.println("3. Pan card and voter id.");
            System.out.println("Enter your choice : ");
            int choice = input.nextInt();
            int license;
            int voterid;
            long[] telephone;
            String pancard;
            switch(choice){
                case 1:
                    license = Methods.getLicenseNo();
                    pancard = Methods.getPanCardNo();
                    telephone = Methods.getTelephoneNo();
                    user = new Registration(name, license, pancard, telephone);
                    user.display();
                    break;
                case 2:
                    voterid = Methods.getVoterId();
                    license = Methods.getLicenseNo();
                    telephone = Methods.getTelephoneNo();
                    user = new Registration(name, voterid, license, telephone);
                    user.display();
                    break;
                case 3:
                    pancard = Methods.getPanCardNo();
                    voterid = Methods.getVoterId();
                    telephone = Methods.getTelephoneNo();
                    user = new Registration(name, pancard, voterid, telephone);
                    user.display();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
            
        }
        
    }

}

 