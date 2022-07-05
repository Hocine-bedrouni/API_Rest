package aston.correction.config;

import aston.correction.entity.Adresse;
import aston.correction.repository.AdresseRepo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDataBase {

    private static final Logger log = LoggerFactory.getLogger(LoadDataBase.class);

    @Bean
    CommandLineRunner initDatabase(AdresseRepo adresseRepo) {

        return args -> {
            log.info("loading data" + adresseRepo.save(new Adresse("Rue Lamartine", "02854","jdod", "Rouen", "Mano")));
            log.info("loading data" + adresseRepo.save(new Adresse("Rue Lamartine", "85622","esdgh", "Bordeaux", "Mano")));
            log.info("loading data" + adresseRepo.save(new Adresse("Rue Lamartine", "59625","jkoisfsfj", "Marseille", "Mayo")));
            log.info("loading data" + adresseRepo.save(new Adresse("Rue Lamartine", "80440","gdfgdfg", "Paris", "Mytho")));
            log.info("loading data" + adresseRepo.save(new Adresse("Rue Lamartine", "25631","jkjhvooi", "Aix", "Calo")));
            log.info("loading data" + adresseRepo.save(new Adresse("Rue Lamartine", "89658","xcvxvsd", "Amiens", "Boulot")));
            log.info("loading data" + adresseRepo.save(new Adresse("Rue Lamartine", "13004","sdvdherh", "Lille", "Promo")));
        };

    }
}
