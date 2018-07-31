package chaumette.dsbservice.util;

import chaumette.dsbservice.DsbConstants;
import chaumette.dsbservice.structures.DSBReplacement;
import chaumette.structures.Information;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;

public class DsbFetcher {

	private String getCurrentuuId () {

	/*	final String USER_AGENT = "\"Mozilla/5.0 (Windows NT\" +\n" +
				"          \" 6.1; WOW64) AppleWebKit/535.2 (KHTML, like Gecko) Chrome/15.0.874.120 Safari/535.2\"";

		HashMap<String, String> cookies = new HashMap<>();
		HashMap<String, String> formData = new HashMap<>();

		Connection.Response loginForm = null;
		try {
			loginForm = Jsoup.connect(Constants.loginFormUrl).method(Connection.Method.GET).userAgent(USER_AGENT).execute();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			Document loginDoc = loginForm.parse(); // this is the document that contains response html
		} catch (IOException e) {
			e.printStackTrace();
		}

		cookies.putAll(loginForm.cookies()); // save the cookies, this will be passed on to next request

		formData.put("__LASTFOCUS", "");
		formData.put("__VIEWSTATE", "/wEPDwULLTEyMzYwNjY5NTAPZBYCAgMPFgIeBXN0eWxlBS1iYWNrZ3JvdW5kLWltYWdlOnVybCgnaW1nL2JnX21vcm5pbmcuanBnJyk7KTsWAgIBD2QWAgIJDxYCHgRUZXh0BQRXRUIxZGSMfTgikQHHtJ8LiyhP37qHhdM+X6pl4nCavhgeI0+dEQ==");
		formData.put("__VIEWSTATEGENERATOR", "C2EE9ABB");
		formData.put("__EVENTTARGET", "");
		formData.put("__EVENTARGUMENT", "");
		formData.put("__EVENTVALIDATION", "/wEdAAR0omk/mMShKYMbKmeVxkK0DFTzKcXJqLg+OeJ6QAEa2kPTPkdPWl+8YN2NtDCtxic2kbNk7CH1EMXf+0xXlqLz4gPXwUdFRlsLoTshgr03M89+Mi8UNtGdI/d4V6QUsjE=");


		formData.put(Constants.userform, Constants.username);
		formData.put(Constants.passform, Constants.password);
		formData.put(Constants.submitform, "Anmelden");


		Connection.Response homePage = null;
		try {
			homePage = Jsoup.connect(Constants.loginActionUrl)
					.cookies(cookies)
					.data(formData)
					.followRedirects(true)
					.method(Connection.Method.POST)
					.userAgent(USER_AGENT)
					.execute();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(homePage.body());
*/


		//TODO implement stub
		String uuid = "295ea5e5-58c5-42a0-a5b9-0cddee240bab";
		return uuid;
	}

	public ArrayList<ArrayList<DSBReplacement>> fetchReplacements () {
		String uuid = getCurrentuuId();
		String currentPlansURL = DsbConstants.cleanPageBaseString + "/" + uuid + "/" + uuid + ".htm";
		System.out.println(currentPlansURL);
		Document doc = null;
		try {
			doc = Jsoup.connect(currentPlansURL).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		ArrayList<Element> elements = DsbParser.parseElementsFrom(doc);
		ArrayList<DSBReplacement> today = DsbParser.extractVertretungenFrom(elements.get(0));
		ArrayList<DSBReplacement> tomorrow = DsbParser.extractVertretungenFrom(elements.get(1));
		ArrayList<ArrayList<DSBReplacement>> list = new ArrayList<>();
		list.add(today);
		list.add(tomorrow);
		return list;
	}

	//TODO remove stub
	public ArrayList<ArrayList<Information>> fetchDailyNews () {
		ArrayList<Information> today = new ArrayList<>();
		ArrayList<Information> tomorrow = new ArrayList<>();
		ArrayList<ArrayList<Information>> dailyNews = new ArrayList<>();
		dailyNews.add(today);
		dailyNews.add(tomorrow);
		return dailyNews;
	}

}
