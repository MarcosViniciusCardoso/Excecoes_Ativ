package model.entities;

import model.exceptions.BusinessException;

public class Account {
	private Integer number;
	private String Holder;
	private Double balance;
	private Double withdrawLimit;

	public Account() {
	}

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.Holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;// Número
	}

	public String getHolder() {
		return Holder;
	}

	public void setHolder(String holder) {
		Holder = holder; // titular
	}

	public Double getBalance() {
		return balance;// Saldo
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;// Limite de retirada
	}

	public void deposite(Double amount) {
		if (amount > 0) {
			System.out.println("Não pode informar valor negativo !");
		}
		this.balance += amount;
	}

	public void withdraw(Double amount) {// retirar
		validateWithDraw(amount);
		balance -= amount;
	}

	public void validateWithDraw(double amount) {

		if (amount > getWithdrawLimit()) {
			throw new BusinessException("Valor ultrapassou limite de saque");
		}

		if (amount > getBalance()) {
			throw new BusinessException("Saldo insuficiente !");
		}

	}

}
