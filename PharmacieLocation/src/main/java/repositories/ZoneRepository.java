package repositories;


import entities.Zone;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ZoneRepository extends JpaRepository<Zone, Integer> {
    // Ajoutez des méthodes de requête personnalisées si nécessaire
	@Query("select z from Zone z where z.ville.id =:id")
	List<Zone> findAllZoneByVille(@Param("id") int id);

	@Query("select z.nom ,(select count(p) from Pharmacie p where p.zone.id=z.id and p.etat=1) from Zone z where z.ville.id=:id group by z.nom")
	List findNbrPharmacieZone(@Param("id") int id);
}