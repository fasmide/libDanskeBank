package dk.mide.fas.danskebank.model;

public class Response {
	private String MagicKey;
	private String ServerTime;
	private String LoginType;
	private Status Status;
	public String getMagicKey() {
		return MagicKey;
	}
	public void setMagicKey(String magicKey) {
		MagicKey = magicKey;
	}
	public String getServerTime() {
		return ServerTime;
	}
	public void setServerTime(String serverTime) {
		ServerTime = serverTime;
	}
	public String getLoginType() {
		return LoginType;
	}
	public void setLoginType(String loginType) {
		LoginType = loginType;
	}
	public Status getStatus() {
		return Status;
	}
	public void setStatus(Status status) {
		Status = status;
	}
	
}
