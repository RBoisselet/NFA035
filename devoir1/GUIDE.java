import java.util.*;

public class GUIDE {

	private static char displayMenu() {
		System.out.println("");
		System.out.println(String.join("", Collections.nCopies(40, "-")));
		System.out.println("               Menu               ");
		System.out.println(String.join("", Collections.nCopies(40, "-")));
		System.out.println("a) Paramétrer le guide départemental");
		System.out.println("b) Afficher le guide");
		System.out.println("c) Afficher les hôtels d'une ville");
		System.out.println("d) Afficher le nombre total de clients");
		System.out.println("e) Quitter");
		return (Character.toLowerCase(Lire.c()));
	}


	public static void main(String[] args) {
		boolean guide = false;
		DEPARTEMENT dep = new DEPARTEMENT();

		char choice = Character.toLowerCase(displayMenu());
		while (choice != 'e') {
			switch (choice) {
				case 'a':
					if (guide) {
						System.out.println("Un guide est déjà en cours d'édition,"
						+" vous l'écraserer en continuant. Voulez-vous quand même continuer ? (o/n)");
							if (Character.toLowerCase(Lire.c()) == 'o') {
								dep.setData();
							}
					} else {
						guide = true;
						dep.setData();
					}
					break;
				case 'b':
					dep.displayDep();
					break;
				case 'c':
					System.out.println("Entrez le nom de la ville :");
					dep.displayByCity(Lire.S());
					break;
				case 'd':
					dep.displayClients();
					break;
				case 'e':
					System.exit(0);
					break;
				default:
					System.out.println("Option invalide");
					break;
			}
			choice = Character.toLowerCase(displayMenu());
		}
	}
}
