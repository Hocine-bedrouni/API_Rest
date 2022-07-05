package aston.correction.service;

import aston.correction.entity.Adresse;
import aston.correction.repository.AdresseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
//import java.util.Optional;

@Service
public class AdresseService {

    @Autowired
    private AdresseRepo adresseRepo;

    public List<Adresse> findAll() {
        return this.adresseRepo.findAll();
    }

    public List<Adresse> findByCodePostal(String codePostal) {
        return this.adresseRepo.findByCodePostal(codePostal);
    }

    public Adresse findById(Long id) {
        Optional<Adresse> optAdresse2 = this.adresseRepo.findById(id);
        if (optAdresse2.isPresent()) {
            return optAdresse2.get();
        } else {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }


    public List<Adresse> findByVille(String ville) {
        return this.adresseRepo.findByVille(ville);
    }

    public Adresse create(Adresse newAdress) {
        return this.adresseRepo.save(newAdress);
    }

    public Adresse update(Adresse adress) {
        if (!this.adresseRepo.existsById(adress.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "impossible de trouver l'adresse à mettre à jour");
        } else {
            return this.adresseRepo.save(adress);
        }
    }


    public Adresse delete(Long id) {
        if (!this.adresseRepo.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "impossible de trouver l'adresse à supprimer");
        } else {
            Adresse adressDel = this.findById(id);
            this.adresseRepo.deleteById(id);
            if(this.adresseRepo.existsById(id)) {
                throw new ResponseStatusException(HttpStatus.EXPECTATION_FAILED, "erreur de la suppression de la guitare");
            }
            return adressDel;
        }
    }
}

