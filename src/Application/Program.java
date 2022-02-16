package Application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.BusinessException;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter account data");
		System.out.print("Número da conta: ");
		Integer number = sc.nextInt();
		System.out.print("Holder: ");
		String holder = sc.nextLine();
		sc.nextLine();
		System.out.print("Initial balance: ");
		Double balance = sc.nextDouble();
		System.out.print("With limit: ");
		Double limit = sc.nextDouble();

		Account conta = new Account(number, holder, balance, limit);

		System.out.print("Enter amount for withdraw: ");
		Double withdraw = sc.nextDouble();

		try {
			conta.withdraw(withdraw);
			System.out.print("New balance: ");
			System.out.println(conta.getBalance());
		}

		catch (BusinessException e) {
			System.out.println(e.getMessage());
		}
		sc.close();
	}
}
