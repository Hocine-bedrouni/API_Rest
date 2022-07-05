package aston.correction.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import aston.correction.entity.Adresse;
import org.springframework.stereotype.Repository;

@Repository
public interface AdresseRepo extends JpaRepository<Adresse, Long> {
	
	List<Adresse> findByVille(String ville);

//	List<Adresse> findByCodePostal(String codePostal);


//	public Adresse findByCodePostal(String codepostal);
//
//
	public Optional <Adresse> findById(Long id);
	
	List<Adresse> findByVilleOrCodePostal(String ville, String codePostal);


	@Query("select p.adresse from Personne p where p.id = :id")
	Adresse findByPersonne(@Param("id") Long id);

//	@Query("select p.adresse from Personne p where p.adresse = :codePostal")
	public List<Adresse> findByCodePostal(String codepostal);

	@Query("select p.adresse from Personne p where p.id = :id")
	public Adresse delete(@Param("id") Long id);

//	@Query("select p.adresse from Personne p where p.id = :poulet3000")
//	public Adresse delete(@Param("poulet3000") Long id);


	// Pas besoin de préciser la requete kan l'attribut existe dans la classe "Adresse", ville, codepostal, etc...

}
