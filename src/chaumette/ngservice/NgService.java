package chaumette.ngservice;

import chaumette.ngservice.structures.NGReplacement;
import chaumette.ngservice.util.NgFetcher;
import chaumette.structures.Information;

import java.io.*;
import java.util.ArrayList;

public class NgService {

	private NgFetcher fetcher = new NgFetcher();

	private ArrayList<NGReplacement> replacementsTomorrow = new ArrayList<>();
	private ArrayList<Information> newsToday = new ArrayList<>();
	private ArrayList<NGReplacement> replacementsF = new ArrayList<>();

	public void start (String[] args) {
		refreshReplacements();
		refreshNews();
	}

	private void refreshNews () {
		ArrayList<Information> newsToday = fetcher.fetchDailyNews();
	}

	private void refreshReplacements () {
		replacementsTomorrow = fetcher.fetchReplacements();
		//TODO remove stub
		//System.out.println("Morgen:");
		//printVertretungen(replacementsTomorrow);
		writeVertretungenToFile(replacementsTomorrow, "entries/Morgen.txt");
		replacementsF = getVertretungenFromKlasse(NgConstants.klasseF, replacementsTomorrow);
	}


	/**
	 * @param replacements the ArrayList to print
	 */
	public void printVertretungen (ArrayList<NGReplacement> replacements) {
		for (NGReplacement v : replacements) {
			System.out.println(v);
		}
	}

	/**
	 * @param replacements the ArrayList to print
	 */
	public void writeVertretungenToFile (ArrayList<NGReplacement> replacements, String filename) {
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(filename), "utf-8"))) {
			for (NGReplacement v : replacements) {
				writer.write(v.toString());
				((BufferedWriter) writer).newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param klasse       the class to search for
	 * @param replacements the list to search in
	 */
	public ArrayList<NGReplacement> getVertretungenFromKlasse (String klasse, ArrayList<NGReplacement> replacements) {
		ArrayList<NGReplacement> filtered = new ArrayList<>();
		for (NGReplacement v : replacements) {
			if (v.getKlasse().equalsIgnoreCase(klasse)) {
				filtered.add(v);
			}
		}
		return filtered;
	}


	public ArrayList<NGReplacement> getReplacementsTomorrow () {
		return replacementsTomorrow;
	}

}
