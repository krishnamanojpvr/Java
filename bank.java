import java.util.Scanner;

public class bank {
	public static void main(String[] args) {
		Scanner obj = new Scanner(System.in);
		account a = new account(96184, "Manoj", 0);
		a.welcome();
		boolean flag = true;
		while (flag) {
			System.out.println("Enter 1 for deposit, 2 for withdraw, 3 to check balance, 4 for transactions, 5 to exit ");
			int choice = obj.nextInt();
			switch (choice) {
				case 1:
					System.out.println("Enter the deposit amount : ");
					float depositAmt = obj.nextFloat();
					a.deposit(depositAmt);
					break;
				case 2:
					System.out.println("Enter the withdraw amount : ");
					float withdrawAmt = obj.nextFloat();
					a.withdraw(withdrawAmt);
					break;
				case 3:
					System.out.println(a.getbalance());
					break;
				case 4:
					System.out.println("Total transactions : " + a.transactions());
					break;
				case 5:
					flag = false;
					break;
				default:
					System.out.println("Enter valid choice");
					break;
			}
		}

		obj.close();
	}

}

class account {
	private int accNo;
	String accHolderName;
	private float balance;
	private int transactions;

	account(int accNumber, String accHolderName, float bal) {
		this.accNo = accNumber;
		this.accHolderName = accHolderName;
		this.balance = bal;
		this.transactions = 0;
	}

	void withdraw(float amt) {
		if (amt > balance) {
			System.out.println("Low Balance");
			return;
		}
		this.balance = balance - amt;
		this.transactions++;
		System.out.println("Withdrawn " + amt);
	}

	void deposit(float amt) {
		this.balance = balance + amt;
		this.transactions++;
		System.out.println("Deposited " + amt);
	}

	float getbalance() {
		System.out.print("Balance : ");
		float bal = this.balance;
		return bal;
	}

	void welcome() {
		System.out.println("Welcome to the bank, " + this.accHolderName + " (" + " your account number is " + this.accNo + " )");
	}

	int transactions() {
		int tra = this.transactions;
		return tra;
	}
}