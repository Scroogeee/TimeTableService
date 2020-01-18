package chaumette.webuntisService.structures;

public class NGReplacement {

	private String nummer;
	private String klasse;
	private String stunde;
	private String fach;
	private String raum;
	private String von;
	private String nach;
	private String entfall;
	private String vertretungsText;
	private String mitbetreuung;

	public NGReplacement (String nummer, String klasse, String stunde, String fach,
	                      String raum, String von, String nach, String entfall,
	                      String vertretungsText, String mitbetreuung) {
		this.nummer = nummer;
		this.klasse = klasse;
		this.stunde = stunde;
		this.fach = fach;
		this.raum = raum;
		this.von = von;
		this.nach = nach;
		this.entfall = entfall;
		this.vertretungsText = vertretungsText;
		this.mitbetreuung = mitbetreuung;
	}

	public String getNummer () {
		return nummer;
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

	public String getRaum () {
		return raum;
	}

	public String getVon () {
		return von;
	}

	public String getNach () {
		return nach;
	}

	public String getEntfall () {
		return entfall;
	}

	public String getVertretungsText () {
		return vertretungsText;
	}

	public String getMitbetreuung () {
		return mitbetreuung;
	}

	@Override
	public String toString () {
		return nummer + " " + klasse + " " + stunde + " " + fach + " " + raum + " " +
				von + " " + nach + " " + entfall + " " + vertretungsText + " " + mitbetreuung;
	}
}
