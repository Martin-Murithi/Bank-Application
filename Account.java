import java.util.InputMismatchException;
import java.util.Scanner;

public class Account {
	Scanner scanner = new Scanner(System.in);
	private String userName;
	private String inputUserId;
	private String inputUserPassword;
	private double amount;
	private double balance;
	private int years;
	private double previousTransaction;
	private char newOption;
	private char option;

	public Account(String name, String id) {
		this.userName = name;
		this.inputUserId = id;
	}

	public void login() {
		do {
		System.out.println("Enter your user Id:");
		inputUserId = scanner.next();
		System.out.println("Enter your password : ");
		inputUserPassword = scanner.next();

		String userId = "User100";
		String userPassword = "Default";

		if(inputUserId.equals(userId) && inputUserPassword.equals(userPassword)) {
			menu();
		}
		else if(inputUserId.equals(userId)) {
			System.out.println("Incorrect password.");
		}
		else if(inputUserPassword.equals(userPassword)) {
			System.out.println("Incorrect User Id");
		}
		else {
			System.out.println("Invalid user Id and password.");
		}
		}while(inputUserId.equals("") && inputUserPassword.equals(""));
	}

	public void userInfo() {
		System.out.println("  Name :" + userName);
		System.out.println("  UserId :" + inputUserId );
		System.out.println("  Balance :" + balance);
	}

	public void deposit(double amount) {
		balance = balance + amount;
		previousTransaction = +amount;

	}

	public void withdraw(double amount) {
		balance = balance - amount;
		previousTransaction = -amount;

	}

	public void previousTrans() {
		if(previousTransaction > 0) {
			System.out.println("Deposited : $" +previousTransaction);
		}
		else if(previousTransaction < 0) {
			System.out.println("Withdrawn : " +previousTransaction);
		}
		else {
			System.out.println("No previous transacrions");
		}
	}

	public void calculateInterest(int years) {
		double interestRate = 2.5;
		double newBalance = (interestRate * years) + balance;
		System.out.println("The current interest rate is : "+(100 * interestRate) +"%");
		System.out.println("After "+years +" years, your balance will be " +newBalance);
	}

	public void exit() {
		System.out.println("Thank you for banking with us.");
		System.exit(0);
	}
	public void menu() {
		System.out.println();
		System.out.println("   Welcome "+userName+ ", user Id " +inputUserId);
		System.out.println();
		System.out.println("       MAIN MENU   ");
		System.out.println("  A. Show Account");
		System.out.println("  B. Check account balance");
		System.out.println("  C. Deposit");
		System.out.println("  D. Withdraw");
		System.out.println("  E. View Previous transactions");
		System.out.println("  F. Calculate interest");
		System.out.println("  G. Exit");
		System.out.println();

		do {
			System.out.println();
			System.out.println("Select an option : ");
			option = Character.toUpperCase(newOption);
			newOption = scanner.next().charAt(0);
			switch(newOption) {
				case 'a' :
					userInfo();
					break;

				case 'b' :
					System.out.println("Account balance is : $" +balance);
					break;

				case 'c' :
					try {
					System.out.println("Enter amount you want to deposit :");
					amount = scanner.nextDouble();
					deposit(amount);
					System.out.println("New balance : " +" $"+balance);
					}
					catch(InputMismatchException e) {
						System.out.println("You have not deposited any money!");
					}
					scanner.nextLine();
					break;

				case 'd' :
					try {
					System.out.println("Enter amount to withdraw");
					amount = scanner.nextDouble();

					if(balance != 0 && amount <= balance) {
						withdraw(amount);
						System.out.println("New balance : " +" $"+balance);
					}
					else {
						System.out.println("Insufficient funds! Your account balance is : "+" $"+balance);
					}}
					catch(InputMismatchException e) {
						System.out.println("You have not withdrawn any money!");
					}
					scanner.nextLine();

					break;

				case 'e' :
					previousTrans();
					break;

				case 'f' :
					try {
					System.out.println("Enter number of years to invest : ");
					int years = scanner.nextInt();
					scanner.nextLine();
					calculateInterest(years);
					}
					catch(InputMismatchException e) {
						System.out.println("Please enter years in number format.");
					}
					scanner.nextLine();
					break;

				case 'g' :
					System.out.println("Thank you for banking with us.");
					System.exit(0);
					break;

				default:
					System.out.println("Please select an option from the above list.");
					break;
			}
		}while(newOption != 'g');
			System.out.println();
			exit();
	}

}

