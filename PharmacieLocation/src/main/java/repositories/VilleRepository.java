package repositories;



import entities.Ville;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VilleRepository extends JpaRepository<Ville, Integer> {
 // Ajoutez des méthodes de requête personnalisées si nécessaire
	 @Query("select v.nom ,(select count(p) from Pharmacie p where p.zone.ville.id=v.id and p.etat=1) from Ville v group by v.nom")
	    List<Object> findNbrPharmacieVille();

	    @Query("select v.nom ,(select count(pg) from PharmacieDeGarde pg where pg.pharmacie.zone.ville.id=v.id and CURRENT_DATE BETWEEN pg.PharmacieDeGardeRelation.dateDebut and pg.dateFin) from Ville v group by v.nom")
	    List<Object> findNbrPharmacieGardeVille();
}

