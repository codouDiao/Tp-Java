package Views;

import java.util.Scanner;

import Entities.Adresse;
import Services.AdresseService;

public class CreateAdresse {

    private final AdresseService adresseService;
    private final Scanner scanner;

    public CreateAdresse(AdresseService adresseService) {
        this.adresseService = adresseService;
        this.scanner = new Scanner(System.in);
    }

    public void createAdresseView() {
        Adresse adresse = new Adresse();

        System.out.print("Ville: ");
        adresse.setVille(scanner.next());

        System.out.print("Quartier: ");
        adresse.setQuartier(scanner.next());

        System.out.print("Numéro de villa: ");
        adresse.setNumVilla(scanner.next());

        // Vous devez obtenir le clientId de quelque part (peut-être à partir de
        // l'utilisateur)
        System.out.print("ID du client: ");
        adresse.setClientId(scanner.nextInt());

        adresseService.addAdresse(adresse);
        System.out.println("Adresse ajoutée avec succès !");
    }
}