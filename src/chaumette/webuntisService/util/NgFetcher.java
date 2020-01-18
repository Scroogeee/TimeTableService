package chaumette.webuntisService.util;

import chaumette.structures.Information;
import chaumette.webuntisService.NgConstants;
import chaumette.webuntisService.structures.NGReplacement;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;

public class NgFetcher {

	public ArrayList<NGReplacement> fetchReplacements () {
		ArrayList<NGReplacement> list = new ArrayList<>();
		Document doc1 = null;
		try {
			doc1 = Jsoup.connect(NgConstants.loginPage).get();
		} catch (HttpStatusException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		//TODO implement new webuntis functionality
		/*int counter = 1;
		while (true) {
			String page1 = NgConstants.pageBase1 + counter + ".htm";
			System.out.println(page1);
			Document doc1 = null;
			try {
				doc1 = Jsoup.connect(page1).get();
			} catch (HttpStatusException ex) {
				if (ex.getStatusCode() == 404) {
					break;
				}
				ex.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			ArrayList<Element> elements1 = NgParser.parseElementsFrom(doc1);

			ArrayList<NGReplacement> replacements1 = NgParser.extractVertretungenFrom(elements1.get(0));
			list.addAll(replacements1);
			counter++;
		}*/
		return list;
	}

	//TODO fetch the daily news
	public ArrayList<Information> fetchDailyNews () {
		ArrayList<Information> today = new ArrayList<>();
		return today;
	}

}
