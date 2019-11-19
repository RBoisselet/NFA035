import java.util.*;

public class VILLE {
	private HashSet <String> _hotelList;
	private String _city_name;

	public VILLE(String city_name) {
		this._city_name = city_name;
		this._hotelList = new HashSet <String>();
	}

	public void addHotels() {
		char choice;

		System.out.println("Voulez-vous ajouter un hôtel à " + this._city_name + " ? (o/n)");
		choice = Lire.c();
		while (Character.toLowerCase(choice) == 'o') {
			this._addHotel();
			System.out.println("Voulez-vous ajouter un hôtel à " + this._city_name + " ? (o/n)");
			choice = Lire.c();
		}
	}

	private void _addHotel() {
		String desc = new String();
		System.out.println("Entrez la description de l'hôtel ('nom;adresse;nombre de clients')");
		desc = Lire.S();
		this._hotelList.add(desc);
	}

	public void displayHotels() {
		String[] current_hotel;
		Iterator<String> iter;
		iter = this._hotelList.iterator();

		System.out.println("Liste des hôtels de "+this._city_name);
		System.out.println(String.join("", Collections.nCopies(10, "-")));
		while (iter.hasNext()) {
			current_hotel = iter.next().split(";");
			System.out.println("Nom : "+current_hotel[0]
			+", adresse : "+current_hotel[1]+ " ("+current_hotel[2]+" client(s))");
		}
	}

	public int getClients() {
		String[] current_hotel;
		Iterator<String> iter;
		int sum = 0;
		iter = this._hotelList.iterator();
		while (iter.hasNext()) {
			current_hotel = iter.next().split(";");
			sum += Integer.parseInt(current_hotel[2]);
		}
		return sum;
	}
}

