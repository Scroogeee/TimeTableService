package chaumette.webuntisService.util;

import chaumette.webuntisService.structures.NGReplacement;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public abstract class NgParser {

	public static ArrayList<Element> parseElementsFrom (Document document) {
		Elements elements = document.select("table.mon_list");
		return new ArrayList<>(elements);
	}

	/**
	 * this method extracts DSBReplacement objects from a table element
	 *
	 * @param table the table to extrcat DSBReplacement objects from
	 * @return an ArrayList of the extrcated DSBReplacement objects
	 */
	public static ArrayList<NGReplacement> extractVertretungenFrom (Element table) throws IndexOutOfBoundsException {
		ArrayList<NGReplacement> vertretungen = new ArrayList<>();
		Elements rows = table.select("tr");
		for (int i = 1; i < rows.size(); i++) { //first row is the col names so skip it.
			Element row = rows.get(i);
			Elements cols = row.select("td");
			NGReplacement replacement = new NGReplacement(
					cols.get(0).text(),
					cols.get(1).text(),
					cols.get(2).text(),
					cols.get(3).text(),
					cols.get(4).text(),
					cols.get(5).text(),
					cols.get(6).text(),
					cols.get(7).text(),
					cols.get(8).text(),
					cols.get(9).text());
			vertretungen.add(replacement);
		}
		return vertretungen;
	}
}
