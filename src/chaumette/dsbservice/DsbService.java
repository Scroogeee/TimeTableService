package chaumette.dsbservice;

import chaumette.dsbservice.structures.DSBReplacement;
import chaumette.dsbservice.util.DsbFetcher;
import chaumette.structures.Information;

import java.io.*;
import java.util.ArrayList;

public class DsbService {

	private DsbFetcher fetcher = new DsbFetcher();

	private ArrayList<DSBReplacement> replacementsToday = new ArrayList<>();
	private ArrayList<Information> newsToday = new ArrayList<>();
	private ArrayList<DSBReplacement> replacementsTomorrow = new ArrayList<>();
	private ArrayList<Information> newsTomorrow = new ArrayList<>();

	public void start (String[] args) {
		refreshReplacements();
		refreshNews();
	}

	private void refreshNews () {
		ArrayList<ArrayList<Information>> newsTables = fetcher.fetchDailyNews();
		newsToday = newsTables.get(0);
		newsTomorrow = newsTables.get(1);
	}

	private void refreshReplacements () {
		ArrayList<ArrayList<DSBReplacement>> lists = fetcher.fetchReplacements();
		replacementsToday = lists.get(0);
		replacementsTomorrow = lists.get(1);
		//TODO remove stub
		System.out.println("Heute:");
		printVertretungen(replacementsToday);
		writeVertretungenToFile(replacementsToday, "entries/Heute.txt");
		System.out.println();
		System.out.println("Morgen:");
		printVertretungen(replacementsTomorrow);
		writeVertretungenToFile(replacementsTomorrow, "entries/Morgen.txt");
	}


	/**
	 * @param replacements the ArrayList to print
	 */
	public void printVertretungen (ArrayList<DSBReplacement> replacements) {
		for (DSBReplacement v : replacements) {
			System.out.println(v);
		}
	}

	/**
	 * @param replacements the ArrayList to print
	 */
	public void writeVertretungenToFile (ArrayList<DSBReplacement> replacements, String filename) {
		try (Writer writer = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(filename), "utf-8"))) {
			for (DSBReplacement v : replacements) {
				writer.write(v.toString());
				((BufferedWriter) writer).newLine();
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param klasse       the class to search for
	 * @param replacements the list to search in
	 */
	public ArrayList<DSBReplacement> getVertretungenFromKlasse (String klasse, ArrayList<DSBReplacement> replacements) {
		ArrayList<DSBReplacement> filtered = new ArrayList<>();
		for (DSBReplacement v : replacements) {
			if (v.getKlasse().equalsIgnoreCase(klasse)) {
				filtered.add(v);
			}
		}
		return filtered;
	}


	public ArrayList<DSBReplacement> getReplacementsToday () {
		return replacementsToday;
	}

	public ArrayList<DSBReplacement> getReplacementsTomorrow () {
		return replacementsTomorrow;
	}


}
