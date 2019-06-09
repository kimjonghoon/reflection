package net.java_school.examples;

import java.util.Date;

public class BankAccount {
	public static final String SWIFT_CODE = "SCBLKRSE";
	private int accountNo;
	private String owner;
	private int balance;
	public String message;

	public BankAccount() {
		message = "Created at " + new Date();
	}

	public BankAccount(int accountNo, String owner) {
		this();
		this.accountNo = accountNo;
		this.owner = owner;
	}

	public BankAccount(int accountNo, String owner, int balance) throws RuntimeException {
		this(accountNo, owner);
		if (balance < 0) throw new RuntimeException("Negative balance not allowed");
		this.balance = balance;
	}

	public int deposit(int amount) {
		balance += amount;
		return balance;
	}

	public int withdraw(int amount) throws RuntimeException {
		if (balance - amount < 0) throw new RuntimeException("Nagative balance not allowed");
		balance -= amount;
		return balance;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Account No:");
		sb.append(this.getAccountNo());
		sb.append("|Owner:");
		sb.append(this.getOwner());
		sb.append("|Balance:");
		sb.append(this.getBalance());
		sb.append("|Message:");
		sb.append(this.message);

		return sb.toString();
	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

}