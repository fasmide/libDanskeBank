package dk.mide.fas.danskebank.model;

public class Account {
	private String AccountId;
	private String AccountName;
	private String AccountNumber;
	private float AvailableAmount;
	private float Balance;
	private boolean IsDelegateAccount;
	public String getAccountId() {
		return AccountId;
	}
	public void setAccountId(String accountId) {
		AccountId = accountId;
	}
	public String getAccountName() {
		return AccountName;
	}
	public void setAccountName(String accountName) {
		AccountName = accountName;
	}
	public String getAccountNumber() {
		return AccountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		AccountNumber = accountNumber;
	}
	public float getAvailableAmount() {
		return AvailableAmount;
	}
	public void setAvailableAmount(float availableAmount) {
		AvailableAmount = availableAmount;
	}
	public float getBalance() {
		return Balance;
	}
	public void setBalance(float balance) {
		Balance = balance;
	}
	public boolean isIsDelegateAccount() {
		return IsDelegateAccount;
	}
	public void setIsDelegateAccount(boolean isDelegateAccount) {
		IsDelegateAccount = isDelegateAccount;
	}
	
}
