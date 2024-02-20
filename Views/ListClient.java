package Views;

import java.util.List;

import Entities.Client;

public class ListClient {

    public static void displayClients(List<Client> clients) {
        System.out.println("Liste des clients :");
        for (Client client : clients) {
            System.out.println("ID : " + client.getId() +
                    ", Nom Complet : " + client.getNomComplet() +
                    ", Téléphone : " + client.getTelephone() +
                    ", Email : " + client.getEmail());
        }
    }
}
