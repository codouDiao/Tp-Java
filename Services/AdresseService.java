package Services;

import java.util.List;

import Entities.Adresse;
import Repositories.AdresseRepository;

public class AdresseService {

    private final AdresseRepository adresseRepository;

    public AdresseService(AdresseRepository adresseRepository) {
        this.adresseRepository = adresseRepository;
    }

    public void addAdresse(Adresse adresse) {
        adresseRepository.addAdresse(adresse);
    }

    public List<Adresse> getAdressesByClientId(int clientId) {
        return adresseRepository.getAdressesByClientId(clientId);

    }

}
