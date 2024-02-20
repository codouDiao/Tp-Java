package Views;

import java.util.Scanner;

import Repositories.AdresseRepository;
import Repositories.ClientRepository;
import Services.AdresseService;
import Services.ClientService;

public class MainMenu {

    public static void main(String[] args) {
        ClientRepository clientRepository = new ClientRepository();
        AdresseRepository adresseRepository = new AdresseRepository();
        ClientService clientService = new ClientService(clientRepository);
        AdresseService adresseService = new AdresseService(adresseRepository);

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Menu principal :");
            System.out.println("1. Créer un Client");
            System.out.println("2. Lister les Clients");
            System.out.println("3. Ajouter une adresse et lui associer un client");
            System.out.println("4. Lister les adresses en affichant le nom du client");
            System.out.println("5. Quitter");

            System.out.print("Choix : ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    CreateClient.getNewClientDetails(clientService);
                    break;
                case 2:
                    ListClient.listClientsView(clientService);
                    break;
                case 3:
                    CreateAdresse.createAdresse(adresseService, clientService);
                    break;
                case 4:
                    ListAdresse.listAdresses(adresseService);
                    break;
                case 5:
                    System.out.println("Quitter l'application.");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }

        } while (choice != 5);
    }
}
