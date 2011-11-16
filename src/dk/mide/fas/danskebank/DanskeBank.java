package dk.mide.fas.danskebank;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import dk.mide.fas.danskebank.model.*;
import android.os.Build;

import com.google.gson.Gson;

public class DanskeBank {
	private String lastMagicKey;
	private Gson gson;
	private static final String CREATESESSION_URL = "https://mb.danskebank.dk/smartphones/gmb.svc/CreateSession";
	private static final String LOGIN_URL = "https://mb.danskebank.dk/smartphones/gmb.svc/Login";
	private static final String ACCOUNT_URL = "https://mb.danskebank.dk/smartphones/gmb.svc/Accounts";
	/**
	 * Starter en session med danskebank's webservice
	 * @throws Exception
	 */
	public DanskeBank() throws Exception {
		gson = new Gson();
		processResponse(createSession());
	}
	/**
	 * Get the newest 20 transactions
	 * @param accountId
	 * @return
	 * @throws Exception
	 */
	public Transactions getTransactions(String accountId) throws Exception {
			
		String url = ACCOUNT_URL;
		url += "/" + accountId + "/Transactions/Current" 
		+ "?magicKey=" + URLEncoder.encode(lastMagicKey, "UTF-8")
		+ "&pageSize=20"
		+ "&pageNumber=0"
		+ "&searchText=";
		return doGetTransactions(url);
	}
	/**
	 * Search for transactions in a given account
	 * @param accountId
	 * @param searchText
	 * @return
	 * @throws Exception
	 */
	public Transactions getTransactions(String accountId, String searchText) throws Exception {
		
		String url = ACCOUNT_URL;
		url += "/" + accountId + "/Transactions/Current" 
		+ "?magicKey=" + URLEncoder.encode(lastMagicKey, "UTF-8")
		+ "&pageSize=20"
		+ "&pageNumber=0"
		+ "&searchText=" + URLEncoder.encode(searchText, "UTF-8");
		return doGetTransactions(url);
	}
	/**
	 * get the x transactions starting at page y from account
	 * @param accountId
	 * @param size
	 * @param pageno
	 * @return
	 * @throws Exception
	 */
	public Transactions getTransactions(String accountId, int size, int pageno) throws Exception {
		String url = ACCOUNT_URL;
		url += "/" + accountId + "/Transactions/Current" 
		+ "?magicKey=" + URLEncoder.encode(lastMagicKey, "UTF-8")
		+ "&pageSize=" + size
		+ "&pageNumber=" + pageno
		+ "&searchText=";
		return doGetTransactions(url);
	}
	/**
	 * Search an account with x results starting from page y.
	 * @param accountId
	 * @param size
	 * @param pageno
	 * @param searchText
	 * @return
	 * @throws Exception
	 */
	public Transactions getTransactions(String accountId, int size, int pageno, String searchText) throws Exception {
		String url = ACCOUNT_URL;
		url += "/" + accountId + "/Transactions/Current" 
		+ "?magicKey=" + URLEncoder.encode(lastMagicKey, "UTF-8")
		+ "&pageSize=" + size
		+ "&pageNumber=" + pageno
		+ "&searchText=" + URLEncoder.encode(searchText, "UTF-8");
		return doGetTransactions(url);
	}

	private Transactions doGetTransactions(String url) throws Exception
	{
		
		HttpsURLConnection connection = 
				(HttpsURLConnection) new URL(url).openConnection();		
		
		InputStreamReader reader = new InputStreamReader(connection.getInputStream());
		Transactions s = gson.fromJson(reader, Transactions.class);
		
		reader.close();
		connection.disconnect();
		
		//gem den nye n¿gle
		processResponse(s);
		
		return s;
	}

	
	/**
	 * Henter konti 
	 * @return returnere et Accounts object.
	 * @throws Exception
	 */
	public Accounts getAccounts() throws Exception {
		HttpsURLConnection connection = 
				(HttpsURLConnection) new URL(
						ACCOUNT_URL
						+ "?magicKey=" + URLEncoder.encode(lastMagicKey, "UTF-8")
						).openConnection();		
		
		InputStreamReader reader = new InputStreamReader(connection.getInputStream());
		Accounts s = gson.fromJson(reader, Accounts.class);
		
		reader.close();
		connection.disconnect();
		
		//gem den nye n¿gle
		processResponse(s);
		
		return s;			
	}
	
	
	/**
	 * Logger ind 
	 * @param loginId cpr nummer
	 * @param pinCode mobil bank aftale pinkode
	 * @return login object
	 * @throws Exception
	 */
	public Login login(String loginId, String pinCode) throws Exception {
		HttpsURLConnection connection = 
			(HttpsURLConnection) new URL(
					LOGIN_URL
					+ "?magicKey=" + URLEncoder.encode(lastMagicKey, "UTF-8")
					).openConnection();
		
		connection.setDoOutput(true);
		connection.setFixedLengthStreamingMode(0);
		connection.setRequestProperty("Content-Type", "text/json");
		OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
		out.write(gson.toJson(getLoginRequestData(loginId, pinCode))); 
		out.flush();
		
		InputStreamReader reader = new InputStreamReader(connection.getInputStream());
		Login s = gson.fromJson(reader, Login.class);
		
		out.close();
		reader.close();
		connection.disconnect();
		
		//gem den nye n¿gle
		processResponse(s);
		
		return s;		
		
	}
	private Map<String, String> getLoginRequestData(String loginId, String loginCode) {
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("loginId", loginId);
		data.put("loginCode", loginCode);
		return (Map<String, String>) data;
	}
	private void processResponse(Response response) throws Exception
	{
		Status s = response.getStatus();
		if(s.getStatusCode() != 0)
		{
			throw new Exception("Got error: " + s.getStatusText());
		}
		if(response.getMagicKey() == null)
		{
			throw new Exception("Got no new magic key");
		}
		lastMagicKey = response.getMagicKey();
	}
	private Map<String, String> getSessionRequestData() {
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("os", "Android");
		data.put("model", Build.MODEL);
		data.put("osVersion", Build.VERSION.RELEASE);
		data.put("appVersion", "2.3");
		data.put("manufacturer", Build.MANUFACTURER);
		data.put("logSession", "false");
		data.put("language", "DK");
		//data.put("deviceId", )
		data.put("country", "DK");
		return (Map<String, String>) data;
	}
	private Session createSession() throws Exception
	{
		
		HttpsURLConnection connection = 
				(HttpsURLConnection) new URL(CREATESESSION_URL).openConnection();
		connection.setDoOutput(true);
		connection.setFixedLengthStreamingMode(0);
		connection.setRequestProperty("Content-Type", "text/json");
		OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
		out.write(gson.toJson(getSessionRequestData()));
		out.flush();
		
		InputStreamReader reader = new InputStreamReader(connection.getInputStream());
		Session s = gson.fromJson(reader, Session.class);
		
		out.close();
		reader.close();
		connection.disconnect();
		return s;
				
	}
}
