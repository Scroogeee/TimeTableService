package chaumette.dsbservice.structures;

import chaumette.dsbservice.util.Klassenliste;

public class DSBReplacement {
	private Klassenliste klassen = new Klassenliste();
	private String stunde;
	private String fach;
	private String vertreter;
	private String raum;
	private String art;
	private String statt;
	private String vertretungsText;

	public DSBReplacement (String klasse, String stunde, String fach, String vertreter,
	                       String raum, String art, String statt, String vertretungsText) {
		parseKlassen(klasse);
		this.stunde = stunde;
		this.fach = fach;
		this.vertreter = vertreter;
		this.raum = raum;
		this.art = art;
		this.statt = statt;
		this.vertretungsText = vertretungsText;
	}

	private void parseKlassen (String s) {
		klassen.add(s);
		//TODO parse classes correctly
	}

	public Klassenliste getKlassen () {
		return klassen;
	}

	public String getStunde () {
		return stunde;
	}

	public String getFach () {
		return fach;
	}

	public String getVertreter () {
		return vertreter;
	}

	public String getRaum () {
		return raum;
	}

	public String getArt () {
		return art;
	}

	public String getStatt () {
		return statt;
	}

	public String getVertretungsText () {
		return vertretungsText;
	}

	@Override
	public String toString () {
		return klassen.toString() + " " +
				stunde + " " +
				fach + " " +
				vertreter + " " +
				raum + " " +
				art + " " +
				statt + " " +
				vertretungsText;
	}
}
