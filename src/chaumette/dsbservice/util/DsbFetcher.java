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
		//TODO run the main.js script somehow...

		String uuid = "295ea5e5-58c5-42a0-a5b9-0cddee240bab";
		uuid = "61d6aa78-9f6c-4e87-8169-aac26ef54357";
		return uuid;
	}

	public ArrayList<ArrayList<DSBReplacement>> fetchReplacements () {
		String uuid = getCurrentuuId();
		String currentPlansURL = DsbConstants.dsbAppURLBase + "/" +
				DsbConstants.kkstID + "/" + uuid + "/" + uuid + ".htm";
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

	//TODO fetch the daily news
	public ArrayList<ArrayList<Information>> fetchDailyNews () {
		ArrayList<Information> today = new ArrayList<>();
		ArrayList<Information> tomorrow = new ArrayList<>();
		ArrayList<ArrayList<Information>> dailyNews = new ArrayList<>();
		dailyNews.add(today);
		dailyNews.add(tomorrow);
		return dailyNews;
	}

}
