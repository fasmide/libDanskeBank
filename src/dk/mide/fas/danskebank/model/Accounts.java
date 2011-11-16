package dk.mide.fas.danskebank.model;

import java.util.ArrayList;

public class Accounts extends Response {
	private ArrayList<Account> Accounts;

	public ArrayList<Account> getAccounts() {
		return Accounts;
	}

	public void setAccounts(ArrayList<Account> accounts) {
		Accounts = accounts;
	}
	
	
}
