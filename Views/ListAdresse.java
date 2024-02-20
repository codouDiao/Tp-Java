package Views;

import java.util.List;
import java.util.Scanner;

import Entities.Adresse;

public class ListAdresse {

    private static final Scanner scanner = new Scanner(System.in);

    public static int getClientIdForAddressList() {
        System.out.print("Entrez l'ID du client pour afficher ses adresses : ");
        return scanner.nextInt();
    }

    public static void displayAdresses(List<Adresse> adresses) {
        if (adresses.isEmpty()) {
            System.out.println("Aucune adresse trouvée pour ce client.");
        } else {
            System.out.println("Liste des adresses pour ce client :");
            for (Adresse adresse : adresses) {
                System.out.println("ID: " + adresse.getId());
                System.out.println("Ville: " + adresse.getVille());
                System.out.println("Quartier: " + adresse.getQuartier());
                System.out.println("Numéro de villa: " + adresse.getNumVilla());
                System.out.println("-----------------------------");
            }
        }
    }
}
