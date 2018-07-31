package chaumette.ngservice.util;

import chaumette.ngservice.NgConstants;
import chaumette.ngservice.structures.NGReplacement;
import chaumette.structures.Information;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;

public class NgFetcher {

	public ArrayList<NGReplacement> fetchReplacements () {
		ArrayList<NGReplacement> list = new ArrayList<>();
		int counter = 1;
		while (true) {
			String page1 = NgConstants.pageBase1 + counter + ".htm";
			//TODO remove debug
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
		}
		return list;
	}

	//TODO remove stub
	public ArrayList<Information> fetchDailyNews () {
		ArrayList<Information> today = new ArrayList<>();
		return today;
	}

}
