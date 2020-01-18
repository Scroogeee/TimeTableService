package chaumette.dsbservice.util;

import java.util.ArrayList;

public class Klassenliste extends ArrayList<String> {

	public boolean containsIgnoreCase (String klasse) {
		for (String s : this) {
			if (s.equalsIgnoreCase(klasse)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString () {
		return super.toString();
	}
}
