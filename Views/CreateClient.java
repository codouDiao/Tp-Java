package Views;

import java.util.Scanner;

import Entities.Client;

public class CreateClient {

    private static final Scanner scanner = new Scanner(System.in);

    public static Client getNewClientDetails() {
        Client newClient = new Client();

        System.out.println("Création d'un nouveau client :");
        System.out.print("Nom Complet : ");
        newClient.setNomComplet(scanner.nextLine());

        System.out.print("Téléphone : ");
        newClient.setTelephone(scanner.nextLine());

        System.out.print("Email : ");
        newClient.setEmail(scanner.nextLine());

        return newClient;
    }
}
