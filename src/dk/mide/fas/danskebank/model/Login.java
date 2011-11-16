package dk.mide.fas.danskebank.model;

public class Login extends Response {
	private String BranchRegistrationNr;
	//Not sure what Challenge and data could be..
	private Object Challenge;
	private Object ChallengeData;
	private String Name;
	private String SecurityCardNumber;
	private String UserHash;
	public String getBranchRegistrationNr() {
		return BranchRegistrationNr;
	}
	public void setBranchRegistrationNr(String branchRegistrationNr) {
		BranchRegistrationNr = branchRegistrationNr;
	}
	public Object getChallenge() {
		return Challenge;
	}
	public void setChallenge(Object challenge) {
		Challenge = challenge;
	}
	public Object getChallengeData() {
		return ChallengeData;
	}
	public void setChallengeData(Object challengeData) {
		ChallengeData = challengeData;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getSecurityCardNumber() {
		return SecurityCardNumber;
	}
	public void setSecurityCardNumber(String securityCardNumber) {
		SecurityCardNumber = securityCardNumber;
	}
	public String getUserHash() {
		return UserHash;
	}
	public void setUserHash(String userHash) {
		UserHash = userHash;
	}
	
}
