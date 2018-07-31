package chaumette.dsbservice.structures;

public class DSBReplacement {
	private String klasse;
	private String stunde;
	private String fach;
	private String vertreter;
	private String raum;
	private String art;
	private String statt;
	private String vertretungsText;

	public DSBReplacement (String klasse, String stunde, String fach, String vertreter,
	                       String raum, String art, String statt, String vertretungsText) {
		this.klasse = klasse;
		this.stunde = stunde;
		this.fach = fach;
		this.vertreter = vertreter;
		this.raum = raum;
		this.art = art;
		this.statt = statt;
		this.vertretungsText = vertretungsText;
	}

	public String getKlasse () {
		return klasse;
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
		return klasse + " " +
				stunde + " " +
				fach + " " +
				vertreter + " " +
				raum + " " +
				art + " " +
				statt + " " +
				vertretungsText;
	}
}
