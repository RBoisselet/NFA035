import java.util.*;

public class DEPARTEMENT {
	private String _dep_name;
	private HashMap<String, VILLE> _dep;

	public DEPARTEMENT() {
		System.out.println("Entrez le nom du département :");
		this._dep_name = Lire.S();
		this._dep = new HashMap<String, VILLE>();
	}

	public void setData() {
		char choice;
		System.out.println("Voulez-vous entrer une nouvelle ville ? (o/n)");
		choice = Lire.c();
		while (Character.toLowerCase(choice) == 'o') {
		System.out.println("Nom de la ville :");
		String city_name = Lire.S();
		VILLE temp = new VILLE(city_name);
		temp.addHotels();
		this._dep.put(city_name, temp);
		System.out.println("Voulez-vous entrer une nouvelle ville ? (o/n)");
		choice = Lire.c();
		}

	}
	
	public void displayByCity(String city_name) {
		Set<String> keys;
		Iterator<String> iter;
		String key;
		VILLE temp;
		boolean found = false;

		keys = this._dep.keySet();
		iter = keys.iterator();
		while (iter.hasNext()) {
			key = iter.next();
			if (key.equals(city_name)) {
				temp = this._dep.get(key);
				temp.displayHotels();
				System.out.println("");
				found = true;
			}
		}
		if (!found) {
			System.out.println("La liste cherchée n'est pas listée dans le guide");
		}
	}
	
	public void displayClients() {
		Set<String> keys;
		Iterator<String> iter;
		String key;
		VILLE temp;
		int clients = 0;

		keys = this._dep.keySet();
		iter = keys.iterator();
		while (iter.hasNext()) {
			key = iter.next();
			temp = this._dep.get(key);
			clients += temp.getClients();
		}
		System.out.println(clients);
	}

	public void displayDep() {
		Set<String> keys;
		Iterator<String> iter;
		String key;
		VILLE temp;

		keys = this._dep.keySet();
		iter = keys.iterator();
		System.out.println(String.join("", Collections.nCopies(40, "-")));
		System.out.println("Répertoire des hôtels du département " + this._dep_name + " :");
		System.out.println(String.join("", Collections.nCopies(40, "-")));
		while (iter.hasNext()) {
			key = iter.next();
			temp = this._dep.get(key);
			temp.displayHotels();
			System.out.println("");
		}
	}

}
