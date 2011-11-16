package dk.mide.fas.danskebank.model;

public class Status {
	private Integer StatusCode;
	private String StatusText;
	public Integer getStatusCode() {
		return StatusCode;
	}
	public void setStatusCode(Integer statusCode) {
		StatusCode = statusCode;
	}
	public String getStatusText() {
		return StatusText;
	}
	public void setStatusText(String statusText) {
		StatusText = statusText;
	}
}
