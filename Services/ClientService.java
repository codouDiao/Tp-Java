package Services;

import java.util.List;

import Entities.Client;
import Repositories.ClientRepository;

public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void addClient(Client client) {
        clientRepository.addClient(client);
    }

    public List<Client> listClients() {
        return clientRepository.listClients();
    }

}
