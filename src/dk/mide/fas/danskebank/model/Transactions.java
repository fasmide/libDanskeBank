package dk.mide.fas.danskebank.model;

import java.util.ArrayList;

public class Transactions extends Response {
	private ArrayList<Transaction> Transactions;

	public ArrayList<Transaction> getTransactions() {
		return Transactions;
	}

	public void setTransactions(ArrayList<Transaction> transactions) {
		Transactions = transactions;
	}
}
