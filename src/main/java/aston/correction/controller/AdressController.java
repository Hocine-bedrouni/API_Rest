package aston.correction.controller;

import aston.correction.entity.Adresse;
import aston.correction.service.AdresseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/adress")
public class AdressController {

    @Autowired
    private AdresseService adresseService;

    @GetMapping("")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Adresse> findAll(){return this.adresseService.findAll();}

    @GetMapping("/cp/{codepostal}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Adresse> findByCodePostal(@PathVariable String codePostal) { return this.adresseService.findByCodePostal(codePostal);
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Adresse findById(@PathVariable Long id) { return this.adresseService.findById(id);
    }

    @GetMapping("/ville/{ville}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Adresse> findByVille(@PathVariable String ville) { return this.adresseService.findByVille(ville);}

    @PostMapping("")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Adresse create(@RequestBody Adresse newAdress) { return this.adresseService.create(newAdress);}

    @PostMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Adresse update(@RequestBody Adresse adresse, @PathVariable Long id) {
        if(!id.equals(adresse.getId())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Mauvaise adresse mise à jour");
        }
        return  this.adresseService.update(adresse);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Adresse delete(@PathVariable Long id){ return this.adresseService.delete(id);}


}
