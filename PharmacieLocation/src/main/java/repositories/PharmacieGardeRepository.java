package repositories;

import entities.Pharmacie;
import entities.PharmacieGarde;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PharmacieGardeRepository extends JpaRepository<PharmacieGarde, PharmacieGarde> {

    List<PharmacieGarde> findAllByPharmacie(Pharmacie pharmacie);

    @Query("select pg from PharmacieGarde pg where CURRENT_DATE NOT BETWEEN pg.PharmacieGardeRelation.dateDebut and pg.dateFin")
    List<PharmacieGarde> findAllPharmacieDispo();

    @Query("select pg from PharmacieGarde pg where CURRENT_DATE BETWEEN pg.PharmacieGardeRelation.dateDebut and pg.dateFin ")
    List<PharmacieGarde> findAllPharmacieEnGarde();
    @Query("select pg from PharmacieGarde pg where (CURRENT_DATE BETWEEN pg.PharmacieGardeRelation.dateDebut and pg.dateFin) and pg.garde.idGarde = :id ")
    List<PharmacieGarde> findAllPharmacieGardeEnGardeByGardeId(@Param("id") int id);

    @Query("select pg from PharmacieGarde pg where pg.pharmacie.zone.ville.id =:id and CURRENT_DATE BETWEEN pg.PharmacieGardeRelation.dateDebut and pg.dateFin")
    List<PharmacieGarde> findAllPharmacieGardeByVille(@Param("id") int id);

    @Query("select pg from PharmacieGarde pg where pg.pharmacie.zone.id =:id and CURRENT_DATE BETWEEN pg.PharmacieGardeRelation.dateDebut and pg.dateFin")
    List<PharmacieGarde> findAllPharmacieGardeByZone(@Param("id") int id);

    @Query("select pg from PharmacieGarde pg where pg.garde.idGarde =:id and CURRENT_DATE BETWEEN pg.PharmacieGardeRelation.dateDebut and pg.dateFin")
    List<PharmacieGarde> findAllPharmacieGardeByType(@Param("id") int id);

    @Query("select pg from PharmacieGarde pg where pg.pharmacie.id =:id")
    List<PharmacieGarde> findPharmacieGardeHistorique(@Param("id") int id);

}