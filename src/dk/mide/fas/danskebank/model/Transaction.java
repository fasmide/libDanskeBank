package dk.mide.fas.danskebank.model;

public class Transaction {
	private float Amount;
	private float Balance;
	private String StateText;
	private String Text;
	private String Time;
	private String TransactionId;
	public float getAmount() {
		return Amount;
	}
	public void setAmount(float amount) {
		Amount = amount;
	}
	public float getBalance() {
		return Balance;
	}
	public void setBalance(float balance) {
		Balance = balance;
	}
	public String getStateText() {
		return StateText;
	}
	public void setStateText(String stateText) {
		StateText = stateText;
	}
	public String getText() {
		return Text;
	}
	public void setText(String text) {
		Text = text;
	}
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time = time;
	}
	public String getTransactionId() {
		return TransactionId;
	}
	public void setTransactionId(String transactionId) {
		TransactionId = transactionId;
	}
}
